package com.littlefisher.web.dal.integration.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.user.biz.model.SystemParamBizDto;
import com.littlefisher.user.biz.request.AddSystemParamRequest;
import com.littlefisher.user.biz.request.GetSystemParamList4PageByCondRequest;
import com.littlefisher.user.biz.request.UpdateSystemParamRequest;
import com.littlefisher.user.biz.service.ISystemParamService;
import com.littlefisher.web.dal.integration.user.ISystemParamIntegration;

/**
 * Description: SystemParamIntegrationImpl.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class SystemParamIntegrationImpl implements ISystemParamIntegration {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ISystemParamService systemParamService;

    @Override
    public PageInfo<SystemParamBizDto> getSystemParamList4PageByCond(
            GetSystemParamList4PageByCondRequest req) {
        return systemParamService.getSystemParamList4PageByCond(req);
    }

    @Override
    public SystemParamBizDto getSystemParamByKey(String paramKey) {
        return systemParamService.getSystemParamByKey(paramKey);
    }

    @Override
    public SystemParamBizDto getSystemParamById(Long systemParamId) {
        return systemParamService.getSystemParamById(systemParamId);
    }

    @Override
    public SystemParamBizDto addSystemParam(AddSystemParamRequest request) {
        return systemParamService.addSystemParam(request);
    }

    @Override
    public int deleteSystemParamByKey(String paramKey) {
        return systemParamService.deleteSystemParamByKey(paramKey);
    }

    @Override
    public int deleteSystemParamById(Long systemParamId) {
        return systemParamService.deleteSystemParamById(systemParamId);
    }

    @Override
    public SystemParamBizDto updateSystemParam(UpdateSystemParamRequest request) {
        return systemParamService.updateSystemParam(request);
    }
}
