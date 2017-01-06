package com.yc.core.utils;

/**
 * 
 * Description: 相等性比较类
 *  
 * Created on 2016年12月30日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class EqualsUtil {

    /**
     * 禁止实例化
     */
    private EqualsUtil() {
    }

    /**
     * 
     * Description:  比较两个int值是否相等.
     * 
     * @author jinyanan
     *
     * @param a int
     * @param b int
     * @return boolean true-相等, false-不相等
     */
    public static boolean equals(int a, int b) {
        return (a == b);
    }

    /**
     * 
     * Description:  比较两个long值是否相等.
     * 
     * @author jinyanan
     *
     * @param a long
     * @param b long
     * @return boolean true-相等, false-不相等
     */
    public static boolean equals(long a, long b) {
        return (a == b);
    }

    /**
     * 
     * Description:  比较两个float值是否相等.
     * 
     * @author jinyanan
     *
     * @param a float
     * @param b float
     * @return boolean true-相等, false-不相等
     */
    public static boolean equals(float a, float b) {
        return (a == b);
    }

    /**
     * 
     * Description:  比较两个short值是否相等.
     * 
     * @author jinyanan
     *
     * @param a short
     * @param b short
     * @return boolean true-相等, false-不相等
     */
    public static boolean equals(short a, short b) {
        return (a == b);
    }

    /**
     * 
     * Description:  比较两个double值是否相等.
     * 
     * @author jinyanan
     *
     * @param a double
     * @param b double
     * @return boolean true-相等, false-不相等
     */
    public static boolean equals(double a, double b) {
        return (a == b);
    }

    /**
     * 
     * Description:  比较字符串是否相等(去掉首尾的空格之后再比较),调用对象的equals()方法来比较. 当对象为null时不会抛出NullPointerException异常.
     * 
     * @author jinyanan
     *
     * @param a String
     * @param b String
     * @return boolean true-相等, false-不相等
     */
    public static boolean equalsTrim(String a, String b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return (a.trim().equals(b.trim()));
    }

    /**
     * 
     * Description:  比较两个字符串是否相等, 忽略大小写.调用对象的equalsIgnoreCase()方法来比较. 当对象为null时不会抛出NullPointerException异常
     * 
     * @author jinyanan
     *
     * @param a String
     * @param b String
     * @return boolean true-相等, false-不相等
     */
    public static boolean equalsIgnoreCase(String a, String b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return (a.equalsIgnoreCase(b));
    }

    /**
     * 
     * Description:  比较对象数组
     * 
     * @author jinyanan
     *
     * @param a Object[]
     * @param b Object[]
     * @return boolean true-相等, false-不相等
     */
    public static boolean equals(Object[] a, Object[] b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!equals(a[i], b[i])) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * Description:  比较对象
     * 
     * @author jinyanan
     *
     * @param a Object
     * @param b Object
     * @return boolean true-相等, false-不相等
     */
    public static boolean equals(Object a, Object b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }

}
