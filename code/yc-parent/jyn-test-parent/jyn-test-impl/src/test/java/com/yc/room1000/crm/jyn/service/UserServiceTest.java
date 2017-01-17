package com.yc.room1000.crm.jyn.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.crm.jyn.dto.UserDto;


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
    
    /**
     * 
     * Description: getUserById
     * 
     * @author jinyanan
     *
     * @throws BaseAppException BaseAppException
     */
    @Test
    public void getUserById() throws BaseAppException {
        Long id = 1L;
        UserDto user = userService.selectById(id);
        LOGGER.debug(user);
    }
    
    /**
     * 
     * Description: getUserByDto
     * 
     * @author jinyanan
     *
     * @throws BaseAppException BaseAppException
     */
    @Test
    public void getUserByDto() throws BaseAppException {
        UserDto qryUser = new UserDto();
        qryUser.setId(1L);
        UserDto user = userService.selectUserByDto(qryUser);
        LOGGER.debug(user);
    }
}
