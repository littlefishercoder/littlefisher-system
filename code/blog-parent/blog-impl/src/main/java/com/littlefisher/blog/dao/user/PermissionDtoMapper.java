package com.littlefisher.blog.dao.user;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.user.PermissionDto;
import com.littlefisher.blog.model.user.PermissionDtoExample;

/**
 * Description: permission Mapper 接口
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface PermissionDtoMapper extends Mapper<PermissionDto> {
    /**
     * Description: deleteByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return int int<br>
     */
    int deleteByExample(PermissionDtoExample example);

    /**
     * Description: selectByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<PermissionDto> List<PermissionDto><br>
     */
    List<PermissionDto> selectByExample(PermissionDtoExample example);
}