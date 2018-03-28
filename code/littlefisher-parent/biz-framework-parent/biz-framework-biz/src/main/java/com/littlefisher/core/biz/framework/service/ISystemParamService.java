package com.littlefisher.core.biz.framework.service;

import com.littlefisher.core.biz.framework.model.SystemParamBizDto;
import com.littlefisher.core.biz.framework.request.AddSystemParamRequest;
import com.littlefisher.core.biz.framework.request.GetSystemParamList4PageByCondRequest;
import com.littlefisher.core.biz.framework.request.UpdateSystemParamRequest;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;

/**
 * Description: 系统信息参数
 *
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ISystemParamService {

    /**
     * Description: 根据条件查询
     *
     * @param req req
     * @return List<SystemParamDto>
     */
    PageInfo<SystemParamBizDto> getSystemParamList4PageByCond(GetSystemParamList4PageByCondRequest req);

    /**
     * Description: 根据key值查询系统参数
     *
     * @param paramKey paramKey
     * @return SystemParamDto
     */
    SystemParamBizDto getSystemParamByKey(String paramKey);

    /**
     * Description: 根据id查询系统参数
     *
     * @param systemParamId systemParamId
     * @return SystemParamDto
     */
    SystemParamBizDto getSystemParamById(Long systemParamId);

    /**
     * Description: 新增系统参数
     *
     * @param request systemParamDto
     * @return SystemParamDto
     */
    SystemParamBizDto addSystemParam(AddSystemParamRequest request);

    /**
     * Description: 根据key删除系统参数
     *
     * @param paramKey paramKey
     * @return int
     */
    int deleteSystemParamByKey(String paramKey);

    /**
     * Description: 根据主键删除系统参数
     *
     * @param systemParamId systemParamId
     * @return int
     */
    int deleteSystemParamById(Long systemParamId);

    /**
     * Description: 修改系统参数
     *
     * @param request systemParamDto
     * @return SystemParamDto
     */
    SystemParamBizDto updateSystemParam(UpdateSystemParamRequest request);
}
