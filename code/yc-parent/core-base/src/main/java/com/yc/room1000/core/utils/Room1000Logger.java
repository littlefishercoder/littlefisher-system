package com.yc.room1000.core.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/**
 * Description: 日志管理类 
 * 
 * Created on 2016年12月30日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class Room1000Logger {
    
    /** logger */
    protected Logger logger;
    
    /** loggerCache 缓存 */
    private static Map<String, Room1000Logger> loggerCache = new ConcurrentHashMap<String, Room1000Logger>();
    
    /**
     * 私有构造函数
     * 
     * @param logger logger
     */
    private Room1000Logger(Logger logger) {
        this.logger = logger;
    }
    
    /**
     * 
     * Description: 获取Room1000Logger实例，并进行缓存
     * 
     * @author jinyanan
     *
     * @param clazz clazz
     * @return Room1000Logger
     */
    public static Room1000Logger getLogger(Class<?> clazz) {
        if (loggerCache.get(clazz.getName()) != null) {
            return loggerCache.get(clazz.getName());
        }
        Room1000Logger room1000Logger = new Room1000Logger(Logger.getLogger(clazz));
        loggerCache.put(clazz.getName(), room1000Logger);
        return room1000Logger;
    }
    
    /**
     * 
     * Description: debug
     * 
     * @author jinyanan
     *
     * @param msg msg
     */
    public void debug(Object msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg);
        }
    }
    
    /**
     * 
     * Description: debug
     * 
     * @author jinyanan
     *
     * @param msg msg
     * @param t t
     */
    public void debug(Object msg, Throwable t) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg, t);
        }
    }
    
    /**
     * 
     * Description: debug
     * 
     * @author jinyanan
     *
     * @param format format
     * @param arguments arguments
     */
    public void debug(String format, Object... arguments) {
        if (logger.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
            logger.debug(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * 
     * Description: fatal
     * 
     * @author jinyanan
     *
     * @param msg msg
     */
    public void fatal(Object msg) {
        logger.fatal(msg);
    }
    
    /**
     * 
     * Description: fatal
     * 
     * @author jinyanan
     * 
     * @param msg msg
     * @param t t
     */
    public void fatal(Object msg, Throwable t) {
        logger.fatal(msg, t);
    }
    
    /**
     * 
     * Description: fatal
     * 
     * @author jinyanan
     *
     * @param format format
     * @param arguments arguments
     */
    public void fatal(String format, Object... arguments) {
        FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
        logger.fatal(ft.getMessage(), ft.getThrowable());
    }

    /**
     * 
     * Description: info
     * 
     * @author jinyanan
     *
     * @param msg msg
     */
    public void info(Object msg) {
        if (logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }
    
    /**
     * 
     * Description: info
     * 
     * @author jinyanan
     *
     * @param msg msg
     * @param t t
     */
    public void info(Object msg, Throwable t) {
        if (logger.isInfoEnabled()) {
            logger.info(msg, t);
        }
    }
    
    /**
     * 
     * Description: info
     * 
     * @author jinyanan
     *
     * @param format format
     * @param arguments arguments
     */
    public void info(String format, Object... arguments) {
        if (logger.isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
            logger.info(ft.getMessage(), ft.getThrowable());
        }
    }
    
    /**
     * 
     * Description: warn
     * 
     * @author jinyanan
     *
     * @param msg msg
     */
    public void warn(Object msg) {
        logger.warn(msg);
    }
    
    /**
     * 
     * Description: warn
     * 
     * @author jinyanan
     *
     * @param msg msg
     * @param t t
     */
    public void warn(Object msg, Throwable t) {
        logger.warn(msg, t);
    }
    
    /**
     * 
     * Description: warn
     * 
     * @author jinyanan
     *
     * @param format format
     * @param arguments arguments
     */
    public void warn(String format, Object... arguments) {
        FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
        logger.warn(ft.getMessage(), ft.getThrowable());
    }

    /**
     * 
     * Description: error
     * 
     * @author jinyanan
     *
     * @param msg msg
     */
    public void error(Object msg) {
        logger.error(msg);
    }
    
    /**
     * 
     * Description: error
     * 
     * @author jinyanan
     *
     * @param msg msg
     * @param t t
     */
    public void error(Object msg, Throwable t) {
        logger.error(msg, t);
    }
    
    /**
     * 
     * Description: error
     * 
     * @author jinyanan
     *
     * @param format format
     * @param arguments arguments
     */
    public void error(String format, Object... arguments) {
        FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
        logger.error(ft.getMessage(), ft.getThrowable());
    }
    
}
