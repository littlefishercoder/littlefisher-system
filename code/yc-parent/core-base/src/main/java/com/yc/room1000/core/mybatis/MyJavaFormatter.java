package com.yc.room1000.core.mybatis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import static org.mybatis.generator.api.dom.OutputUtilities.calculateImports;
import static org.mybatis.generator.api.dom.OutputUtilities.newLine;
import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import org.mybatis.generator.api.JavaFormatter;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.InnerClass;
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
public class MyJavaFormatter implements JavaFormatter {

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
//        return this.getMyFormattedContent(compilationUnit);
        return compilationUnit.getFormattedContent();
    }

    public void setContext(Context context) {
        this.context = context;
    }
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param compilationUnit compilationUnit
     * @return <br>
     */
    public String getMyFormattedContent(CompilationUnit compilationUnit) {
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
        for (String importString : importStrings) {
            sb.append(importString);
            newLine(sb);
        }

        if (importStrings.size() > 0) {
            newLine(sb);
        }
        
//        InnerClass innerClass = (InnerClass) compilationUnit;
        
//        Method[] methods = topLevelClass.getClass().getMethods();
//        Method formattedContentMethod = null;
//        for (Method method : methods) {
//            if ("getFormattedContent".equals(method.getName()) && method.getParameterTypes().length > 0) {
//                formattedContentMethod = method;
//                break;
//            }
//        }
//        String sbStr = null;
//        if (formattedContentMethod != null) {
//            try {
//                sbStr = (String) formattedContentMethod.invoke(topLevelClass, 0);
//            }
//            catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
        String sbStr = topLevelClass.getFormattedContent(0, compilationUnit);
        
        sb.append(sbStr);

        return sb.toString();
    }
    

}
