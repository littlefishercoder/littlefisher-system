package com.littlefisher.core.biz.framework.service;

import java.util.List;

import com.littlefisher.core.biz.framework.model.UserDto;
import com.littlefisher.core.biz.framework.request.GetUserList4PagerByCondRequest;

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
    List<UserDto> getAllUser();

    /**
     * Description: 根据条件查询用户列表
     *
     * @param req req
     * @return List<UserDto>
     */
    List<UserDto> getUserListByCond(GetUserList4PagerByCondRequest req);

    /**
     * Description: 根据id查询用户
     *
     * @param userId userId
     * @return UserDto
     */
    UserDto getUserById(Long userId);

    /**
     * Description: 新增用户
     *
     * @param userDto userDto
     * @return UserDto
     */
    UserDto addUser(UserDto userDto);

    /**
     * Description: 修改用户
     *
     * @param userDto userDto
     * @return UserDto
     */
    UserDto updateUser(UserDto userDto);

    /**
     * Description: 删除用户
     *
     * @param userId userId
     * @return int
     */
    int deleteUser(Long userId);

    /**
     * 根据用户编号列表查询用户
     * @param userIdList 用户编号列表
     * @return 用户
     */
    List<UserDto> getUserListByIds(List<Long> userIdList);
}
