package com.littlefisher.core.common.utils;

/**
 * Description:
 *
 * Created on 2017年1月17日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class AssertUtil {

    /**
     * 私有构造函数
     */
    private AssertUtil() {}

    /**
     * 校验是否不为null
     * 
     * @param obj 校验的参数
     * @param msg 如果为null，抛出信息
     * @param <T> 泛型
     */
    public static <T> void isNotNull(T obj, String msg) {
        if (obj == null) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 校验是否不为null
     * 
     * @param obj 校验的参数
     * @param <T> 泛型
     */
    public static <T> void isNotNull(T obj) {
        isNotNull(obj, "The value is null.");
    }

    /**
     * 校验字符串是否不为空
     * 
     * @param str 校验的字符串
     * @param msg 如果为空，抛出信息
     */
    public static void isNotEmpty(String str, String msg) {
        if (StringUtil.isEmpty(str)) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 校验字符串是否不为空
     *
     * @param str 校验的字符串
     */
    public static void isNotEmpty(String str) {
        isNotEmpty(str, "The value is null.");
    }

    /**
     * 校验byte数组是否为空
     *
     * @param array 数组
     * @param message 为空时抛出的异常信息
     */
    public static void isNotEmpty(byte[] array, String message) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 校验数组是否为空
     *
     * @param array 数组
     * @param message 数组为空时抛出的异常信息
     * @param <T> 泛型
     */
    public static <T> void isNotEmpty(T[] array, String message) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 校验byte数组是否为空
     *
     * @param array 数组
     */
    public static void isNotEmpty(byte[] array) {
        isNotEmpty(array, "[Assertion failed] - this byte array must not be empty: it must contain at least 1 element");
    }

    /**
     * 校验数组是否为空
     *
     * @param array 数组
     * @param <T> 泛型
     */
    public static <T> void isNotEmpty(T[] array) {
        isNotEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    /**
     * 校验boolean型参数是否为false
     * 
     * @param blVal boolean型参数
     * @param msg 如果不为false所抛出的异常描述信息
     */
    public static void isFalse(boolean blVal, String msg) {
        if (blVal) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 校验boolean型参数是否为false
     *
     * @param blVal boolean型参数
     */
    public static void isFalse(boolean blVal) {
        isFalse(blVal, "The value is not false.");
    }

    /**
     * 校验boolean型参数是否为true
     *
     * @param blVal boolean型参数
     * @param msg 如果不为true所抛出的异常描述信息
     */
    public static void isTrue(boolean blVal, String msg) {
        if (!blVal) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 校验boolean型参数是否为true
     *
     * @param blVal boolean型参数
     */
    public static void isTrue(boolean blVal) {
        isTrue(blVal, "The value is not true.");
    }

    /**
     * 校验两个参数是否相等
     * 
     * @param obj1 参数1
     * @param obj2 参数2
     * @param msg 如果不同抛出的异常信息
     * @param <T> 参数1泛型
     * @param <V> 参数2泛型
     */
    public static <T, V> void areEqual(T obj1, V obj2, String msg) {
        if (!obj1.equals(obj2)) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 校验两个参数是否相等
     *
     * @param obj1 参数1
     * @param obj2 参数2
     * @param <T> 参数1泛型
     * @param <V> 参数2泛型
     */
    public static <T, V> void areEqual(T obj1, V obj2) {
        areEqual(obj1, obj2, "The object is not equal.");
    }

    /**
     * 校验数组是否为空
     *
     * @param array 数组
     * @param <T> 泛型
     * @return true为空，false不为空
     */
    private static <T> boolean isEmpty(T[] array) {
        return (array == null || array.length == 0);
    }

    /**
     * 校验byte数组是否为空
     *
     * @param array 数组
     * @return true为空，false不为空
     */
    private static boolean isEmpty(byte[] array) {
        return (array == null || array.length == 0);
    }

    /**
     * 校验字符串长度是否为0
     * 
     * @param str 字符串
     * @param msg 字符串长度为0时抛出异常信息
     */
    public static void hasLength(String str, String msg) {
        if (str.length() == 0) {
            throw new IllegalArgumentException(msg);
        }
    }
}
