package com.littlefisher.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.littlefisher.core.biz.framework.intf.user.IUserService;
import com.littlefisher.core.biz.framework.model.user.UserDto;
import com.littlefisher.core.biz.framework.request.user.GetUserList4PagerByCondRequest;

/**
 * Description: 用户Controller
 *
 * Created on 2017年5月17日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping("/api/blog/v1/users")
@Api(value = "user", description = "user 接口API")
public class UserController {

    /**
     * userService
     */
    @Autowired
    private IUserService userService;

    /**
     * Description: 根据条件查询User，分页用
     *
     * @param req req
     * @return List<UserDto>
     */
    @RequestMapping(value = "/pager", method = RequestMethod.GET)
    @ApiOperation(value = "根据条件查询User，分页用")
    public PageInfo<UserDto> getUserList4PagerByCond(
            @ApiParam(required = true, value = "根据条件查询User入参，分页用") @ModelAttribute GetUserList4PagerByCondRequest req) {
        List<UserDto> userList = userService.getUserListByCond(req);
        return new PageInfo<>(userList);
    }

    /**
     * Description: 根据userId查询对应User
     *
     * @param userId userId
     * @return UserDto
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据userId查询对应User")
    public UserDto getUserById(
            @ApiParam(required = true, value = "User主键") @PathVariable(value = "userId") Long userId) {
        return userService.getUserById(userId);
    }

    /**
     * Description: 新增User
     *
     * @param userDto userDto
     * @return UserDto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增User")
    public UserDto addUser(@ApiParam(required = true, value = "User实体") @RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    /**
     * Description: 修改User
     *
     * @param userDto userDto
     * @return UserDto
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation(value = "修改User")
    public UserDto updateUser(@ApiParam(required = true, value = "User实体") @RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    /**
     * Description: 删除User
     *
     * @param userId userId
     * @return int
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除User")
    public int deleteUser(@ApiParam(required = true, value = "User主键") @PathVariable("userId") Long userId) {
        return userService.deleteUser(userId);
    }
}
