package com.littlefisher.core.mybatis.generator;

import static org.mybatis.generator.api.dom.OutputUtilities.calculateImports;
import static org.mybatis.generator.api.dom.OutputUtilities.javaIndent;
import static org.mybatis.generator.api.dom.OutputUtilities.newLine;
import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.mybatis.generator.api.JavaFormatter;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaDomUtils;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.Context;

import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.littlefisher.core.common.utils.CollectionUtil;

/**
 * Description: 对import导入的包进行排序
 *
 * Created on 2017年3月9日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class SortImportsAndFieldsJavaFormatter implements JavaFormatter {

    /**
     * context
     */
    protected Context context;

    @Override
    public String getFormattedContent(CompilationUnit compilationUnit) {
        if (compilationUnit instanceof TopLevelClass) {
            formatFields(compilationUnit);
            return this.getClassFormattedContent(compilationUnit);
        } else if (compilationUnit instanceof Interface) {
            return this.getInterfaceFormattedContent(compilationUnit);
        } else {
            return compilationUnit.getFormattedContent();
        }
    }

    /**
     * 对model中的field顺序进行重构
     * 把serialVersionUID放在首位
     */
    private void formatFields(CompilationUnit compilationUnit) {
        String serializableFieldName = "serialVersionUID";
        TopLevelClass topLevelClass = (TopLevelClass) compilationUnit;
        Ordering<Field> ordering = new Ordering<Field>() {
            @Override
            public int compare(Field left, Field right) {
                if (serializableFieldName.equals(left.getName())) {
                    return -1;
                } else if (serializableFieldName.equals(right.getName())) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        List<Field> fieldList = ordering.sortedCopy(topLevelClass.getFields());
        topLevelClass.getFields().clear();
        topLevelClass.getFields().addAll(fieldList);
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * Description: 接口format
     */
    private String getInterfaceFormattedContent(CompilationUnit compilationUnit) {
        StringBuilder sb = new StringBuilder();

        Interface interfaceClazz = (Interface) compilationUnit;

        interfaceClazz.getFileCommentLines().forEach(commentLine -> {
            sb.append(commentLine);
            newLine(sb);
        });

        formatPackage(sb, interfaceClazz.getType().getPackageName());

        formatStaticImports(sb, interfaceClazz.getStaticImports());

        if (interfaceClazz.getStaticImports().size() > 0) {
            newLine(sb);
        }

        Set<String> importStrings = calculateImports(interfaceClazz.getImportedTypes());
        this.sortImportTypes(sb, importStrings);

        if (CollectionUtil.isNotEmpty(importStrings)) {
            newLine(sb);
        }

        int indentLevel = 0;

        interfaceClazz.addFormattedJavadoc(sb, indentLevel);
        interfaceClazz.addFormattedAnnotations(sb, indentLevel);

        sb.append(interfaceClazz.getVisibility().getValue());

        if (interfaceClazz.isStatic()) {
            sb.append("static ");
        }

        if (interfaceClazz.isFinal()) {
            sb.append("final ");
        }

        sb.append("interface ");
        sb.append(interfaceClazz.getType().getShortName());

        if (interfaceClazz.getSuperInterfaceTypes().size() > 0) {
            sb.append(" extends ");

            boolean comma = false;
            for (FullyQualifiedJavaType fqjt : interfaceClazz.getSuperInterfaceTypes()) {
                if (comma) {
                    sb.append(", ");
                } else {
                    comma = true;
                }

                sb.append(JavaDomUtils.calculateTypeName(interfaceClazz, fqjt));
            }
        }

        sb.append(" {");
        indentLevel++;

        Iterator<Method> mtdIter = interfaceClazz.getMethods().iterator();
        while (mtdIter.hasNext()) {
            newLine(sb);
            Method method = mtdIter.next();
            sb.append(method.getFormattedContent(indentLevel, true, interfaceClazz));
            if (mtdIter.hasNext()) {
                newLine(sb);
            }
        }

        indentLevel--;
        newLine(sb);
        javaIndent(sb, indentLevel);
        sb.append('}');

        return sb.toString();
    }

    private void formatStaticImports(StringBuilder sb, Set<String> staticImports) {
        staticImports.forEach(staticImport -> {
            sb.append("import static ");
            sb.append(staticImport);
            sb.append(';');
            newLine(sb);
        });
    }

    /**
     * Description: 类format
     */
    private String getClassFormattedContent(CompilationUnit compilationUnit) {
        StringBuilder sb = new StringBuilder();

        TopLevelClass topLevelClass = (TopLevelClass) compilationUnit;

        topLevelClass.getFileCommentLines().forEach(fileCommentLine -> {
            sb.append(fileCommentLine);
            newLine(sb);
        });

        formatPackage(sb, topLevelClass.getType().getPackageName());

        formatStaticImports(sb, topLevelClass.getStaticImports());

        if (topLevelClass.getStaticImports().size() > 0) {
            newLine(sb);
        }

        Set<String> importStrings = calculateImports(topLevelClass.getImportedTypes());

        sortImportTypes(sb, importStrings);

        if (importStrings.size() > 0) {
            newLine(sb);
        }

        sb.append(topLevelClass.getFormattedContent(0, compilationUnit));

        return sb.toString();
    }

    private void formatPackage(StringBuilder sb, String packageName) {
        if (stringHasValue(packageName)) {
            sb.append("package ");
            sb.append(packageName);
            sb.append(';');
            newLine(sb);
            newLine(sb);
        }
    }

    /**
     * Description: 格式化import
     *
     * @param sb sb
     * @param importStrings <br>
     */
    private void sortImportTypes(StringBuilder sb, Set<String> importStrings) {
        Set<String> javaTypes = Sets.newTreeSet();
        Set<String> javaxTypes = Sets.newTreeSet();
        Set<String> orgTypes = Sets.newTreeSet();
        Set<String> otherTypes = Sets.newTreeSet();
        Set<String> comTypes = Sets.newTreeSet();

        for (String importType : importStrings) {
            if (importType.startsWith("import javax")) {
                javaxTypes.add(importType);
            } else if (importType.startsWith("import java")) {
                javaTypes.add(importType);
            } else if (importType.startsWith("import org")) {
                orgTypes.add(importType);
            } else if (importType.startsWith("import com")) {
                comTypes.add(importType);
            } else {
                otherTypes.add(importType);
            }
        }

        generateImports(sb, javaTypes);

        generateImports(sb, javaxTypes);

        generateImports(sb, orgTypes);

        generateImports(sb, comTypes);

        generateImports(sb, otherTypes);
    }

    /**
     * 组装import内容
     *
     * @param sb import内容
     * @param javaTypes javaTypes
     */
    private void generateImports(StringBuilder sb, Set<String> javaTypes) {
        javaTypes.forEach(importType -> {
            sb.append(importType);
            newLine(sb);
        });

        if (javaTypes.size() > 0) {
            newLine(sb);
        }
    }

}
