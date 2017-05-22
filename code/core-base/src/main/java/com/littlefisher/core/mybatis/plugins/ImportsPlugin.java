package com.littlefisher.core.mybatis.plugins;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.util.StringUtility;


/**
 * 
 * Description: 处理dao接口和model实体类注释和导入
 *  
 * Created on 2017年3月4日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class ImportsPlugin extends PluginAdapter {
    
    /**
     * properties
     */
    private Properties properties;
    
    /**
     * author
     */
    private String author;
    
    /**
     * currentDateStr
     */
    private String currentDateStr;
    
    @Override
    public void setContext(Context context) {
        super.setContext(context);
        this.properties = context.getProperties();
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }
    
    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        
        String authorString = this.properties.getProperty("author");
        if (StringUtility.stringHasValue(authorString)) {
            author = authorString;
        }
        
        currentDateStr = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
    }
    
    /**
     * 生成的Mapper接口
     *
     * @param interfaze interfaze
     * @param topLevelClass topLevelClass
     * @param introspectedTable introspectedTable
     * @return boolean
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        interfaze.addJavaDocLine("/**");
        interfaze.addJavaDocLine(" *");
        interfaze.addJavaDocLine(" * Description: " + introspectedTable.getFullyQualifiedTable() + " Mapper 接口");
        interfaze.addJavaDocLine(" *");
        interfaze.addJavaDocLine(" * Created on " + currentDateStr);
        interfaze.addJavaDocLine(" * @author " + author);
        interfaze.addJavaDocLine(" * @version 1.0");
        interfaze.addJavaDocLine(" * @since v1.0");
        interfaze.addJavaDocLine(" */");
        return true;
    }
    
    /**
     * 处理实体类的包和@Table注解
     *
     * @param topLevelClass topLevelClass
     * @param introspectedTable introspectedTable
     */
    private void processEntityClass(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        
        // 导入ApiModel和ApiModelProperty包，用于swaggerUI
        topLevelClass.addImportedType("com.wordnik.swagger.annotations.ApiModel");
        topLevelClass.addImportedType("com.wordnik.swagger.annotations.ApiModelProperty");
        
        topLevelClass.addAnnotation("@ApiModel(value = \"" + introspectedTable.getFullyQualifiedTable() + "实体\")");
        
        // 引入JPA注解
        topLevelClass.addImportedType("javax.persistence.Column");
        
        Field generatedValueField = null;
        for (Field field : topLevelClass.getFields()) {
            List<String> annotations = field.getAnnotations();
            for (String annotation : annotations) {
                if (annotation.startsWith("@GeneratedValue")) {
                    generatedValueField = field;
                    break;
                }
            }
        }
        
        if (generatedValueField != null) {

            topLevelClass.addImportedType("javax.persistence.GeneratedValue");
            topLevelClass.addImportedType("javax.persistence.GenerationType");
        }
        topLevelClass.addImportedType("javax.persistence.Id");
        
        // 判断field是否是Transient，如果是则导入对应包
        for (Field field : topLevelClass.getFields()) {
            if (field.isTransient()) {
                topLevelClass.addImportedType("javax.persistence.Transient");
                break;
            }
        }
        
        // 实体类注释
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * Description: " + introspectedTable.getFullyQualifiedTable() + " 实体");
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * Created on " + currentDateStr);
        topLevelClass.addJavaDocLine(" * @author " + author);
        topLevelClass.addJavaDocLine(" * @version 1.0");
        topLevelClass.addJavaDocLine(" * @since v1.0");
        topLevelClass.addJavaDocLine(" */");
    }
    
    /**
     * 生成基础实体类
     *
     * @param topLevelClass topLevelClass
     * @param introspectedTable introspectedTable
     * @return boolean
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        processEntityClass(topLevelClass, introspectedTable);
        return true;
    }

    /**
     * 生成实体类注解KEY对象
     *
     * @param topLevelClass topLevelClass
     * @param introspectedTable introspectedTable
     * @return boolean
     */
    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        processEntityClass(topLevelClass, introspectedTable);
        return true;
    }

    /**
     * 生成带BLOB字段的对象
     *
     * @param topLevelClass topLevelClass
     * @param introspectedTable introspectedTable
     * @return boolean
     */
    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        processEntityClass(topLevelClass, introspectedTable);
        return false;
    }

}
