package com.littlefisher.core.mybatis;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.mybatis.generator.api.dom.OutputUtilities.calculateImports;
import static org.mybatis.generator.api.dom.OutputUtilities.javaIndent;
import static org.mybatis.generator.api.dom.OutputUtilities.newLine;
import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import org.mybatis.generator.api.JavaFormatter;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaDomUtils;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.Context;

/**
 * 
 * Description: 
 *  
 * Created on 2017年3月9日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class SortImportTypesJavaFormatter implements JavaFormatter {

    /**
     * context
     */
    protected Context context;
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param compilationUnit compilationUnit
     * @return String
     */
    public String getFormattedContent(CompilationUnit compilationUnit) {
        if (compilationUnit instanceof TopLevelClass) {
            return this.getClassFormattedContent(compilationUnit);
        }
        else if (compilationUnit instanceof Interface) {
            return this.getInterfaceFormattedContent(compilationUnit);
        }
        else {
            return compilationUnit.getFormattedContent();
        }
    }

    public void setContext(Context context) {
        this.context = context;
    }
    
    /**
     * 
     * Description: 接口format
     * 
     * @author jinyanan
     *
     * @param compilationUnit compilationUnit
     * @return <br>
     */
    private String getInterfaceFormattedContent(CompilationUnit compilationUnit) {
        StringBuilder sb = new StringBuilder();
        
        Interface interfaceClazz = (Interface) compilationUnit;

        for (String commentLine : interfaceClazz.getFileCommentLines()) {
            sb.append(commentLine);
            newLine(sb);
        }

        if (stringHasValue(interfaceClazz.getType().getPackageName())) {
            sb.append("package "); //$NON-NLS-1$
            sb.append(interfaceClazz.getType().getPackageName());
            sb.append(';');
            newLine(sb);
            newLine(sb);
        }

        for (String staticImport : interfaceClazz.getStaticImports()) {
            sb.append("import static "); //$NON-NLS-1$
            sb.append(staticImport);
            sb.append(';');
            newLine(sb);
        }
        
        if (interfaceClazz.getStaticImports().size() > 0) {
            newLine(sb);
        }
        
        Set<String> importStrings = calculateImports(interfaceClazz.getImportedTypes());
        this.sortImportTypes(sb, importStrings);

        if (importStrings.size() > 0) {
            newLine(sb);
        }

        int indentLevel = 0;

        interfaceClazz.addFormattedJavadoc(sb, indentLevel);
        interfaceClazz.addFormattedAnnotations(sb, indentLevel);

        sb.append(interfaceClazz.getVisibility().getValue());

        if (interfaceClazz.isStatic()) {
            sb.append("static "); //$NON-NLS-1$
        }

        if (interfaceClazz.isFinal()) {
            sb.append("final "); //$NON-NLS-1$
        }

        sb.append("interface "); //$NON-NLS-1$
        sb.append(interfaceClazz.getType().getShortName());

        if (interfaceClazz.getSuperInterfaceTypes().size() > 0) {
            sb.append(" extends "); //$NON-NLS-1$

            boolean comma = false;
            for (FullyQualifiedJavaType fqjt : interfaceClazz.getSuperInterfaceTypes()) {
                if (comma) {
                    sb.append(", "); //$NON-NLS-1$
                } 
                else {
                    comma = true;
                }

                sb.append(JavaDomUtils.calculateTypeName(interfaceClazz, fqjt));
            }
        }

        sb.append(" {"); //$NON-NLS-1$
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
    
    /**
     * 
     * Description: 类format
     * 
     * @author jinyanan
     *
     * @param compilationUnit compilationUnit
     * @return <br>
     */
    private String getClassFormattedContent(CompilationUnit compilationUnit) {
        StringBuilder sb = new StringBuilder();
        
        TopLevelClass topLevelClass = (TopLevelClass) compilationUnit;

        for (String fileCommentLine : topLevelClass.getFileCommentLines()) {
            sb.append(fileCommentLine);
            newLine(sb);
        }

        if (stringHasValue(topLevelClass.getType().getPackageName())) {
            sb.append("package "); //$NON-NLS-1$
            sb.append(topLevelClass.getType().getPackageName());
            sb.append(';');
            newLine(sb);
            newLine(sb);
        }

        for (String staticImport : topLevelClass.getStaticImports()) {
            sb.append("import static "); //$NON-NLS-1$
            sb.append(staticImport);
            sb.append(';');
            newLine(sb);
        }
        
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

    /**
     * 
     * Description: 格式化import
     * 
     * @author jinyanan
     *
     * @param sb sb
     * @param importStrings <br>
     */
    private void sortImportTypes(StringBuilder sb, Set<String> importStrings) {
        Set<String> javaTypes = new TreeSet<>();
        Set<String> javaxTypes = new TreeSet<>();
        Set<String> orgTypes = new TreeSet<>();
        Set<String> otherTypes = new TreeSet<>();
        Set<String> comTypes = new TreeSet<>();
        
        for (String importType : importStrings) {
            if (importType.startsWith("import javax")) {
                javaxTypes.add(importType);
            }
            else if (importType.startsWith("import java")) {
                javaTypes.add(importType);
            }
            else if (importType.startsWith("import org")) {
                orgTypes.add(importType);
            }
            else if (importType.startsWith("import com")) {
                comTypes.add(importType);
            }
            else {
                otherTypes.add(importType);
            }
        }
        
        for (String importType : javaTypes) {
            sb.append(importType);
            newLine(sb);
        }
        
        if (javaTypes.size() > 0) {
            newLine(sb);
        }
        
        for (String importType : javaxTypes) {
            sb.append(importType);
            newLine(sb);
        }
        
        if (javaxTypes.size() > 0) {
            newLine(sb);
        }
        
        for (String importType : orgTypes) {
            sb.append(importType);
            newLine(sb);
        }
        
        if (orgTypes.size() > 0) {
            newLine(sb);
        }
        
        for (String importType : otherTypes) {
            sb.append(importType);
            newLine(sb);
        }
        
        if (otherTypes.size() > 0) {
            newLine(sb);
        }
        
        for (String importType : comTypes) {
            sb.append(importType);
            newLine(sb);
        }
        
        if (comTypes.size() > 0) {
            newLine(sb);
        }
    }
    
}
