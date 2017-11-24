package com.littlefisher.blog.dao.user;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.user.UserRoleDto;
import com.littlefisher.blog.model.user.UserRoleDtoExample;

/**
 * Description: user_role Mapper 接口
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface UserRoleDtoMapper extends Mapper<UserRoleDto> {
    /**
     * Description: deleteByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return int int<br>
     */
    int deleteByExample(UserRoleDtoExample example);

    /**
     * Description: selectByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<UserRoleDto> List<UserRoleDto><br>
     */
    List<UserRoleDto> selectByExample(UserRoleDtoExample example);
}