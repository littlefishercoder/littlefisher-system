package com.littlefisher.core.utils;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;

/**
 * Description: 日志管理类
 *
 * Created on 2016年12月30日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class LittleFisherLogger {

    /** logger */
    protected Logger logger;

    /** loggerCache 缓存 */
    private static Map<String, LittleFisherLogger> loggerCache = Maps.newConcurrentMap();

    /**
     * 私有构造函数
     *
     * @param logger logger
     */
    private LittleFisherLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * Description: 获取LittleFisherLogger实例，并进行缓存
     *
     * @param clazz clazz
     * @return LittleFisherLogger
     */
    public static LittleFisherLogger getLogger(Class<?> clazz) {
        if (loggerCache.get(clazz.getName()) != null) {
            return loggerCache.get(clazz.getName());
        }
        LittleFisherLogger littleFisherLogger = new LittleFisherLogger(LogManager.getLogger(clazz));
        loggerCache.put(clazz.getName(), littleFisherLogger);
        return littleFisherLogger;
    }

    public void debug(Object msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg);
        }
    }

    public void debug(Object msg, Throwable t) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg, t);
        }
    }

    public void debug(String msg, Object... arguments) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg, arguments);
        }
    }

    public void fatal(Object msg) {
        logger.fatal(msg);
    }

    public void fatal(Object msg, Throwable t) {
        logger.fatal(msg, t);
    }

    public void fatal(String msg, Object... arguments) {
        logger.fatal(msg, arguments);
    }

    public void info(Object msg) {
        if (logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }

    public void info(Object msg, Throwable t) {
        if (logger.isInfoEnabled()) {
            logger.info(msg, t);
        }
    }

    public void info(String msg, Object... arguments) {
        if (logger.isInfoEnabled()) {
            logger.info(msg, arguments);
        }
    }

    public void warn(Object msg) {
        logger.warn(msg);
    }

    public void warn(Object msg, Throwable t) {
        logger.warn(msg, t);
    }

    public void warn(String msg, Object... arguments) {
        logger.warn(msg, arguments);
    }

    public void error(Object msg) {
        logger.error(msg);
    }

    public void error(Object msg, Throwable t) {
        logger.error(msg, t);
    }

    public void error(String msg, Object... arguments) {
        logger.error(msg, arguments);
    }

}
