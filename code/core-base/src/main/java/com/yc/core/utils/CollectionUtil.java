package com.yc.core.utils;

import java.util.Collection;

/**
 * 
 * Description: Collection集合帮助类
 *  
 * Created on 2016年12月30日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@SuppressWarnings("rawtypes")
public final class CollectionUtil {

    /**
     * 禁止实例化
     */
    private CollectionUtil() {

    }

    /**
     * 
     * Description:  校验Collection是否为空
     * 
     * @author jinyanan
     *
     * @param collection 校验Collection
     * @return boolean true-为空，false-不为空
     */
    public static boolean isEmpty(final Collection collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * 
     * Description:  校验List是否不为空
     * 
     * @author jinyanan
     *
     * @param collection 校验Collection
     * @return boolean true-不为空，false-为空
     */
    public static boolean isNotEmpty(final Collection collection) {
        return !isEmpty(collection);
    }

}
