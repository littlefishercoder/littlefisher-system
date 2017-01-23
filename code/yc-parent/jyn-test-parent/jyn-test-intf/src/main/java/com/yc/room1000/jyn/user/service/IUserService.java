package com.yc.room1000.jyn.user.service;

import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.jyn.user.dto.UserDto;

/**
 * Description: IUserService Created on 2016年12月30日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IUserService {

    /**
     * Description: getAll
     * 
     * @author jinyanan
     * @return List<UserDto>
     * @throws BaseAppException BaseAppException
     */
    List<UserDto> selectAllUser() throws BaseAppException;
    
    /**
     * 
     * Description: selectById
     * 
     * @author jinyanan
     *
     * @param id id
     * @return UserDto
     * @throws BaseAppException BaseAppException
     */
    UserDto selectById(Long id) throws BaseAppException;

    /**
     * 
     * Description: selectUserByDto
     * 
     * @author jinyanan
     *
     * @param qryUser qryUser
     * @return UserDto
     * @throws BaseAppException BaseAppException
     */
    UserDto selectUserByDto(UserDto qryUser) throws BaseAppException;

}