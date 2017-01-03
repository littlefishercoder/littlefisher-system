package com.yc.crm.jyn.service;

import java.util.List;

import com.yc.crm.jyn.dto.UserDto;

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
     */
    List<UserDto> getAll();

    /**
     * Description: selectByPrimaryKey
     * 
     * @author jinyanan
     * @param id id
     * @return UserDto
     */
    UserDto selectByPrimaryKey(Long id);

    /**
     * Description: insert
     * 
     * @author jinyanan
     * @param muser muser
     * @return int
     */
    int insert(UserDto muser);

    /**
     * 
     * Description:  update
     * 
     * @author jinyanan
     *
     * @param muser muser
     * @return int
     */
    int update(UserDto muser);

    /**
     * 
     * Description:  delete
     * 
     * @author jinyanan
     *
     * @param id id
     * @return int
     */
    int delete(Long id);
}
