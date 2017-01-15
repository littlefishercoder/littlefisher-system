package com.yc.core.attr.service;


import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月15日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class ZteCommentGenerator implements CommentGenerator {
    /**
     * suppressAllComments
     */
    private boolean suppressAllComments;
    /**
     * ZteCommentGenerator
     */
    public ZteCommentGenerator() {
        super();
        suppressAllComments = false;
    }
    /**
     * Description: <br>
     * 
     * @author yang.ning<br>
     * @taskId <br>
     * @param javaElement javaElement
     * @param markAsDoNotDelete markAsDoNotDelete<br>
     */
    protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
        StringBuilder sb = new StringBuilder();
        sb.append(" * "); //$NON-NLS-1$
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        javaElement.addJavaDocLine(sb.toString());
    }
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        method.addJavaDocLine("/**"); //$NON-NLS-1$
        method.addJavaDocLine(" * Description: " + method.getName() + "<br>"); //$NON-NLS-1$
        method.addJavaDocLine(" *"); //$NON-NLS-1$
        method.addJavaDocLine(" * @author yang.ning<br>"); //$NON-NLS-1$
        method.addJavaDocLine(" * @taskId <br>"); //$NON-NLS-1$
        List<Parameter> paramList = method.getParameters();
        for (Parameter p : paramList) {
            sb.append(" * @param " + p.getName() + " " + p.getName()); //$NON-NLS-1$
        }
        method.addJavaDocLine(sb.toString());
        if (method.getReturnType() != null) {
            method.addJavaDocLine(" * @return " + method.getReturnType().getShortName()
                + " " + method.getReturnType().getShortName() + "<br>"); //$NON-NLS-1$
        }
        addJavadocTag(method, false);
        method.addJavaDocLine(" */"); //$NON-NLS-1$
    }
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        field.addJavaDocLine("/**"); //$NON-NLS-1$
        field.addJavaDocLine(" * " + field.getName() + " " + introspectedColumn.getRemarks());
        addJavadocTag(field, false);
        field.addJavaDocLine(" */"); //$NON-NLS-1$
    }
    @Override
    public void addConfigurationProperties(Properties properties) {
        // TODO Auto-generated method stub
    }
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        // TODO Auto-generated method stub
    }
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
    }
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        // TODO Auto-generated method stub
    }
    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        // TODO Auto-generated method stub
    }
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
        IntrospectedColumn introspectedColumn) {
        // TODO Auto-generated method stub
    }
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
        IntrospectedColumn introspectedColumn) {
        // TODO Auto-generated method stub
    }
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        // TODO Auto-generated method stub
    }
    @Override
    public void addComment(XmlElement xmlElement) {
        // TODO Auto-generated method stub
    }
    @Override
    public void addRootComment(XmlElement rootElement) {
        // TODO Auto-generated method stub
    }
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // TODO Auto-generated method stub
        
    }
}
