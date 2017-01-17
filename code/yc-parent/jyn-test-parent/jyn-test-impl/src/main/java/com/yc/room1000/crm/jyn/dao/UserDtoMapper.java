package com.yc.room1000.crm.jyn.dao;

import java.util.List;

import com.yc.room1000.crm.jyn.dto.UserDto;

/**
 * 
 * Description: UserDtoMapper
 *  
 * Created on 2017年1月3日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface UserDtoMapper {

    /**
     * 
     * Description: deleteByPrimaryKey 
     * 
     * @author jinyanan
     *
     * @param id id
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 
     * Description: insert 
     * 
     * @author jinyanan
     *
     * @param record record
     * @return int
     */
    int insert(UserDto record);

    /**
     * 
     * Description: insertSelective 
     * 
     * @author jinyanan
     *
     * @param record record
     * @return int
     */
    int insertSelective(UserDto record);

    /**
     * 
     * Description: selectByPrimaryKey
     * 
     * @author jinyanan
     *
     * @param id id
     * @return UserDto
     */
    UserDto selectByPrimaryKey(Long id);
    
    /**
     * 
     * Description: getAll
     * 
     * @author jinyanan
     *
     * @return List<UserDto>
     */
    List<UserDto> getAll();

    /**
     * 
     * Description: updateByPrimaryKeySelective
     * 
     * @author jinyanan
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(UserDto record);

    /**
     * 
     * Description: updateByPrimaryKey
     * 
     * @author jinyanan
     *
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(UserDto record);
}