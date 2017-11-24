package com.littlefisher.blog.dao.system;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.system.SystemParamDto;
import com.littlefisher.blog.model.system.SystemParamDtoExample;

/**
 * Description: system_param Mapper 接口
 *
 * Created on 2017年11月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface SystemParamDtoMapper extends Mapper<SystemParamDto> {
    /**
     * Description: deleteByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return int int<br>
     */
    int deleteByExample(SystemParamDtoExample example);

    /**
     * Description: selectByExample<br>
     *
     * @author jinyanan <br>
     * @param example example
     * @return List<SystemParamDto> List<SystemParamDto><br>
     */
    List<SystemParamDto> selectByExample(SystemParamDtoExample example);
}