package com.littlefisher.core.biz.framework.service;

import java.util.List;

import com.littlefisher.core.biz.framework.model.UserBizDto;
import com.littlefisher.core.biz.framework.request.AddUserRequest;
import com.littlefisher.core.biz.framework.request.GetUserList4PageByCondRequest;
import com.littlefisher.core.biz.framework.request.UpdateUserRequest;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;

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
     * Description: 查询所有用户
     *
     * @return List<UserDto>
     */
    List<UserBizDto> getAllUser();

    /**
     * Description: 根据条件查询用户列表
     *
     * @param req req
     * @return List<UserDto>
     */
    PageInfo<UserBizDto> getUserList4PageByCond(GetUserList4PageByCondRequest req);

    /**
     * Description: 根据id查询用户
     *
     * @param userId userId
     * @return UserDto
     */
    UserBizDto getUserById(Long userId);

    /**
     * Description: 新增用户
     *
     * @param request userDto
     * @return UserDto
     */
    UserBizDto addUser(AddUserRequest request);

    /**
     * Description: 修改用户
     *
     * @param request userDto
     * @return UserDto
     */
    UserBizDto updateUser(UpdateUserRequest request);

    /**
     * Description: 删除用户
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
