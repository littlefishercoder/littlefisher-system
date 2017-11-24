package com.littlefisher.blog.dao.user;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.user.UserStateDto;
import com.littlefisher.blog.model.user.UserStateDtoExample;

/**
 * Description: user_state Mapper 接口
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface UserStateDtoMapper extends Mapper<UserStateDto> {
    /**
     * Description: deleteByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return int int<br>
     */
    int deleteByExample(UserStateDtoExample example);

    /**
     * Description: selectByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<UserStateDto> List<UserStateDto><br>
     */
    List<UserStateDto> selectByExample(UserStateDtoExample example);
}