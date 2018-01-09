package com.littlefisher.core.mybatis.mapper.helper;

import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;

import java.util.Set;

import org.apache.ibatis.type.JdbcType;

/**
 * Description: SqlHelper.java
 *
 * Created on 2018年01月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class SqlHelper extends tk.mybatis.mapper.mapperhelper.SqlHelper {

    /**
     * example支持查询指定列时
     *
     */
    public static String exampleSelectColumnsWithoutBlob(Class<?> entityClass) {
        StringBuilder sql = new StringBuilder();
        sql.append("<choose>");
        sql.append("<when test=\"@tk.mybatis.mapper.util.OGNL@hasSelectColumns(_parameter)\">");
        sql.append("<foreach collection=\"_parameter.selectColumns\" item=\"selectColumn\" separator=\",\">");
        sql.append("${selectColumn}");
        sql.append("</foreach>");
        sql.append("</when>");
        //不支持指定列的时候查询全部列
        sql.append("<otherwise>");
        sql.append(getAllColumnsWithoutBlob(entityClass));
        sql.append("</otherwise>");
        sql.append("</choose>");
        return sql.toString();
    }

    /**
     * 获取所有非blob查询列，如id,name,code...
     */
    public static String getAllColumnsWithoutBlob(Class<?> entityClass) {
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        StringBuilder sql = new StringBuilder();
        for (EntityColumn entityColumn : columnList) {
            if (entityColumn.getJdbcType() == JdbcType.BLOB || entityColumn.getJdbcType() == JdbcType.CLOB ||
                    entityColumn.getJdbcType() == JdbcType.LONGNVARCHAR ||
                    entityColumn.getJdbcType() == JdbcType.NCLOB) {
                continue;
            }
            sql.append(entityColumn.getColumn()).append(",");
        }
        return sql.substring(0, sql.length() - 1);
    }
}
