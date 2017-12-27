package com.littlefisher.core.biz.framework.dao.ext;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.littlefisher.core.biz.framework.dao.SystemParamDtoMapper;
import com.littlefisher.core.biz.framework.model.SystemParamDto;
import com.littlefisher.core.biz.framework.request.GetSystemParamList4PagerByCondRequest;

/**
 * Description: SystemParamDtoExtMapper.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface SystemParamDtoExtMapper extends SystemParamDtoMapper, Mapper<SystemParamDto> {

    /**
     * 根据条件查询
     *
     * @param req req
     * @return List<SystemParamDto>
     */
    List<SystemParamDto> selectByCond(GetSystemParamList4PagerByCondRequest req);
}
