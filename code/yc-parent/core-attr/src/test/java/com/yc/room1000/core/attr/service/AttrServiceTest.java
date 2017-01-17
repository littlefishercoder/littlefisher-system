package com.yc.room1000.core.attr.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yc.room1000.core.attr.dto.AttrDto;
import com.yc.room1000.core.utils.Room1000Logger;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月16日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/spring-core.xml")
@Rollback(true)
@Transactional
public class AttrServiceTest {
    
    /**
     * logger
     */
    private static Room1000Logger logger = Room1000Logger.getLogger(AttrServiceTest.class);
    
    /**
     * attrService
     */
    @Autowired
    private IAttrService attrService;

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testGetAttrDtoById() {
        AttrDto attr = attrService.getAttrDtoById(1L);
        logger.debug("attrDto: " + attr);
    }
}
