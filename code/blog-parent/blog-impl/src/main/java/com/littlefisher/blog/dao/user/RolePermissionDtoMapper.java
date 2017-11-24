package com.littlefisher.blog.dao.user;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.user.RolePermissionDto;
import com.littlefisher.blog.model.user.RolePermissionDtoExample;

/**
 * Description: role_permission Mapper 接口
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface RolePermissionDtoMapper extends Mapper<RolePermissionDto> {
    /**
     * Description: deleteByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return int int<br>
     */
    int deleteByExample(RolePermissionDtoExample example);

    /**
     * Description: selectByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<RolePermissionDto> List<RolePermissionDto><br>
     */
    List<RolePermissionDto> selectByExample(RolePermissionDtoExample example);
}