package com.littlefisher.core.common.utils;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Supplier;

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

    /**
     * debug级别日志打印
     * 
     * @param msg 消息
     */
    public void debug(Object msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg);
        }
    }

    /**
     * debug级别日志打印
     * 
     * @param msg 消息
     * @param t 异常
     */
    public void debug(Object msg, Throwable t) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg, t);
        }
    }

    /**
     * debug级别日志打印
     * 
     * @param msg 消息
     * @param arguments 参数
     */
    public void debug(String msg, Object... arguments) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg, arguments);
        }
    }

    /**
     * debug级别日志打印
     * 
     * @param msg 消息
     * @param paramSuppliers supplier
     */
    public void debug(String msg, Supplier<?>... paramSuppliers) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg, paramSuppliers);
        }
    }

    /**
     * fatal级别日志打印
     * 
     * @param msg 消息
     */
    public void fatal(Object msg) {
        if (logger.isFatalEnabled()) {
            logger.fatal(msg);
        }
    }

    /**
     * fatal级别日志打印
     * 
     * @param msg 消息
     * @param t 异常
     */
    public void fatal(Object msg, Throwable t) {
        if (logger.isFatalEnabled()) {
            logger.fatal(msg, t);
        }
    }

    /**
     * fatal级别日志打印
     * 
     * @param msg 消息
     * @param arguments 参数
     */
    public void fatal(String msg, Object... arguments) {
        if (logger.isFatalEnabled()) {
            logger.fatal(msg, arguments);
        }
    }

    /**
     * fatal级别日志打印
     * 
     * @param msg 消息
     * @param paramSuppliers supplier
     */
    public void fatal(String msg, Supplier<?>... paramSuppliers) {
        if (logger.isFatalEnabled()) {
            logger.fatal(msg, paramSuppliers);
        }
    }

    /**
     * info级别日志打印
     * 
     * @param msg 消息
     */
    public void info(Object msg) {
        if (logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }

    /**
     * info级别日志打印
     * 
     * @param msg 消息
     * @param t 异常
     */
    public void info(Object msg, Throwable t) {
        if (logger.isInfoEnabled()) {
            logger.info(msg, t);
        }
    }

    /**
     * info级别日志打印
     * 
     * @param msg 消息
     * @param arguments 参数
     */
    public void info(String msg, Object... arguments) {
        if (logger.isInfoEnabled()) {
            logger.info(msg, arguments);
        }
    }

    /**
     * info级别日志打印
     * 
     * @param msg 消息
     * @param paramSuppliers supplier
     */
    public void info(String msg, Supplier<?>... paramSuppliers) {
        if (logger.isInfoEnabled()) {
            logger.info(msg, paramSuppliers);
        }
    }

    /**
     * warn级别日志打印
     * 
     * @param msg 消息
     */
    public void warn(Object msg) {
        if (logger.isWarnEnabled()) {
            logger.warn(msg);
        }
    }

    /**
     * warn级别日志打印
     * 
     * @param msg 消息
     * @param t 异常
     */
    public void warn(Object msg, Throwable t) {
        if (logger.isWarnEnabled()) {
            logger.warn(msg, t);
        }
    }

    /**
     * warn级别日志打印
     * 
     * @param msg 消息
     * @param arguments 参数
     */
    public void warn(String msg, Object... arguments) {
        if (logger.isWarnEnabled()) {
            logger.warn(msg, arguments);
        }
    }

    /**
     * warn级别日志打印
     * 
     * @param msg 消息
     * @param paramSuppliers supplier
     */
    public void warn(String msg, Supplier<?>... paramSuppliers) {
        if (logger.isWarnEnabled()) {
            logger.warn(msg, paramSuppliers);
        }
    }

    /**
     *
     * error级别日志打印
     * 
     * @param msg 消息
     */
    public void error(Object msg) {
        if (logger.isErrorEnabled()) {
            logger.error(msg);
        }
    }

    /**
     *
     * error级别日志打印
     * 
     * @param msg 消息
     * @param t 异常
     */
    public void error(Object msg, Throwable t) {
        if (logger.isErrorEnabled()) {
            logger.error(msg, t);
        }
    }

    /**
     * error级别日志打印
     * 
     * @param msg 消息
     * @param arguments 参数
     */
    public void error(String msg, Object... arguments) {
        if (logger.isErrorEnabled()) {
            logger.error(msg, arguments);
        }
    }

    /**
     * error级别日志打印
     * 
     * @param msg 消息
     * @param paramSuppliers supplier
     */
    public void error(String msg, Supplier<?>... paramSuppliers) {
        if (logger.isErrorEnabled()) {
            logger.error(msg, paramSuppliers);
        }
    }
}
