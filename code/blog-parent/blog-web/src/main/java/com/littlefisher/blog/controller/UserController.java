package com.littlefisher.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.oval.constraint.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.littlefisher.core.biz.framework.request.AddUserRequest;
import com.littlefisher.core.biz.framework.request.UpdateUserRequest;
import com.littlefisher.core.biz.framework.service.IUserService;
import com.littlefisher.core.biz.framework.model.UserDto;
import com.littlefisher.core.biz.framework.request.GetUserList4PagerByCondRequest;
import com.littlefisher.core.stereotype.constants.BaseConstants;

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
    private IUserService userService;

    /**
     * Description: 根据条件查询User，分页用
     *
     * @param request request
     * @return List<UserDto>
     */
    @RequestMapping(value = "/pager", method = RequestMethod.GET)
    @ApiOperation(value = "根据条件查询User，分页用")
    public PageInfo<UserDto> getUserList4PagerByCond(
            @ApiParam(required = true, value = "根据条件查询User入参，分页用") @ModelAttribute @NotNull(message = "请求不能为空")
                    GetUserList4PagerByCondRequest request) {
        List<UserDto> userList = userService.getUserListByCond(request);
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
            @ApiParam(required = true, value = "User主键") @PathVariable(value = "userId") @NotNull(message = "用户id不能为空")
            @NotBlank(message = "用户id不能为空") Long userId) {
        return userService.getUserById(userId);
    }

    /**
     * Description: 新增User
     *
     * @param request 请求入参
     * @return UserDto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增User")
    public UserDto addUser(@ApiParam(required = true, value = "User实体") @RequestBody @NotNull(message = "新增用户请求不能为空")
            AddUserRequest request) {
        return userService.addUser(request);
    }

    /**
     * Description: 修改User
     *
     * @param request 请求入参
     * @return UserDto
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation(value = "修改User")
    public UserDto updateUser(@ApiParam(required = true, value = "User实体") @RequestBody @NotNull(message = "修改用户请求不能为空")
            UpdateUserRequest request) {
        return userService.updateUser(request);
    }

    /**
     * Description: 删除User
     *
     * @param userId userId
     * @return int
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除User")
    public int deleteUser(
            @ApiParam(required = true, value = "User主键") @PathVariable("userId") @NotNull(message = "用户id不能为空")
            @NotBlank(message = "用户id不能为空") Long userId) {
        return userService.deleteUser(userId);
    }
}
