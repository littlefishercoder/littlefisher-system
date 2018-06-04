package com.littlefisher.core.common.utils;

import java.lang.reflect.InvocationTargetException;

import com.littlefisher.core.common.exception.BaseAppException;

/**
 * Description: 该类提供给业务侧使用，提供抛出异常的方法
 *
 * Created on 2016年12月30日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class ExceptionHandler {

    /** logger */
    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(ExceptionHandler.class);

    /** 禁止实例化 */
    private ExceptionHandler() {}

    /**
     * 抛出异常
     * 
     * @param errorCode 异常码
     */
    public static void publish(String errorCode) {
        publish(errorCode, null, null, null, null, null, null, null);
    }

    /**
     * 抛出异常
     * 
     * @param errorCode 异常码
     * @param message 异常信息描述
     */
    public static void publish(String errorCode, String message) {
        publish(errorCode, message, null, null, null, null, null, null);
    }

    /**
     * 抛出异常
     * 
     * @param errorCode 异常码
     * @param message 异常信息描述
     * @param param1 异常信息中占位符替换内容
     */
    public static void publish(String errorCode, String message, String param1) {
        publish(errorCode, message, null, param1, null, null, null, null);
    }

    /**
     * 抛出异常
     * 
     * @param errorCode 异常码
     * @param message 异常信息描述
     * @param param1 异常信息中占位符替换内容
     * @param param2 异常信息中占位符替换内容
     */
    public static void publish(String errorCode, String message, String param1, String param2) {
        publish(errorCode, message, null, param1, param2, null, null, null);
    }

    /**
     * 抛出异常
     * 
     * @param errorCode 异常码
     * @param message 异常信息描述
     * @param param1 异常信息中占位符替换内容
     * @param param2 异常信息中占位符替换内容
     * @param param3 异常信息中占位符替换内容
     */
    public static void publish(String errorCode, String message, String param1, String param2, String param3) {
        publish(errorCode, message, null, param1, param2, param3, null, null);
    }

    /**
     * 抛出异常
     * 
     * @param errorCode 异常码
     * @param message 异常信息描述
     * @param param1 异常信息中占位符替换内容
     * @param param2 异常信息中占位符替换内容
     * @param param3 异常信息中占位符替换内容
     * @param param4 异常信息中占位符替换内容
     */
    public static void publish(String errorCode, String message, String param1, String param2, String param3,
        String param4) {
        publish(errorCode, message, null, param1, param2, param3, param4, null);
    }

    /**
     * 抛出异常
     * 
     * @param errorCode 异常码
     * @param message 异常信息描述
     * @param param1 异常信息中占位符替换内容
     * @param param2 异常信息中占位符替换内容
     * @param param3 异常信息中占位符替换内容
     * @param param4 异常信息中占位符替换内容
     * @param param5 异常信息中占位符替换内容
     */
    public static void publish(String errorCode, String message, String param1, String param2, String param3,
        String param4, String param5) {
        publish(errorCode, message, null, param1, param2, param3, param4, param5);
    }

    /**
     * 抛出异常
     * 
     * @param errorCode 异常码
     * @param message 异常信息描述
     * @param t 抛出的异常
     */
    public static void publish(String errorCode, String message, Throwable t) {
        publish(errorCode, message, t, null, null, null, null, null);
    }

    /**
     * 抛出异常
     * 
     * @param errorCode 异常码
     * @param message 异常信息描述
     * @param t 抛出的异常
     * @param param1 异常信息中占位符替换内容
     */
    public static void publish(String errorCode, String message, Throwable t, String param1) {
        publish(errorCode, message, t, param1, null, null, null, null);
    }

    /**
     * 抛出异常
     * 
     * @param errorCode 异常码
     * @param message 异常信息描述
     * @param t 抛出的异常
     * @param param1 异常信息中占位符替换内容
     * @param param2 异常信息中占位符替换内容
     */
    public static void publish(String errorCode, String message, Throwable t, String param1, String param2) {
        publish(errorCode, message, t, param1, param2, null, null, null);
    }

    /**
     * 抛出异常
     * 
     * @param errorCode 异常码
     * @param message 异常信息描述
     * @param t 抛出的异常
     * @param param1 异常信息中占位符替换内容
     * @param param2 异常信息中占位符替换内容
     * @param param3 异常信息中占位符替换内容
     */
    public static void publish(String errorCode, String message, Throwable t, String param1, String param2,
        String param3) {
        publish(errorCode, message, t, param1, param2, param3, null, null);
    }

    /**
     * 抛出异常
     * 
     * @param errorCode 异常码
     * @param message 异常信息描述
     * @param t 抛出的异常
     * @param param1 异常信息中占位符替换内容
     * @param param2 异常信息中占位符替换内容
     * @param param3 异常信息中占位符替换内容
     * @param param4 异常信息中占位符替换内容
     */
    public static void publish(String errorCode, String message, Throwable t, String param1, String param2,
        String param3, String param4) {
        publish(errorCode, message, t, param1, param2, param3, param4, null);
    }

    /**
     * 抛出异常
     * 
     * @param errorCode 异常码
     * @param message 异常信息描述
     * @param t 抛出的异常
     * @param param1 异常信息中占位符替换内容
     * @param param2 异常信息中占位符替换内容
     * @param param3 异常信息中占位符替换内容
     * @param param4 异常信息中占位符替换内容
     * @param param5 异常信息中占位符替换内容
     */
    public static void publish(String errorCode, String message, Throwable t, String param1, String param2,
        String param3, String param4, String param5) {
        BaseAppException baseAppException;
        if (t instanceof BaseAppException) {
            baseAppException = (BaseAppException) t;
        } else if (t instanceof InvocationTargetException) {
            // 仅仅对此情况进行处理，不能进行深层检查！
            Throwable cause = t.getCause();
            if (cause instanceof BaseAppException) {
                baseAppException = (BaseAppException) cause;
            } else {
                baseAppException = new BaseAppException(errorCode, message, t, param1, param2, param3, param4, param5);
            }
        } else {
            baseAppException = new BaseAppException(errorCode, message, t, param1, param2, param3, param4, param5);
        }

        logErrorInfo(baseAppException);
        throw baseAppException;
    }

    /**
     * Description: 打印日志
     *
     * @param baseAppException 异常
     */
    private static void logErrorInfo(BaseAppException baseAppException) {

        StringBuilder sb = new StringBuilder();

        sb.append(baseAppException.toString());

        StackTraceElement[] trace = baseAppException.getStackTrace();
        for (StackTraceElement aTrace : trace) {
            sb.append("\r\n\tat ");
            sb.append(aTrace);
        }
        Throwable cause = baseAppException.getCause();

        while (cause != null) {
            sb.append("\r\nCause by: ");

            sb.append(cause.toString());

            for (int i = 0; i < cause.getStackTrace().length; i++) {
                sb.append("\r\n\tat ");
                sb.append(cause.getStackTrace()[i]);
            }

            cause = cause.getCause();

            if (cause != null) {
                sb.append("\r\nCaused by: ");
            }
        }

        logger.error(sb.toString());
    }
}
