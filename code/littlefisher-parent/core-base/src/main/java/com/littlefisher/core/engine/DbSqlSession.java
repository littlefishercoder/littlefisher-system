package com.littlefisher.core.engine;

import org.apache.ibatis.session.SqlSession;

/**
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
     *
     * @param dbSqlSessionFactory <br>
     */
    public DbSqlSession(DbSqlSessionFactory dbSqlSessionFactory) {
        this.dbSqlSessionFactory = dbSqlSessionFactory;
        this.sqlSession = dbSqlSessionFactory.getSqlSessionFactory().openSession();
    }

    public <K> K getMapper(Class<K> type) {
        return getSqlSession().getMapper(type);
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() {
        sqlSession.close();
    }

    public void commit() {
        sqlSession.commit();
    }

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
