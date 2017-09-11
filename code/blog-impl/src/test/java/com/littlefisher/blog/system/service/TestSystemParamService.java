/**
 * hsjry.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.littlefisher.blog.system.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.littlefisher.blog.system.model.SystemParamDto;
import com.littlefisher.blog.system.model.request.GetSystemParamList4PagerByCondRequest;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.spring.config.RootConfig;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * @author jinyn22648
 * @version $Id: TestSystemParamService.java, v 1.0 2017-09-07 21:00 jinyn22648 Exp $
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
@Transactional
@Rollback
public class TestSystemParamService {

    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(TestSystemParamService.class);

    @Autowired
    private ISystemParamService systemParamService;

    @Test
    public void testGetSystemParamList4PagerByCond() throws BaseAppException {
        GetSystemParamList4PagerByCondRequest request = new GetSystemParamList4PagerByCondRequest();
        request.setPageNum(3);
        request.setPageSize(5);
        List<SystemParamDto> systemParamList = systemParamService.getSystemParamList4PagerByCond(request);
        logger.info("systemParamList: " + systemParamList);
    }
}
