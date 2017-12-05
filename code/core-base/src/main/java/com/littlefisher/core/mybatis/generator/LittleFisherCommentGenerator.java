package com.littlefisher.core.mybatis.generator;

import java.text.MessageFormat;
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
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.internal.util.StringUtility;

import com.google.common.collect.Iterators;
import com.littlefisher.core.utils.StringUtil;

/**
 * Description:
 *
 * Created on 2017年1月14日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class LittleFisherCommentGenerator implements CommentGenerator {

    /** The properties. */
    private Properties properties;

    /**
     * 开始的分隔符，例如mysql为`，sqlserver为[
     */
    private String beginningDelimiter = "";

    /**
     * 结束的分隔符，例如mysql为`，sqlserver为]
     */
    private String endingDelimiter = "";

    /** author */
    private String author = "LittleFisher";

    public LittleFisherCommentGenerator() {
        super();
        properties = new Properties();
    }

    public String getDelimiterName(String name) {
        return beginningDelimiter + name + endingDelimiter;
    }

    /**
     * 对Mapper.java接口中的各个方法定义注释
     */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        // 如果带有@Override注解的方法，不进行javadoc
        if (Iterators.any(method.getAnnotations().iterator(),
                input -> StringUtil.isNotBlank(input) && "@Override".equalsIgnoreCase(input))) {
            return;
        }
        method.addJavaDocLine("/**");
        method.addJavaDocLine(" * Description: " + method.getName() + "<br>");
        method.addJavaDocLine(" *");
        method.addJavaDocLine(" * @author " + author + " <br>");
        List<Parameter> paramList = method.getParameters();
        for (Parameter p : paramList) {
            method.addJavaDocLine(" * @param " + p.getName() + " " + p.getName());
        }
        if (method.getReturnType() != null) {
            method.addJavaDocLine(
                    " * @return " + method.getReturnType().getShortName() + " " + method.getReturnType().getShortName()
                    + "<br>");
        }
        method.addJavaDocLine(" */");

    }

    /**
     * 添加mybatis generator自生成代码的注解；被注解的代码会被下次mybatis generator时候覆盖
     * @deprecated mybatis generator并不支持.java文件对该注解的使用，仅支持xml的
     */
    @Deprecated
    protected void addJavadocTag(JavaElement javaElement) {
        javaElement.addJavaDocLine(" *");
        javaElement.addJavaDocLine(" * " + MergeConstants.NEW_ELEMENT_TAG);
    }

    /**
     * 对实体bean中各个字段(仅数据库中的字段)field增加注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        String jdbc = "JDBC";
        String remarks = StringUtility.stringHasValue(introspectedColumn.getRemarks()) ?
                introspectedColumn.getRemarks() :
                field.getName();
        // 添加@ApiModelProperty注解，用于swaggerUI展示用
        field.addAnnotation("@ApiModelProperty(\"" + remarks + "\")");
        field.addJavaDocLine("/**");
        String sb = " * " + remarks;
        field.addJavaDocLine(sb);
        field.addJavaDocLine(" */");

        // 对非数据库字段添加@Transient注解
        if (field.isTransient()) {
            field.addAnnotation("@Transient");
        }
        // 对主键字段增加@Id注解
        if (Iterators
                .any(introspectedTable.getPrimaryKeyColumns().iterator(), column -> introspectedColumn == column)) {
            field.addAnnotation("@Id");
        }
        // 对数据库字段增加@Column注解，该注解用于解决字段名和数据库字段名不同时的映射问题
        String column = introspectedColumn.getActualColumnName();
        if (StringUtility.stringContainsSpace(column) || introspectedTable.getTableConfiguration()
                .isAllColumnDelimitingEnabled()) {
            column = introspectedColumn.getContext().getBeginningDelimiter() + column + introspectedColumn.getContext()
                    .getEndingDelimiter();
        }
        if (!column.equals(introspectedColumn.getJavaProperty())) {
            //@Column
            field.addAnnotation("@Column(name = \"" + getDelimiterName(column) + "\")");
        } else if (StringUtility.stringHasValue(beginningDelimiter) || StringUtility.stringHasValue(endingDelimiter)) {
            field.addAnnotation("@Column(name = \"" + getDelimiterName(column) + "\")");
        }
        // 自增字段根据不同的数据库，添加不同的@GeneratedValue注解
        if (introspectedColumn.isIdentity()) {
            if (jdbc.equals(introspectedTable.getTableConfiguration().getGeneratedKey().getRuntimeSqlStatement())) {
                field.addAnnotation("@GeneratedValue(generator = \"JDBC\")");
            } else {
                field.addAnnotation("@GeneratedValue(strategy = GenerationType.IDENTITY)");
            }
        } else if (introspectedColumn.isSequenceColumn()) {
            // 在 Oracle 中，如果需要是 SEQ_TABLENAME，那么可以配置为 select SEQ_{1} from dual
            String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
            String sql = MessageFormat.format(introspectedTable.getTableConfiguration().
                    getGeneratedKey().getRuntimeSqlStatement(), tableName, tableName.toUpperCase());
            field.addAnnotation("@GeneratedValue(strategy = GenerationType.IDENTITY, generator = \"" + sql + "\")");
        }

    }

    /**
     * 获取context下的properties属性
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);

        String authorString = properties.getProperty("author");
        if (StringUtility.stringHasValue(authorString)) {
            author = authorString;
        }

        String beginningDelimiter = properties.getProperty("beginningDelimiter");
        if (StringUtility.stringHasValue(beginningDelimiter)) {
            this.beginningDelimiter = beginningDelimiter;
        }
        String endingDelimiter = properties.getProperty("endingDelimiter");
        if (StringUtility.stringHasValue(endingDelimiter)) {
            this.endingDelimiter = endingDelimiter;
        }
    }

    /**
     * 对实体bean中各个字段(仅数据库中没有的字段)field增加注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        field.addJavaDocLine("/** " + field.getName() + " */");
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

    /**
     * 对.java文件的头部增加注释，例如copyright等的信息，一般是文件认证信息
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
    }

    /**
     * xml中的注释
     */
    @Override
    public void addComment(XmlElement xmlElement) {
        xmlElement.addElement(new TextElement("<!--" + MergeConstants.NEW_ELEMENT_TAG + "-->"));
    }

    @Override
    public void addRootComment(XmlElement rootElement) {
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    }

}
