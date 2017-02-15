package com.yc.room1000.core.engine;

import org.apache.ibatis.session.SqlSession;

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
public class DbSqlSession implements Session {

    /**
     * sqlSession
     */
    private SqlSession sqlSession;

    /**
     * dbSqlSessionFactory
     */
    protected DbSqlSessionFactory dbSqlSessionFactory;
    
    /**
     * Description: <br> 
     * @param dbSqlSessionFactory <br>
     */
    public DbSqlSession(DbSqlSessionFactory dbSqlSessionFactory) {
        this.dbSqlSessionFactory = dbSqlSessionFactory;
        this.sqlSession = dbSqlSessionFactory.getSqlSessionFactory().openSession();
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param <T> 
     * @param type   
     * @return <br>
     */
    public <T> T getMapper(Class<T> type) {
        return getSqlSession().getMapper(type);
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    public void flush() {

    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    public void close() {
        sqlSession.close();
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    public void commit() {
        sqlSession.commit();
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    public void rollback() {
        sqlSession.rollback();
    }
    
    public SqlSession getSqlSession() {
        return sqlSession;
    }
    
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    
    
}
