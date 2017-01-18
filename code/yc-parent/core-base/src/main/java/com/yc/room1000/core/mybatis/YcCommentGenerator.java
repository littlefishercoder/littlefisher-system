package com.yc.room1000.core.mybatis;

import java.util.List;
import java.util.Properties;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

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
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月14日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class YcCommentGenerator implements CommentGenerator {
    
    /** The properties. */
    private Properties properties;
    
    /** suppressAllComments */
    private boolean suppressAllComments;
    
    /** author */
    private String author;
    
    /**
     * YcCommentsGenerator
     */
    public YcCommentGenerator() {
        super();
        properties = new Properties();
        suppressAllComments = false;
        author = "autoCreated";
    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        method.addJavaDocLine("/**"); 
        method.addJavaDocLine(" * Description: " + method.getName() + "<br>"); 
        method.addJavaDocLine(" *"); 
        method.addJavaDocLine(" * @author " + author + " <br>"); 
        List<Parameter> paramList = method.getParameters();
        for (Parameter p : paramList) {
            sb.append(" * @param " + p.getName() + " " + p.getName()); 
        }
        method.addJavaDocLine(sb.toString());
        if (method.getReturnType() != null) {
            method.addJavaDocLine(" * @return " + method.getReturnType().getShortName()
                + " " + method.getReturnType().getShortName() + "<br>"); 
        }
        addJavadocTag(method, false);
        method.addJavaDocLine(" */"); 
        
    }
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param javaElement javaElement
     * @param markAsDoNotDelete markAsDoNotDelete
     */
    protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
        StringBuilder sb = new StringBuilder();
        sb.append(" * "); 
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        javaElement.addJavaDocLine(sb.toString());
    }
    
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        field.addJavaDocLine("/**"); 
        field.addJavaDocLine(" * " + field.getName() + " " + introspectedColumn.getRemarks());
        addJavadocTag(field, false);
        field.addJavaDocLine(" */"); 
        
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);

        suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

        String authorString = properties.getProperty("author");
        if (StringUtility.stringHasValue(authorString)) {
            author = authorString;
        }
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
        IntrospectedColumn introspectedColumn) {
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
        IntrospectedColumn introspectedColumn) {
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
    }

    @Override
    public void addComment(XmlElement xmlElement) {
        if (suppressAllComments) {
            return;
        }

        xmlElement.addElement(new TextElement("<!--")); 

        StringBuilder sb = new StringBuilder();
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        xmlElement.addElement(new TextElement(sb.toString()));

        xmlElement.addElement(new TextElement("-->")); 
    }

    @Override
    public void addRootComment(XmlElement rootElement) {
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    }

}
