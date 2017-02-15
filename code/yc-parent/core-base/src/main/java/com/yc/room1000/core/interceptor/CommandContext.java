package com.yc.room1000.core.interceptor;

import java.util.HashMap;
import java.util.Map;

import com.yc.room1000.core.engine.DbSqlSession;
import com.yc.room1000.core.engine.Session;
import com.yc.room1000.core.engine.SessionFactory;
import com.yc.room1000.core.engine.SystemEngineConfig;
import com.yc.room1000.core.exception.BaseAppException;

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
public class CommandContext {

    /**
     * command
     */
    protected Command command;

    /**
     * systemEngineConfig
     */
    protected SystemEngineConfig systemEngineConfig;

    /**
     * exception
     */
    protected Throwable myException = null;
    
    /**
     * sessionFactories
     */
    protected Map<Class<?>, SessionFactory> sessionFactories;

    /**
     * sessions
     */
    protected Map<Class<?>, Session> sessions = new HashMap<Class<?>, Session>();
    
    /**
     * CommandContext
     * @param command <br>
     * @param systemEngineConfig <br>
     */
    public CommandContext(Command command, SystemEngineConfig systemEngineConfig) {
        this.command = command;
        this.systemEngineConfig = systemEngineConfig;
        this.sessionFactories = systemEngineConfig.getSessionFactories();
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param exception <br>
     */
    public void exception(Throwable exception) {
        if (this.myException == null) {
            this.myException = exception;
        }
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    public void close() {

    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param <T> <br>
     * @param sessionClass <br>
     * @return <br>
     * @throws BaseAppException 
     */
    @SuppressWarnings("unchecked")
    public <T> T getSession(Class<T> sessionClass) throws BaseAppException {
        Session session = sessions.get(sessionClass);
        if (session == null) {
            SessionFactory sessionFactory = sessionFactories.get(sessionClass);
            if (sessionFactory == null) {
                throw new BaseAppException("no session factory configured for " + sessionClass.getName());
            }
            session = sessionFactory.openSession();
            sessions.put(sessionClass, session);
        }

        return (T) session;
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     * @throws BaseAppException 
     */
    public DbSqlSession getDbSqlSession() throws BaseAppException {
        return getSession(DbSqlSession.class);
    }
    
    public Throwable getException() {
        return myException;
    }
    
    public void setException(Throwable exception) {
        this.myException = exception;
    }
    
    public SystemEngineConfig getSystemEngineConfig() {
        return this.systemEngineConfig;
    }
    
    public Map<Class<?>, SessionFactory> getSessionFactories() {
        return sessionFactories;
    }
}
