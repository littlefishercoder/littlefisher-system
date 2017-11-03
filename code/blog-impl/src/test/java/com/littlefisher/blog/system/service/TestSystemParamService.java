/**
 * littlefisher.site Inc.
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
import com.littlefisher.core.config.RootConfig;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
 *
 * Description:
 *
 * Created on 2017年09月11日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
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
