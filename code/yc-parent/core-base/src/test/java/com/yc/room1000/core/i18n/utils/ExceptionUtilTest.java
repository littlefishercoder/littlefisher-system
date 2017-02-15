package com.yc.room1000.core.i18n.utils;

import org.junit.Test;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.utils.ExceptionUtil;
import com.yc.room1000.core.utils.StringUtil;

/**
 * Description: ExceptionUtilTest Created on 2017年1月4日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class ExceptionUtilTest {

    /**
     * Description: 测试ExceptionUtil
     * 
     * @author jinyanan
     * @throws BaseAppException BaseAppException
     */
    @Test
    public void testExceptionUtil() throws BaseAppException {
        String str = "";
        if (StringUtil.isEmpty(str)) {
            ExceptionUtil.publish("COMMON_JYN_00001", "COMMON_JYN_00001测试", null, "ExceptionUtil测试", "jyn",
                "2017-01-04");
        }
    }
}
