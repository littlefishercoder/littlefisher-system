package com.littlefisher.core.mybatis.mapper.provider.base;

import org.apache.ibatis.mapping.MappedStatement;

import com.littlefisher.core.mybatis.mapper.helper.SqlHelper;

import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

/**
 * Description: BaseSelectProvider
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class BaseSelectProvider extends MapperTemplate {

    public BaseSelectProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 查询
     *
     * @param ms ms
     * @return sql
     */
    public String selectOneWithoutBlob(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        // 修改返回值类型为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.getAllColumnsWithoutBlob(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.whereAllIfColumns(entityClass, isNotEmpty()));
        return sql.toString();
    }

    /**
     * 查询
     *
     * @param ms ms
     * @return sql
     */
    public String selectWithoutBlob(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        // 修改返回值类型为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.getAllColumnsWithoutBlob(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.whereAllIfColumns(entityClass, isNotEmpty()));
        sql.append(SqlHelper.orderByDefault(entityClass));
        return sql.toString();
    }

    /**
     * 根据主键进行查询
     *
     * @param ms ms
     * @return sql
     */
    public String selectWithoutBlobByPrimaryKey(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        // 将返回值修改为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.getAllColumnsWithoutBlob(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.wherePKColumns(entityClass));
        return sql.toString();
    }

    /**
     * 查询全部结果
     *
     * @param ms ms
     * @return sql
     */
    public String selectAllWithoutBlob(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        // 修改返回值类型为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.getAllColumnsWithoutBlob(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.orderByDefault(entityClass));
        return sql.toString();
    }
}
