package com.littlefisher.blog.intf.user;

import java.util.List;

import com.littlefisher.blog.model.user.UserStateDto;

/**
 * Description:
 *
 * Created on 2017年5月25日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IUserStateService {

    /**
     * Description: 获取所有用户状态
     *
     * @return List<UserStateDto>
     */
    List<UserStateDto> getAllUserState();

    /**
     * Description: 新增用户状态
     *
     * @param userStateDto userStateDto
     * @return UserStateDto
     */
    UserStateDto addUserState(UserStateDto userStateDto);

    /**
     * Description: 更新用户状态
     *
     * @param userStateDto userStateDto
     * @return UserStateDto
     */
    UserStateDto updateUserState(UserStateDto userStateDto);

    /**
     * Description: 删除用户状态
     *
     * @param state state
     * @return int
     */
    int deleteUserState(String state);
}
