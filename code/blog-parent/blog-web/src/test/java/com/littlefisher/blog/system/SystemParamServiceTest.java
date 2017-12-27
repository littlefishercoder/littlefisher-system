package com.littlefisher.blog.system;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.littlefisher.blog.user.UserServiceTest;
import com.littlefisher.core.biz.framework.intf.system.ISystemParamService;
import com.littlefisher.core.biz.framework.model.system.SystemParamDto;
import com.littlefisher.core.biz.framework.request.system.GetSystemParamList4PagerByCondRequest;
import com.littlefisher.core.utils.LittleFisherLogger;

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
        GetSystemParamList4PagerByCondRequest req = new GetSystemParamList4PagerByCondRequest();
        req.setPageNum(1);
        req.setPageSize(20);
        List<SystemParamDto> systemParamList = systemParamService.getSystemParamList4PagerByCond(req);
        logger.debug("systemParamList: {}", systemParamList);
    }

}
