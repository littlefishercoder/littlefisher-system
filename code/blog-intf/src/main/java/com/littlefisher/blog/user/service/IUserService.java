package com.littlefisher.blog.user.service;

import java.util.List;

import com.littlefisher.blog.user.model.UserDto;
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
     * Description: 
     * 
     * @author jinyanan
     *
     * @return List<UserDto>
     * @throws BaseAppException <br>
     */
    List<UserDto> getAllUser() throws BaseAppException;
    
    /**
     * 
     * Description: 
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
     * Description: 
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
     * Description: 
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
     * Description: 
     * 
     * @author jinyanan
     *
     * @param userId userId
     * @return int
     * @throws BaseAppException <br>
     */
    int deleteUser(Long userId) throws BaseAppException;
}
