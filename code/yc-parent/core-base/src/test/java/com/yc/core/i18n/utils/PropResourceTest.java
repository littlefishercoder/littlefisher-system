package com.yc.core.i18n.utils;


import org.junit.Test;

import com.yc.room1000.core.i18n.PropResource;
import com.yc.room1000.core.utils.Room1000Logger;

/**
 * 
 * Description: PropResourceTest
 *  
 * Created on 2017年1月3日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class PropResourceTest {
    
    /** LOGGER */
    private static final Room1000Logger LOGGER = Room1000Logger.getLogger(PropResourceTest.class);
    
    /**
     * 
     * Description: 测试查询资源文件
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testPropResource() {
        String value = PropResource.getValue("en", "ABC");
        LOGGER.debug(value);
    }
}
