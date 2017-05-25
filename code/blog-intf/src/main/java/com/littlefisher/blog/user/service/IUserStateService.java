package com.littlefisher.blog.user.service;

import java.util.List;

import com.littlefisher.blog.user.model.UserStateDto;
import com.littlefisher.core.exception.BaseAppException;

/**
 * 
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
     * 
     * Description: 获取所有用户状态
     * 
     * @author jinyanan
     *
     * @return List<UserStateDto>
     * @throws BaseAppException <br>
     */
    List<UserStateDto> getAllUserState() throws BaseAppException;

    /**
     * 
     * Description: 新增用户状态
     * 
     * @author jinyanan
     *
     * @param userStateDto userStateDto
     * @return UserStateDto
     * @throws BaseAppException <br>
     */
    UserStateDto addUserState(UserStateDto userStateDto) throws BaseAppException;
    
    /**
     * 
     * Description: 更新用户状态
     * 
     * @author jinyanan
     *
     * @param userStateDto userStateDto
     * @return UserStateDto
     * @throws BaseAppException <br>
     */
    UserStateDto updateUserState(UserStateDto userStateDto) throws BaseAppException;
    
    /**
     * 
     * Description: 删除用户状态
     * 
     * @author jinyanan
     *
     * @param state state
     * @return int
     * @throws BaseAppException <br>
     */
    int deleteUserState(String state) throws BaseAppException;
}
