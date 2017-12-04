package com.littlefisher.blog.dao.system;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.blog.model.system.SystemParamDto;
import com.littlefisher.blog.request.system.GetSystemParamList4PagerByCondRequest;

/**
 * Description: system_param Mapper 接口
 *
 * Created on 2017年11月24日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface SystemParamDtoMapper extends Mapper<SystemParamDto> {

    /**
     * 根据条件查询
     *
     * @param req req
     * @return List<SystemParamDto>
     */
    List<SystemParamDto> selectByCond(GetSystemParamList4PagerByCondRequest req);
}