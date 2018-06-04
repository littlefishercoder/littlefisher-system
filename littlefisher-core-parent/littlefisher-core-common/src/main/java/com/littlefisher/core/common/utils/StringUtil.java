package com.littlefisher.core.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * Description: 字符串帮助类
 * 继承了org.apache.commons.lang3.StringUtils，
 * 所以尽量使用StringUtil，以防后续新增一些org.apache.commons.lang3.StringUtils没有的方法
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
    
}
