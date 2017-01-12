package com.yc.crm.jyn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.core.exception.BaseAppException;
import com.yc.crm.jyn.dto.UserDto;
import com.yc.crm.jyn.service.IUserService;

/**
 * 
 * Description: UserController
 *  
 * Created on 2016年12月30日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 使用@Autowired能完成自动装配，也就是省略了get/set方法
     */
    @Autowired
    private IUserService userService;

    /**
     * 
     * Description:  listUser
     * 
     * @author jinyanan
     *
     * @return String
     * @throws BaseAppException 
     */
    @RequestMapping(value = "/listUser")
    public List<UserDto> listUser() throws BaseAppException {

        List<UserDto> list = userService.selectAllUser();
        return list;
    }

}
