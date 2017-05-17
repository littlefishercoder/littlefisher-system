package com.littlefisher.core.utils;

import java.util.List;

/**
 * 
 * Description: List集合帮助类
 *  
 * Created on 2016年12月30日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@SuppressWarnings("rawtypes")
public final class ListUtil {

    /**
     * 禁止实例化
     */
    private ListUtil() {
    }

    /**
     * 
     * Description:  校验List是否为空
     * 
     * @author jinyanan
     *
     * @param list 校验List
     * @return boolean true-为空，false-不为空
     */
    public static boolean isEmpty(List list) {
        if (list == null || list.isEmpty()) {
            return true;
        }

        return false;
    }
    
    /**
     * 
     * Description:  校验List是否不为空
     * 
     * @author jinyanan
     *
     * @param list 校验List
     * @return boolean true-不为空，false-为空
     */
    public static boolean isNotEmpty(List list) {
        if (list != null && !list.isEmpty()) {
            return true;
        }

        return false;
    }

}
