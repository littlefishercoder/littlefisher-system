package com.littlefisher.web.dal.integration.user;

import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.user.model.SystemParamBizDto;
import com.littlefisher.user.request.AddSystemParamRequest;
import com.littlefisher.user.request.GetSystemParamList4PageByCondRequest;
import com.littlefisher.user.request.UpdateSystemParamRequest;

/**
 * ISystemParamIntegration.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ISystemParamIntegration {

    /**
     * 根据条件查询
     *
     * @param req req
     * @return 系统参数列表
     */
    PageInfo<SystemParamBizDto> getSystemParamList4PageByCond(GetSystemParamList4PageByCondRequest req);

    /**
     * 根据key值查询系统参数
     *
     * @param paramKey paramKey
     * @return SystemParamDto
     */
    SystemParamBizDto getSystemParamByKey(String paramKey);

    /**
     * 根据id查询系统参数
     *
     * @param systemParamId systemParamId
     * @return SystemParamDto
     */
    SystemParamBizDto getSystemParamById(Long systemParamId);

    /**
     * 新增系统参数
     *
     * @param request systemParamDto
     * @return SystemParamDto
     */
    SystemParamBizDto addSystemParam(AddSystemParamRequest request);

    /**
     * 根据key删除系统参数
     *
     * @param paramKey paramKey
     * @return int
     */
    int deleteSystemParamByKey(String paramKey);

    /**
     * 根据主键删除系统参数
     *
     * @param systemParamId systemParamId
     * @return int
     */
    int deleteSystemParamById(Long systemParamId);

    /**
     * 修改系统参数
     *
     * @param request systemParamDto
     * @return SystemParamDto
     */
    SystemParamBizDto updateSystemParam(UpdateSystemParamRequest request);
}
