package com.yc.room1000.core.activiti.table;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yc.room1000.core.utils.Room1000Logger;

/**
 * 
 * Description: 测试Table
 *  
 * Created on 2017年1月11日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:activiti.cfg.xml")
@Rollback
@Transactional
public class TableTest {
    
    /** logger */
    private Room1000Logger logger = Room1000Logger.getLogger(TableTest.class);

    /**
     * 
     * Description: testCreateTable
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testCreateTable() {
        logger.debug("createTable");
//        System.out.println("createTable");
    }
}
