package com.yc.core.exception.log.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import com.yc.core.exception.BaseAppException;

/**
 * 
 * Description: ExceptionUtil
 *  
 * Created on 2016年12月30日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class ExceptionUtil {
    
    /** SQLException_ORA */
    public static final int SQL_EXCEPTION_ORA = 1;

    /** SQLException_TT */
    public static final int SQL_EXCEPTION_TT = 2;

    /** SQLException_ABD */
    public static final int SQL_EXCEPTION_ABD = 3;

    /** SQLException_QDB */
    public static final int SQL_EXCEPTION_QDB = 4;

    /** SQLException_ZSMART */
    public static final int SQL_EXCEPTION_ZSMART = 10;

    /** SQLException_UNKNOWN */
    public static final int SQL_EXCEPTION_UNKNOWN = 1000;
    
    /**
     * 构造函数
     */
    private ExceptionUtil() {
    }

    /**
     * 
     * Description:  findMostUsefulInner
     * 
     * @author jinyanan
     *
     * @param t t
     * @return Throwable
     */
    public static Throwable findMostUsefulInner(Throwable t) {
        if (t == null) {
            return null;
        }
        Throwable target = t;
        while (target.getCause() != null) {
            target = target.getCause();
            if (target instanceof Error) {
                return target;
            }
            if (target instanceof SQLException) {
                int type = ExceptionUtil.getSQLExceptionVernderType(target);
                switch (type) {
                    case SQL_EXCEPTION_ORA:
                    case SQL_EXCEPTION_TT:
                    case SQL_EXCEPTION_ZSMART:
                        return target;
                    default:
                }
            }
        }
        return target;
    }

    /**
     * 
     * Description:  getMostInnerException
     * 
     * @author jinyanan
     *
     * @param t t
     * @return Throwable
     */
    public static Throwable getMostInnerException(Throwable t) {
        if (t == null) {
            return null;
        }

        Throwable target = t;
        while (target.getCause() != null) {
            target = target.getCause();
        }
        return target;
    }

    /**
     * 
     * Description:  getFirstBaseAppException
     * 
     * @author jinyanan
     *
     * @param t t
     * @return BaseAppException
     */
    public static BaseAppException getFirstBaseAppException(Throwable t) {
        Throwable cause = t;
        while (cause != null) {
            if (cause instanceof BaseAppException) {
                return (BaseAppException) cause;
            }
            cause = cause.getCause();
        }
        return null;
    }

    /**
     * 
     * Description:  exCheck
     * 
     * @author jinyanan
     *
     * @param arg arg
     * @return Object
     */
    public static Object exCheck(Object arg) {
        if (arg instanceof Throwable) {
            arg = ExceptionUtil.exToString((Throwable) arg);
        }
        return arg;
    }

    /**
     * 
     * Description:  exToString
     * 
     * @author jinyanan
     *
     * @param t t
     * @return String
     */
    public static String exToString(Throwable t) {
        StringWriter sw = new StringWriter(5 * 1024);
        PrintWriter pw = new PrintWriter(sw);
        try {
            t.printStackTrace(pw);
            // pw.flush();
            return sw.toString();
        }
        finally {
            pw.close();
        }
    }

    /**
     * 
     * Description:  getSQLExceptionVernderType
     * 
     * @author jinyanan
     *
     * @param t t
     * @return int
     */
    public static int getSQLExceptionVernderType(Throwable t) {
        StackTraceElement[] steList = t.getStackTrace();
        if (steList == null || steList.length <= 0) {
            return SQL_EXCEPTION_UNKNOWN;
        }
        String name = steList[0].getClassName();
        if (name == null) {
            return SQL_EXCEPTION_UNKNOWN;
        }
        name = name.toLowerCase();
        if (name.startsWith("oracle")) {
            return SQL_EXCEPTION_ORA;
        }
        if (name.startsWith("com.timesten")) {
            return SQL_EXCEPTION_TT;
        }
        if (name.startsWith("altibase")) {
            return SQL_EXCEPTION_ABD;
        }
        if (name.startsWith("com.ztesoft.zsmart.core.jdbc.qdbdriver")) {
            return SQL_EXCEPTION_QDB;
        }
        if (name.startsWith("com.ztesoft")) {
            return SQL_EXCEPTION_ZSMART;
        }
        return SQL_EXCEPTION_UNKNOWN;
    }
}
