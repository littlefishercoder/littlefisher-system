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


/**
 * 
 * Description: UserServiceTest
 *  
 * Created on 2017年1月3日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@ContextConfiguration("classpath*:spring/spring-core.xml")
@Rollback
@Transactional
public class UserServiceTest {

    /** LOGGER */
    private static final Logger LOGGER = Logger.getLogger(UserServiceTest.class);

    /** userService */
    @Autowired
    private IUserService userService;

    /**
     * 
     * Description: getAll 
     * 
     * @author jinyanan
     *
     */
    @Test
    public void getAll() {

        List<UserDto> list = userService.getAll();
        LOGGER.debug(list);
        LOGGER.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
    }
}
