package com.littlefisher.core.mybatis.mapper.provider.example;

import org.apache.ibatis.mapping.MappedStatement;

import com.littlefisher.core.mybatis.mapper.helper.SqlHelper;

import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

/**
 * ExampleProvider.java
 *
 * Created on 2018年01月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class ExampleProvider extends MapperTemplate {

    public ExampleProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 根据Example查询
     * 
     * @param ms MappedStatement
     * @return sql语句
     */
    public String selectByExampleWithoutBlob(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        // 将返回值修改为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder("SELECT ");
        if (isCheckExampleEntityClass()) {
            sql.append(SqlHelper.exampleCheck(entityClass));
        }
        sql.append("<if test=\"distinct\">distinct</if>");
        // 支持查询指定列
        sql.append(SqlHelper.exampleSelectColumnsWithoutBlob(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.exampleWhereClause());
        sql.append(SqlHelper.exampleOrderBy(entityClass));
        sql.append(SqlHelper.exampleForUpdate());
        return sql.toString();
    }
}
