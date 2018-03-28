package com.littlefisher.core.biz.framework.service.impl;

import org.springframework.stereotype.Service;

import com.littlefisher.core.biz.framework.cmd.system.AddSystemParamCmd;
import com.littlefisher.core.biz.framework.cmd.system.DeleteSystemParamByIdCmd;
import com.littlefisher.core.biz.framework.cmd.system.DeleteSystemParamByKeyCmd;
import com.littlefisher.core.biz.framework.cmd.system.GetSystemParamByIdCmd;
import com.littlefisher.core.biz.framework.cmd.system.GetSystemParamByKeyCmd;
import com.littlefisher.core.biz.framework.cmd.system.GetSystemParamList4PagerByCondCmd;
import com.littlefisher.core.biz.framework.cmd.system.UpdateSystemParamCmd;
import com.littlefisher.core.biz.framework.model.SystemParamBizDto;
import com.littlefisher.core.biz.framework.request.AddSystemParamRequest;
import com.littlefisher.core.biz.framework.request.UpdateSystemParamRequest;
import com.littlefisher.core.biz.framework.service.ISystemParamService;
import com.littlefisher.core.biz.framework.request.GetSystemParamList4PageByCondRequest;
import com.littlefisher.core.interceptor.service.ServiceImpl;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;

/**
 * Description:
 *
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class SystemParamServiceImpl extends ServiceImpl implements ISystemParamService {

    @Override
    public PageInfo<SystemParamBizDto> getSystemParamList4PageByCond(GetSystemParamList4PageByCondRequest req) {
        return this.execute(getCommand(GetSystemParamList4PagerByCondCmd.class).setReq(req));
    }

    @Override
    public SystemParamBizDto getSystemParamByKey(String paramKey) {
        return this.execute(getCommand(GetSystemParamByKeyCmd.class).setParamKey(paramKey));
    }

    @Override
    public SystemParamBizDto getSystemParamById(Long systemParamId) {
        return this.execute(getCommand(GetSystemParamByIdCmd.class).setSystemParamId(systemParamId));
    }

    @Override
    public SystemParamBizDto addSystemParam(AddSystemParamRequest request) {
        SystemParamBizDto systemParamDto = SystemParamBizDto.Builder.getInstance().addParamKey(request.getParamKey())
            .addParamValue(request.getParamValue()).addDefaultValue(request.getDefaultValue())
            .addParamDesc(request.getParamDesc()).build();
        return this.execute(getCommand(AddSystemParamCmd.class).setSystemParamDto(systemParamDto));
    }

    @Override
    public int deleteSystemParamByKey(String paramKey) {
        return this.execute(getCommand(DeleteSystemParamByKeyCmd.class).setParamKey(paramKey));
    }

    @Override
    public int deleteSystemParamById(Long systemParamId) {
        return this.execute(getCommand(DeleteSystemParamByIdCmd.class).setSystemParamId(systemParamId));
    }

    @Override
    public SystemParamBizDto updateSystemParam(UpdateSystemParamRequest request) {
        SystemParamBizDto systemParamDto = this.getSystemParamById(request.getId());
        systemParamDto.setParamValue(request.getParamValue());
        systemParamDto.setDefaultValue(request.getDefaultValue());
        systemParamDto.setParamDesc(request.getParamDesc());

        return this.execute(getCommand(UpdateSystemParamCmd.class).setSystemParamDto(systemParamDto));
    }

}
