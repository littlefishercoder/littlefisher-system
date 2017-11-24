package com.littlefisher.blog.dao.user;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.user.UserDto;
import com.littlefisher.blog.model.user.UserDtoExample;

/**
 * Description: user Mapper 接口
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface UserDtoMapper extends Mapper<UserDto> {
    /**
     * Description: deleteByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return int int<br>
     */
    int deleteByExample(UserDtoExample example);

    /**
     * Description: selectByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<UserDto> List<UserDto><br>
     */
    List<UserDto> selectByExample(UserDtoExample example);
}