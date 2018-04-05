package com.littlefisher.core.datasource.engine;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 
 * Description: mybatis的session工厂
 *  
 * Created on 2017年2月10日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class DbSqlSessionFactory implements SessionFactory {

    /**
     * sqlSessionFactory
     */
    private SqlSessionFactory sqlSessionFactory;
    
    public DbSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.setSqlSessionFactory(sqlSessionFactory);

    }
    
    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    @Override
    public Class<?> getSessionType() {
        return DbSqlSession.class;
    }
    
    @Override
    public Session openSession() {
        return new DbSqlSession(this);
    }
}
