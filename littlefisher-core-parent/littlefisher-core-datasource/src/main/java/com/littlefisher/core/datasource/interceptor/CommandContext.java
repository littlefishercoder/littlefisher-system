package com.littlefisher.core.datasource.interceptor;

import java.util.Map;

import com.google.common.collect.Maps;
import com.littlefisher.core.common.utils.ExceptionHandler;
import com.littlefisher.core.datasource.engine.DbSqlSession;
import com.littlefisher.core.datasource.engine.Session;
import com.littlefisher.core.datasource.engine.SessionFactory;
import com.littlefisher.core.datasource.engine.SystemEngineConfig;

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

    /**
     * 构造函数
     * 
     * @param command 命令
     * @param systemEngineConfig 系统配置
     */
    public CommandContext(Command<?> command, SystemEngineConfig systemEngineConfig) {
        this.command = command;
        this.systemEngineConfig = systemEngineConfig;
        this.sessionFactories = systemEngineConfig.getSessionFactories();
    }

    /**
     * 配置异常
     * 
     * @param exception 异常信息
     */
    public void exception(Throwable exception) {
        if (this.exception == null) {
            this.exception = exception;
        }
    }

    /**
     * 关闭
     */
    public void close() {

    }

    /**
     * 获取Session
     * 
     * @param sessionClass session的class类型
     * @param <T> 泛型
     * @return Session
     */
    @SuppressWarnings("unchecked")
    public <T> T getSession(Class<T> sessionClass) {
        Session session = sessions.get(sessionClass);
        if (session == null) {
            SessionFactory sessionFactory = sessionFactories.get(sessionClass);
            if (sessionFactory == null) {
                ExceptionHandler.publish("CORE-000005", null, sessionClass.getName());
            } else {
                session = sessionFactory.openSession();
                sessions.put(sessionClass, session);
            }
        }

        return (T) session;
    }

    public DbSqlSession getDbSqlSession() {
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
