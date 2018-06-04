package com.littlefisher.core.mybatis.generator;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.mybatis.generator.api.JavaFormatter;
import org.mybatis.generator.api.dom.OutputUtilities;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaDomUtils;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.util.StringUtility;

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
     * 对model中的field顺序进行重构 把serialVersionUID放在首位
     *
     * @param compilationUnit compilationUnit
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
     * 接口format
     * 
     * @param compilationUnit compilationUnit
     * @return 文件String类型
     */
    private String getInterfaceFormattedContent(CompilationUnit compilationUnit) {
        StringBuilder sb = new StringBuilder();

        Interface interfaceClazz = (Interface) compilationUnit;

        interfaceClazz.getFileCommentLines().forEach(commentLine -> {
            sb.append(commentLine);
            OutputUtilities.newLine(sb);
        });

        formatPackage(sb, interfaceClazz.getType().getPackageName());

        formatStaticImports(sb, interfaceClazz.getStaticImports());

        if (interfaceClazz.getStaticImports().size() > 0) {
            OutputUtilities.newLine(sb);
        }

        Set<String> importStrings = OutputUtilities.calculateImports(interfaceClazz.getImportedTypes());
        this.sortImportTypes(sb, importStrings);

        if (CollectionUtil.isNotEmpty(importStrings)) {
            OutputUtilities.newLine(sb);
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
            OutputUtilities.newLine(sb);
            Method method = mtdIter.next();
            sb.append(method.getFormattedContent(indentLevel, true, interfaceClazz));
            if (mtdIter.hasNext()) {
                OutputUtilities.newLine(sb);
            }
        }

        indentLevel--;
        OutputUtilities.newLine(sb);
        OutputUtilities.javaIndent(sb, indentLevel);
        sb.append('}');

        return sb.toString();
    }

    /**
     * 格式化static import内容
     * 
     * @param sb 类文件String格式
     * @param staticImports staticImport字符串
     */
    private void formatStaticImports(StringBuilder sb, Set<String> staticImports) {
        staticImports.forEach(staticImport -> {
            sb.append("import static ");
            sb.append(staticImport);
            sb.append(';');
            OutputUtilities.newLine(sb);
        });
    }

    /**
     * 类format
     *
     * @param compilationUnit compilationUnit
     * @return 文件String类型
     */
    private String getClassFormattedContent(CompilationUnit compilationUnit) {
        StringBuilder sb = new StringBuilder();

        TopLevelClass topLevelClass = (TopLevelClass) compilationUnit;

        topLevelClass.getFileCommentLines().forEach(fileCommentLine -> {
            sb.append(fileCommentLine);
            OutputUtilities.newLine(sb);
        });

        formatPackage(sb, topLevelClass.getType().getPackageName());

        formatStaticImports(sb, topLevelClass.getStaticImports());

        if (topLevelClass.getStaticImports().size() > 0) {
            OutputUtilities.newLine(sb);
        }

        Set<String> importStrings = OutputUtilities.calculateImports(topLevelClass.getImportedTypes());

        sortImportTypes(sb, importStrings);

        if (importStrings.size() > 0) {
            OutputUtilities.newLine(sb);
        }

        sb.append(topLevelClass.getFormattedContent(0, compilationUnit));

        return sb.toString();
    }

    /**
     * 格式化包
     * 
     * @param sb 文件String类型
     * @param packageName 包名
     */
    private void formatPackage(StringBuilder sb, String packageName) {
        if (StringUtility.stringHasValue(packageName)) {
            sb.append("package ");
            sb.append(packageName);
            sb.append(';');
            OutputUtilities.newLine(sb);
            OutputUtilities.newLine(sb);
        }
    }

    /**
     * 格式化import
     *
     * @param sb sb 字符串
     * @param importStrings import的内容
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
            OutputUtilities.newLine(sb);
        });

        if (javaTypes.size() > 0) {
            OutputUtilities.newLine(sb);
        }
    }

}
