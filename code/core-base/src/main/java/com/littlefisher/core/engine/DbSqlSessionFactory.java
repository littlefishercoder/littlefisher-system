package com.littlefisher.core.engine;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 
 * Description: 
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
    
    public Class<?> getSessionType() {
        return DbSqlSession.class;
    }
    
    public Session openSession() {
        return new DbSqlSession(this);
    }
}
