package com.littlefisher.core.mybatis.mapper.helper;

import java.util.Set;

import org.apache.ibatis.type.JdbcType;

import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;

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
     * @param entityClass model类
     * @return sql语句
     */
    public static String exampleSelectColumnsWithoutBlob(Class<?> entityClass) {
        // 不支持指定列的时候查询全部列
        return "<choose>" + "<when test=\"@tk.mybatis.mapper.util.OGNL@hasSelectColumns(_parameter)\">"
            + "<foreach collection=\"_parameter.selectColumns\" item=\"selectColumn\" separator=\",\">"
            + "${selectColumn}" + "</foreach>" + "</when>" + "<otherwise>" + getAllColumnsWithoutBlob(entityClass)
            + "</otherwise>" + "</choose>";
    }

    /**
     * 获取所有非blob查询列，如id,name,code...
     * 
     * @param entityClass model类
     * @return sql语句
     */
    public static String getAllColumnsWithoutBlob(Class<?> entityClass) {
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        StringBuilder sql = new StringBuilder();
        for (EntityColumn entityColumn : columnList) {
            if (JdbcType.BINARY.equals(entityColumn.getJdbcType()) || JdbcType.BLOB.equals(entityColumn.getJdbcType())
                || JdbcType.CLOB.equals(entityColumn.getJdbcType())
                || JdbcType.LONGNVARCHAR.equals(entityColumn.getJdbcType())
                || JdbcType.LONGVARBINARY.equals(entityColumn.getJdbcType())
                || JdbcType.LONGVARCHAR.equals(entityColumn.getJdbcType())
                || JdbcType.NCLOB.equals(entityColumn.getJdbcType())
                || JdbcType.VARBINARY.equals(entityColumn.getJdbcType())) {
                continue;
            }
            sql.append(entityColumn.getColumn()).append(",");
        }
        return sql.substring(0, sql.length() - 1);
    }
}
