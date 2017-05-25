package com.littlefisher.blog.user.dao;

import java.util.List;

import com.littlefisher.blog.user.model.UserDto;
import com.littlefisher.blog.user.model.request.GetUserList4PagerByCondRequest;

import tk.mybatis.mapper.common.Mapper;


/**
 *
 * Description: user Mapper 接口
 *
 * Created on 2017年05月22日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface UserDtoMapper extends Mapper<UserDto> {

    /**
     * 
     * Description: 根据条件查询用户列表
     * 
     * @author jinyanan
     *
     * @param req req
     * @return List<UserDto>
     */
    List<UserDto> selectByCond(GetUserList4PagerByCondRequest req);
}