package com.littlefisher.user.service;

import java.util.List;

import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.user.model.UserBizDto;
import com.littlefisher.user.request.AddUserRequest;
import com.littlefisher.user.request.GetUserList4PageByCondRequest;
import com.littlefisher.user.request.UpdateUserRequest;

/**
 * Description:
 *
 * Created on 2017年5月17日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IUserService {

    /**
     * 查询所有用户
     *
     * @return 所有用户
     */
    List<UserBizDto> getAllUser();

    /**
     * 根据条件查询用户列表
     *
     * @param req req
     * @return 用户列表
     */
    PageInfo<UserBizDto> getUserList4PageByCond(GetUserList4PageByCondRequest req);

    /**
     * 根据id查询用户
     *
     * @param userId userId
     * @return UserDto
     */
    UserBizDto getUserById(Long userId);

    /**
     * 新增用户
     *
     * @param request userDto
     * @return UserDto
     */
    UserBizDto addUser(AddUserRequest request);

    /**
     * 修改用户
     *
     * @param request userDto
     * @return UserDto
     */
    UserBizDto updateUser(UpdateUserRequest request);

    /**
     * 删除用户
     *
     * @param userId userId
     * @return int
     */
    int deleteUser(Long userId);

    /**
     * 根据用户编号列表查询用户
     * 
     * @param userIdList 用户编号列表
     * @return 用户
     */
    List<UserBizDto> getUserListByIdList(List<Long> userIdList);
}
