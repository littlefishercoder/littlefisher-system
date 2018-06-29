package com.littlefisher.user.biz.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.spring.cloud.feign.annotation.JsonArgument;
import com.littlefisher.user.biz.model.UserBizDto;
import com.littlefisher.user.biz.request.AddUserRequest;
import com.littlefisher.user.biz.request.GetUserList4PageByCondRequest;
import com.littlefisher.user.biz.request.UpdateUserRequest;

/**
 * Description:
 *
 * Created on 2017年5月17日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@FeignClient(value = "user-service", path = "/users")
public interface IUserService {

    /**
     * 查询所有用户
     *
     * @return 所有用户
     */
    @GetMapping
    List<UserBizDto> getAllUser();

    /**
     * 根据条件查询用户列表
     *
     * @param req req
     * @return 用户列表
     */
    @GetMapping("/page")
    PageInfo<UserBizDto> getUserList4PageByCond(@ModelAttribute GetUserList4PageByCondRequest req);

    /**
     * 根据id查询用户
     *
     * @param userId userId
     * @return UserDto
     */
    @GetMapping("/{userId}")
    UserBizDto getUserById(@PathVariable("userId") Long userId);

    /**
     * 新增用户
     *
     * @param request userDto
     * @return UserDto
     */
    @PostMapping
    UserBizDto addUser(@RequestBody AddUserRequest request);

    /**
     * 修改用户
     *
     * @param request userDto
     * @return UserDto
     */
    @PatchMapping
    UserBizDto updateUser(@RequestBody UpdateUserRequest request);

    /**
     * 删除用户
     *
     * @param userId userId
     * @return int
     */
    @DeleteMapping("/{userId}")
    int deleteUser(@PathVariable("userId") Long userId);

    /**
     * 根据用户编号列表查询用户
     * 
     * @param userIdList 用户编号列表
     * @return 用户
     */
    @GetMapping(value = "/userIds", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<UserBizDto> getUserListByIdList(@JsonArgument("userIdList") List<Long> userIdList);
}
