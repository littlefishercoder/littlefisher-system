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

    /**
     * 
     * Description:  
     * 
     * @author jinyanan
     *
     * @param errorCode errorCode
     * @param msg msg
     * @param errorType errorType
     * @param t t
     * @param param1 param1
     * @param param2 param2
     * @param param3 param3
     * @return BaseAppException
     * @throws BaseAppException BaseAppException
     */
    public static BaseAppException publish(String errorCode, String msg, int errorType, Throwable t, String param1,
        String param2, String param3) throws BaseAppException {

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
                baseAppException = new BaseAppException(errorCode, msg, errorType, t, param1, param2, param3);
            }
        }
        else {
            baseAppException = new BaseAppException(errorCode, msg, errorType, t, param1, param2, param3);
        }

        // 记录日志,统一由callService记录日志
        // logErrorInfo(baseAppException);
        throw baseAppException;
    }
}
