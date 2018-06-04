package com.littlefisher.blog.deploy.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.littlefisher.blog.deploy.user.UserServiceTest;
import com.littlefisher.core.common.utils.LittleFisherLogger;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.user.model.SystemParamBizDto;
import com.littlefisher.user.request.GetSystemParamList4PageByCondRequest;
import com.littlefisher.user.service.ISystemParamService;

/**
 * Description: SystemParamServiceTest.java
 *
 * Created on 2017年12月01日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemParamServiceTest {
    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(UserServiceTest.class);

    @Autowired
    private ISystemParamService systemParamService;

    @Test
    public void testGetSystemParamList4PagerByCond() {
        GetSystemParamList4PageByCondRequest req = new GetSystemParamList4PageByCondRequest();
        req.setPageNum(1);
        req.setPageSize(20);
        PageInfo<SystemParamBizDto> systemParamList = systemParamService.getSystemParamList4PageByCond(req);
        logger.debug("systemParamList: {}", systemParamList);
    }

}
