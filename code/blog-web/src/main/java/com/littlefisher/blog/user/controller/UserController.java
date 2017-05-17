package com.littlefisher.blog.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.user.model.UserDto;
import com.littlefisher.blog.user.service.IUserService;
import com.littlefisher.core.exception.BaseAppException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Description: 
 *  
 * Created on 2017年5月17日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping("/user")
@Api(value = "user", description = "user 接口API")
public class UserController {
    
    /**
     * userService
     */
    @Autowired
    private IUserService userService;
    
    /**
     * 
     * Description: 根据userId查询对应User
     * 
     * @author jinyanan
     *
     * @param userId userId
     * @return UserDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据userId查询对应User")
    public UserDto getUserById(
        @ApiParam(required = true, value = "User主键") @PathVariable(value = "userId") Long userId) throws BaseAppException {
        return userService.getUserById(userId);
    }
    
    /**
     * 
     * Description: 新增User
     * 
     * @author jinyanan
     *
     * @param userDto userDto
     * @return UserDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增User")
    public UserDto addUser(@RequestBody UserDto userDto) throws BaseAppException {
        return userService.addUser(userDto);
    }
    
    /**
     * 
     * Description: 修改User
     * 
     * @author jinyanan
     *
     * @param userDto userDto
     * @return UserDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation(value = "修改User")
    public UserDto updateUser(@RequestBody UserDto userDto) throws BaseAppException {
        return userService.updateUser(userDto);
    }
    
    /**
     * 
     * Description: 删除User
     * 
     * @author jinyanan
     *
     * @param userId userId
     * @return int
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除User")
    public int deleteUser(
        @ApiParam(required = true, value = "User主键") @PathVariable("userId") Long userId) throws BaseAppException {
        return userService.deleteUser(userId);
    }
}
