package com.littlefisher.blog.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.intf.user.IUserService;
import com.littlefisher.blog.model.user.UserDto;

/**
 * Description: UserController.java
 *
 * Created on 2017年11月21日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping("/api/blog/v1/users")
@Api(value = "user", description = "user 接口API")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "查询所有用户")
    public List<UserDto> getAllUser() {
        return userService.getAllUser();
    }
}
