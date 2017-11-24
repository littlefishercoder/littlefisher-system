package com.littlefisher.blog.dao.user;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.user.RoleDto;
import com.littlefisher.blog.model.user.RoleDtoExample;

/**
 * Description: role Mapper 接口
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface RoleDtoMapper extends Mapper<RoleDto> {
    /**
     * Description: deleteByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return int int<br>
     */
    int deleteByExample(RoleDtoExample example);

    /**
     * Description: selectByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<RoleDto> List<RoleDto><br>
     */
    List<RoleDto> selectByExample(RoleDtoExample example);
}