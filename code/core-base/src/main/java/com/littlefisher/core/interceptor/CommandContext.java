package com.littlefisher.core.interceptor;

import java.util.Map;

import com.google.common.collect.Maps;
import com.littlefisher.core.engine.DbSqlSession;
import com.littlefisher.core.engine.Session;
import com.littlefisher.core.engine.SessionFactory;
import com.littlefisher.core.engine.SystemEngineConfig;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.utils.ExceptionHandler;

/**
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
    protected Command<?> command;

    /**
     * systemEngineConfig
     */
    protected SystemEngineConfig systemEngineConfig;

    /**
     * exception
     */
    protected Throwable exception = null;

    /**
     * sessionFactories
     */
    protected Map<Class<?>, SessionFactory> sessionFactories;

    /**
     * sessions
     */
    protected Map<Class<?>, Session> sessions = Maps.newHashMap();

    public CommandContext(Command<?> command, SystemEngineConfig systemEngineConfig) {
        this.command = command;
        this.systemEngineConfig = systemEngineConfig;
        this.sessionFactories = systemEngineConfig.getSessionFactories();
    }

    public void exception(Throwable exception) {
        if (this.exception == null) {
            this.exception = exception;
        }
    }

    public void close() {

    }

    @SuppressWarnings("unchecked")
    public <T> T getSession(Class<T> sessionClass) throws BaseAppException {
        Session session = sessions.get(sessionClass);
        if (session == null) {
            SessionFactory sessionFactory = sessionFactories.get(sessionClass);
            if (sessionFactory == null) {
                ExceptionHandler.publish("CORE-000005", sessionClass.getName());
            } else {
                session = sessionFactory.openSession();
                sessions.put(sessionClass, session);
            }
        }

        return (T) session;
    }

    public DbSqlSession getDbSqlSession() throws BaseAppException {
        return getSession(DbSqlSession.class);
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }

    public SystemEngineConfig getSystemEngineConfig() {
        return this.systemEngineConfig;
    }

    public Map<Class<?>, SessionFactory> getSessionFactories() {
        return sessionFactories;
    }
}
