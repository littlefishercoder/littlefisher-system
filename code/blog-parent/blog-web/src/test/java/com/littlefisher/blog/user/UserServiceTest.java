package com.littlefisher.blog.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.littlefisher.core.biz.framework.intf.user.IUserService;
import com.littlefisher.core.biz.framework.model.user.UserDto;
import com.littlefisher.core.utils.LittleFisherLogger;

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
        List<UserDto> userList = userService.getAllUser();
        logger.debug("userList: {}", userList);
    }
}
