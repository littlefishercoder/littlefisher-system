package com.yc.core.utils;

import java.lang.reflect.InvocationTargetException;

import com.yc.core.exception.BaseAppException;

/**
 * Description: 该类提供给业务侧使用，提供抛出异常的方法 Created on 2016年12月30日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class ExceptionUtil {

    /**
     * 禁止实例化
     */
    private ExceptionUtil() {
    }

    /** LOGGER */
    private static final Room1000Logger LOGGER = Room1000Logger.getLogger(ExceptionUtil.class);

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param errorCode errorCode
     * @param t t
     * @return BaseAppException
     * @throws BaseAppException BaseAppException
     */
    public static BaseAppException publish(String errorCode, Throwable t) throws BaseAppException {
        return publish(errorCode, null, t, null, null, null);
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param errorCode errorCode
     * @return BaseAppException
     * @throws BaseAppException BaseAppException
     */
    public static BaseAppException publish(String errorCode) throws BaseAppException {
        return publish(errorCode, null, null, null, null, null);
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param errorCode errorCode
     * @param msg msg
     * @return BaseAppException
     * @throws BaseAppException BaseAppException
     */
    public static BaseAppException publish(String errorCode, String msg) throws BaseAppException {
        return publish(errorCode, msg, null, null, null, null);
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param errorCode errorCode
     * @param msg msg
     * @param t t
     * @return BaseAppException
     * @throws BaseAppException BaseAppException
     */
    public static BaseAppException publish(String errorCode, String msg, Throwable t) throws BaseAppException {
        return publish(errorCode, msg, t, null, null, null);
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param errorCode errorCode
     * @param msg msg
     * @param t t
     * @param param param
     * @return BaseAppException
     * @throws BaseAppException BaseAppException
     */
    public static BaseAppException publish(String errorCode, String msg, Throwable t, String param)
        throws BaseAppException {
        return publish(errorCode, msg, t, param, null, null);
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param errorCode errorCode
     * @param msg msg
     * @param param1 param1
     * @return BaseAppException
     * @throws BaseAppException BaseAppException
     */
    public static BaseAppException publish(String errorCode, String msg, String param1) throws BaseAppException {
        return publish(errorCode, msg, null, param1, null, null);
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param errorCode errorCode
     * @param msg msg
     * @param param1 param1
     * @param param2 param2
     * @return BaseAppException
     * @throws BaseAppException BaseAppException
     */
    public static BaseAppException publish(String errorCode, String msg, String param1, String param2)
        throws BaseAppException {
        return publish(errorCode, msg, null, param1, param2, null);
    }

    /**
     * Description:
     * 
     * @author jinyanan
     * @param errorCode errorCode
     * @param msg msg
     * @param t t
     * @param param1 param1
     * @param param2 param2
     * @param param3 param3
     * @return BaseAppException
     * @throws BaseAppException BaseAppException
     */
    public static BaseAppException publish(String errorCode, String msg, Throwable t, String param1, String param2,
        String param3) throws BaseAppException {

        BaseAppException baseAppException;
        if (t instanceof BaseAppException) {
            baseAppException = (BaseAppException) t;
        }
        else if (t instanceof InvocationTargetException) {
            // 仅仅对此情况进行处理，不能进行深层检查！
            Throwable cause = t.getCause();
            if (cause instanceof BaseAppException) {
                baseAppException = (BaseAppException) cause;
            }
            else {
                baseAppException = new BaseAppException(errorCode, msg, t, param1, param2, param3);
            }
        }
        else {
            baseAppException = new BaseAppException(errorCode, msg, t, param1, param2, param3);
        }

        logErrorInfo(baseAppException);
        throw baseAppException;
    }

    /**
     * Description: 打印日志
     * 
     * @author jinyanan
     * @param baseAppException 异常
     */
    private static void logErrorInfo(BaseAppException baseAppException) {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(baseAppException.toString());
//        if (baseAppException.getDesc() != null) {
//            sb.append("\r\n").append(baseAppException.getDesc());
//        }
        
        StackTraceElement[] trace = baseAppException.getStackTrace();
        for (int i = 0; i < trace.length; i++) {
            sb.append("\r\n\tat ");
            sb.append(trace[i]);
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

        LOGGER.error(sb.toString());
    }
}
