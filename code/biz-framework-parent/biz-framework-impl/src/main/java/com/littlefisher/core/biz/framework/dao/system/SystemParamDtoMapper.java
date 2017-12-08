package com.littlefisher.core.biz.framework.dao.system;

import com.littlefisher.core.biz.framework.model.system.SystemParamDto;
import com.littlefisher.core.biz.framework.request.system.GetSystemParamList4PagerByCondRequest;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Description: bfm_system_param Mapper 接口
 *
 * Created on 2017年12月08日
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