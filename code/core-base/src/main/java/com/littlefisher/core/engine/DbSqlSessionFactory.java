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
    
    /**
     * <Description> <br> 
     * @param sqlSessionFactory <br>
     */
    public DbSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.setSqlSessionFactory(sqlSessionFactory);

    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @return <br>
     */
    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @param sqlSessionFactory <br>
     */
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @return <br>
     */
    public Class<?> getSessionType() {
        return DbSqlSession.class;
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @return <br>
     */
    public Session openSession() {
        return new DbSqlSession(this);
    }
}
