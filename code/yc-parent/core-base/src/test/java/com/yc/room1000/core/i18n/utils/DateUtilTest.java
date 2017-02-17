package com.yc.room1000.core.i18n.utils;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.utils.DateUtil;
import com.yc.room1000.core.utils.Room1000Logger;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月18日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/EngineConfig.xml")
@Rollback(true)
@Transactional
public class DateUtilTest {
    
    /**
     * logger
     */
    private Room1000Logger logger = Room1000Logger.getLogger(DateUtilTest.class);

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     * @throws BaseAppException 
     *
     */
    @Test
    public void testGetDBCurrentTime() throws BaseAppException {
        Date date = DateUtil.getDBDateTime();
        logger.debug("date:" + date);
    }
}
