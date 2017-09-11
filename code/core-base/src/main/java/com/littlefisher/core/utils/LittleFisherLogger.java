package com.littlefisher.core.utils;

import java.util.Map;

import org.apache.log4j.Logger;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

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
     * 
     * Description: 获取Room1000Logger实例，并进行缓存
     * 
     * @author jinyanan
     *
     * @param clazz clazz
     * @return LittleFisherLogger
     */
    public static LittleFisherLogger getLogger(Class<?> clazz) {
        if (loggerCache.get(clazz.getName()) != null) {
            return loggerCache.get(clazz.getName());
        }
        LittleFisherLogger room1000Logger = new LittleFisherLogger(Logger.getLogger(clazz));
        loggerCache.put(clazz.getName(), room1000Logger);
        return room1000Logger;
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
    
    public void debug(String format, Object... arguments) {
        if (logger.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
            logger.debug(ft.getMessage(), ft.getThrowable());
        }
    }

    public void fatal(Object msg) {
        logger.fatal(msg);
    }
    
    public void fatal(Object msg, Throwable t) {
        logger.fatal(msg, t);
    }
    
    public void fatal(String format, Object... arguments) {
        FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
        logger.fatal(ft.getMessage(), ft.getThrowable());
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
    
    public void info(String format, Object... arguments) {
        if (logger.isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
            logger.info(ft.getMessage(), ft.getThrowable());
        }
    }
    
    public void warn(Object msg) {
        logger.warn(msg);
    }
    
    public void warn(Object msg, Throwable t) {
        logger.warn(msg, t);
    }
    
    public void warn(String format, Object... arguments) {
        FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
        logger.warn(ft.getMessage(), ft.getThrowable());
    }

    public void error(Object msg) {
        logger.error(msg);
    }
    
    public void error(Object msg, Throwable t) {
        logger.error(msg, t);
    }
    
    public void error(String format, Object... arguments) {
        FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
        logger.error(ft.getMessage(), ft.getThrowable());
    }
    
}
