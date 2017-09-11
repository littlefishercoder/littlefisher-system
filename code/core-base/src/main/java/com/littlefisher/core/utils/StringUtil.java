package com.littlefisher.core.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * Description: 字符串帮助类
 *  
 * Created on 2016年12月30日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class StringUtil extends StringUtils {
    
    /**
     * 禁止实例化
     */
    private StringUtil() {
    }
    
    /**
     * 
     * Description:  检查字符串是否为空，值为null或长度为0都为空
     * 
     * @author jinyanan
     *
     * @param val 要检查的字符串
     * @return boolean true-为空，false-不为空
     */
    public static boolean isEmpty(String val) {
        return val == null || val.length() == 0;
    }

    /**
     * 
     * Description:  检查字符串是否不为空，要求val不为空且长度大于0
     * 
     * @author jinyanan
     *
     * @param val 要检查的字符
     * @return boolean true-为空, false-不为空
     */
    public static boolean isNotEmpty(String val) {
        return val != null && val.length() != 0;
    }
    
    /**
     * 
     * Description:  检查字符串是否全由数字构成的
     * 
     * @author jinyanan
     *
     * @param str 要检查的字符
     * @return boolean true-全数字，false-不全为数字或字符串不存在
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 去掉字符串的空格
     * 
     * @param str 字符串
     * @return String 去掉空格后的字符串
     */
    public static String trim(String str) {
        return (str == null) ? null : str.trim();
    }
    
    /**
     * 
     * Description: 首字母小写
     * 
     * @author jinyanan
     *
     * @param str 字符串
     * @return String String
     */
    public static String uncapitalize(String str) {
        if (isEmpty(str)) {
            return str;
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }
    
    /**
     * 
     * Description: 首字母大写
     * 
     * @author jinyanan
     *
     * @param str 字符串
     * @return String
     */
    public static String capitalize(String str) {
        if (isEmpty(str)) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
