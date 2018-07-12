package com.littlefisher.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.core.common.stereotype.constants.BaseConstants;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.user.biz.model.UserBizDto;
import com.littlefisher.user.biz.request.AddUserRequest;
import com.littlefisher.user.biz.request.GetUserList4PageByCondRequest;
import com.littlefisher.user.biz.request.LoginRequest;
import com.littlefisher.user.biz.request.RegisterRequest;
import com.littlefisher.user.biz.request.UpdateUserRequest;
import com.littlefisher.web.dal.integration.user.IUserIntegration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

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
@RequestMapping(BaseConstants.BASE_API_PREFIX + "/blog/v1/users")
@Api(value = "user", description = "user 接口API")
public class UserController {

    @Autowired
    private IUserIntegration userIntegration;

    /**
     * 根据条件查询User，分页用
     *
     * @param request 请求入参
     * @return {@link UserBizDto}集合
     */
    @GetMapping("/page")
    @ApiOperation(value = "根据条件查询User，分页用")
    public PageInfo<UserBizDto>
        getUserList4PageByCond(@ApiParam(required = true, value = "根据条件查询User入参，分页用") @ModelAttribute @NotNull(
            message = "请求不能为空") GetUserList4PageByCondRequest request) {
        return userIntegration.getUserList4PageByCond(request);
    }

    /**
     * 根据userId查询对应User
     *
     * @param userId 用户编号
     * @return {@link UserBizDto}
     */
    @GetMapping("/{userId}")
    @ApiOperation(value = "根据userId查询对应User")
    public UserBizDto getUserById(@ApiParam(required = true, value = "User主键") @PathVariable(value = "userId") @NotNull(
        message = "用户id不能为空") @NotBlank(message = "用户id不能为空") Long userId) {
        return userIntegration.getUserById(userId);
    }

    /**
     * 新增User
     *
     * @param request 请求入参
     * @return {@link UserBizDto}
     */
    @PostMapping
    @ApiOperation(value = "新增User")
    public UserBizDto addUser(@ApiParam(required = true,
        value = "User实体") @RequestBody @NotNull(message = "新增用户请求不能为空") AddUserRequest request) {
        return userIntegration.addUser(request);
    }

    /**
     * 登录
     * 
     * @param request 请求入参
     * @return {@link UserBizDto}
     */
    @PostMapping("/login")
    @ApiOperation("登录")
    public UserBizDto login(
        @ApiParam(required = true, value = "登录信息") @RequestBody @NotNull(message = "登录信息不能为空") LoginRequest request) {
        return null;
    }

    /**
     * 注册接口
     * 
     * @param request 请求入参
     * @return {@link UserBizDto}
     */
    @PostMapping("/register")
    public UserBizDto register(@ApiParam(required = true,
        value = "注册信息") @RequestBody @NotNull(message = "注册信息不能为空") RegisterRequest request) {
        return null;
    }

    /**
     * 修改User
     *
     * @param request 请求入参
     * @return {@link UserBizDto}
     */
    @PatchMapping
    @ApiOperation(value = "修改User")
    public UserBizDto updateUser(@ApiParam(required = true,
        value = "User实体") @RequestBody @NotNull(message = "修改用户请求不能为空") UpdateUserRequest request) {
        return userIntegration.updateUser(request);
    }

    /**
     * 删除User
     *
     * @param userId userId
     * @return int
     */
    @DeleteMapping("/{userId}")
    @ApiOperation(value = "删除User")
    public int deleteUser(@ApiParam(required = true, value = "User主键") @PathVariable("userId") @NotNull(
        message = "用户id不能为空") @NotBlank(message = "用户id不能为空") Long userId) {
        return userIntegration.deleteUser(userId);
    }
}
