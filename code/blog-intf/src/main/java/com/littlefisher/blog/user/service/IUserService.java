package com.littlefisher.blog.user.service;

import java.util.List;

import com.littlefisher.blog.user.model.UserDto;
import com.littlefisher.blog.user.model.request.GetUserList4PagerByCondRequest;
import com.littlefisher.core.exception.BaseAppException;

/**
 * 
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
     * 
     * Description: 查询所有用户
     * 
     * @author jinyanan
     *
     * @return List<UserDto>
     * @throws BaseAppException <br>
     */
    List<UserDto> getAllUser() throws BaseAppException;
    
    /**
     * 
     * Description: 根据条件查询用户列表
     * 
     * @author jinyanan
     *
     * @param req req
     * @return List<UserDto>
     * @throws BaseAppException <br>
     */
    List<UserDto> getUserListByCond(GetUserList4PagerByCondRequest req) throws BaseAppException;
    
    /**
     * 
     * Description: 根据id查询用户
     * 
     * @author jinyanan
     *
     * @param userId userId
     * @return UserDto
     * @throws BaseAppException <br>
     */
    UserDto getUserById(Long userId) throws BaseAppException;
    
    /**
     * 
     * Description: 新增用户
     * 
     * @author jinyanan
     *
     * @param userDto userDto
     * @return UserDto
     * @throws BaseAppException <br>
     */
    UserDto addUser(UserDto userDto) throws BaseAppException;
    
    /**
     * 
     * Description: 修改用户
     * 
     * @author jinyanan
     *
     * @param userDto userDto
     * @return UserDto
     * @throws BaseAppException <br>
     */
    UserDto updateUser(UserDto userDto) throws BaseAppException;
    
    /**
     * 
     * Description: 删除用户
     * 
     * @author jinyanan
     *
     * @param userId userId
     * @return int
     * @throws BaseAppException <br>
     */
    int deleteUser(Long userId) throws BaseAppException;
}
