package com.littlefisher.core.utils;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月17日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class AssertUtil {

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param obj obj
     * @param msg msg
     * @param <T> <T>
     */
    public static <T> void isNotNull(T obj, String msg) {
        if (obj == null) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param obj obj
     * @param <T> <T>
     */
    public static <T> void isNotNull(T obj) {
        isNotNull(obj, "The value is null.");
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param str str
     * @param msg msg
     */
    public static void isNotEmpty(String str, String msg) {
        if ((str == null) || (str.length() == 0)) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param str str
     */
    public static void isNotEmpty(String str) {
        isNotEmpty(str, "The value is null.");
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param blVal blVal
     * @param msg msg
     */
    public static void isFalse(boolean blVal, String msg) {
        if (blVal) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param blVal blVal
     */
    public static void isFalse(boolean blVal) {
        isFalse(blVal, "The value is not false.");
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param blVal blVal
     * @param msg msg
     */
    public static void isTrue(boolean blVal, String msg) {
        if (!blVal) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param blVal blVal
     */
    public static void isTrue(boolean blVal) {
        isTrue(blVal, "The value is not true.");
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param obj1 obj1
     * @param obj2 obj2
     * @param msg msg
     * @param <T> <T>
     * @param <V> <V>
     */
    public static <T, V> void areEqual(T obj1, V obj2, String msg) {
        if (!obj1.equals(obj2)) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param obj1 obj1
     * @param obj2 obj2
     * @param <T> <T>
     * @param <V> <V>
     */
    public static <T, V> void areEqual(T obj1, V obj2) {
        areEqual(obj1, obj2, "The object is not equal.");
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param array array
     * @param message message
     * @param <T> <T>
     */
    public static <T> void isNotEmpty(T[] array, String message) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param array array
     * @param <T> <T>
     * @return boolean
     */
    private static <T> boolean isEmpty(T[] array) {
        return (array == null || array.length == 0);
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param array array
     * @return boolean
     */
    private static boolean isEmpty(byte[] array) {
        return (array == null || array.length == 0);
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param array array
     * @param message message
     */
    public static void isNotEmpty(byte[] array, String message) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param array array
     */
    public static void isNotEmpty(byte[] array) {
        isNotEmpty(array, "[Assertion failed] - this byte array must not be empty: it must contain at least 1 element");
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param array array
     * @param <T> <T>
     */
    public static <T> void notEmpty(T[] array) {
        isNotEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param str str
     * @param msg msg
     */
    public static void hasLength(String str, String msg) {
        if (str.length() == 0) {
            throw new IllegalArgumentException(msg);
        }
    }
}
