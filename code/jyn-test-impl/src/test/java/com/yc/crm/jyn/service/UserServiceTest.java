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

import com.yc.core.exception.BaseAppException;
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
@RunWith(SpringJUnit4ClassRunner.class)
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
     * @throws BaseAppException BaseAppException
     *
     */
    @Test
    public void getAll() throws BaseAppException {

        List<UserDto> list = userService.selectAllUser();
        LOGGER.debug(list);
    }
}
