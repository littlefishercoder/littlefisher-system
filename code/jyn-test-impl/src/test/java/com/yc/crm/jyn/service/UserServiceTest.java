package com.yc.crm.jyn.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.yc.crm.jyn.dto.UserDto;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@ContextConfiguration("classpath*:spring/spring.xml")
@Rollback
@Transactional
public class UserServiceTest {

    private static final Logger LOGGER = Logger.getLogger(UserServiceTest.class);

    @Autowired
    private IUserService userService;

    @Test
    public void getAll() {

        List<UserDto> list = userService.getAll();
        System.out.println(list);
        LOGGER.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
    }
}
