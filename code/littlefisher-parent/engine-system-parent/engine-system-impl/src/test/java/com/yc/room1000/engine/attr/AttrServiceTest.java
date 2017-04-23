package com.yc.room1000.engine.attr;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.spring.config.RootConfig;
import com.littlefisher.core.utils.LittleFisherLogger;

import com.yc.room1000.engine.attr.model.AttrDto;
import com.yc.room1000.engine.attr.model.QryAttrListRequest;
import com.yc.room1000.engine.attr.service.IAttrService;

/**
 * Description: Created on 2017年4月18日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@Transactional
public class AttrServiceTest {

    /**
     * logger
     */
    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(AttrServiceTest.class);

    /**
     * attrService
     */
    @Autowired
    private IAttrService attrService;

    /**
     * 
     * Description: testGetAttrListByCond
     * 
     * @author jinyanan
     *
     * @throws BaseAppException <br>
     */
    @Test
    public void testGetAttrListByCond() throws BaseAppException {
        QryAttrListRequest req = new QryAttrListRequest();
        List<AttrDto> attrList = attrService.getAttrListByCond(req);
        logger.debug("attrList: " + attrList);
    }

    /**
     * 
     * Description: testGetAttrAll
     * 
     * @author jinyanan
     *
     * @throws BaseAppException <br>
     */
    @Test
    public void testGetAttrAll() throws BaseAppException {
        List<AttrDto> attrList = attrService.getAllAttr();
        logger.debug("attrList: " + attrList);
    }
}
