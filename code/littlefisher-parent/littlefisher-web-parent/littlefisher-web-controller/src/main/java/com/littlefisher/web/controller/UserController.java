package com.littlefisher.web.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.stereotype.constants.BaseConstants;
import com.littlefisher.user.model.UserBizDto;
import com.littlefisher.user.request.AddUserRequest;
import com.littlefisher.user.request.GetUserList4PageByCondRequest;
import com.littlefisher.user.request.UpdateUserRequest;
import com.littlefisher.web.dal.integration.user.IUserIntegration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.oval.constraint.NotBlank;

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
     * Description: 根据条件查询User，分页用
     *
     * @param request request
     * @return List<UserDto>
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation(value = "根据条件查询User，分页用")
    public PageInfo<UserBizDto>
        getUserList4PageByCond(@ApiParam(required = true, value = "根据条件查询User入参，分页用") @ModelAttribute @NotNull(
            message = "请求不能为空") GetUserList4PageByCondRequest request) {
        return userIntegration.getUserList4PageByCond(request);
    }

    /**
     * Description: 根据userId查询对应User
     *
     * @param userId userId
     * @return UserDto
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据userId查询对应User")
    public UserBizDto getUserById(@ApiParam(required = true, value = "User主键") @PathVariable(value = "userId") @NotNull(
        message = "用户id不能为空") @NotBlank(message = "用户id不能为空") Long userId) {
        return userIntegration.getUserById(userId);
    }

    /**
     * Description: 新增User
     *
     * @param request 请求入参
     * @return UserDto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增User")
    public UserBizDto addUser(@ApiParam(required = true,
        value = "User实体") @RequestBody @NotNull(message = "新增用户请求不能为空") AddUserRequest request) {
        return userIntegration.addUser(request);
    }

    /**
     * Description: 修改User
     *
     * @param request 请求入参
     * @return UserDto
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation(value = "修改User")
    public UserBizDto updateUser(@ApiParam(required = true,
        value = "User实体") @RequestBody @NotNull(message = "修改用户请求不能为空") UpdateUserRequest request) {
        return userIntegration.updateUser(request);
    }

    /**
     * Description: 删除User
     *
     * @param userId userId
     * @return int
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除User")
    public int deleteUser(@ApiParam(required = true, value = "User主键") @PathVariable("userId") @NotNull(
        message = "用户id不能为空") @NotBlank(message = "用户id不能为空") Long userId) {
        return userIntegration.deleteUser(userId);
    }
}
