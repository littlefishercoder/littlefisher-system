package com.littlefisher.blog.deploy.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.littlefisher.core.utils.LittleFisherLogger;
import com.littlefisher.user.model.UserBizDto;
import com.littlefisher.user.service.IUserService;

/**
 * Description: UserServiceTest.java
 *
 * Created on 2017年11月21日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(UserServiceTest.class);

    @Autowired
    private IUserService userService;

    @Test
    public void testQryAllUser() {
        List<UserBizDto> userList = userService.getAllUser();
        logger.debug("userList: {}", userList);
    }
}
