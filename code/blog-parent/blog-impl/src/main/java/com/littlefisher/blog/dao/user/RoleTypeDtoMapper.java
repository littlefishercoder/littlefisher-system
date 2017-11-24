package com.littlefisher.blog.dao.user;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.user.RoleTypeDto;
import com.littlefisher.blog.model.user.RoleTypeDtoExample;

/**
 * Description: role_type Mapper 接口
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface RoleTypeDtoMapper extends Mapper<RoleTypeDto> {
    /**
     * Description: deleteByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return int int<br>
     */
    int deleteByExample(RoleTypeDtoExample example);

    /**
     * Description: selectByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<RoleTypeDto> List<RoleTypeDto><br>
     */
    List<RoleTypeDto> selectByExample(RoleTypeDtoExample example);
}