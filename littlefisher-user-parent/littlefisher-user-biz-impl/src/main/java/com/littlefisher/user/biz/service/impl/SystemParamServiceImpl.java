package com.littlefisher.user.biz.service.impl;

import org.springframework.stereotype.Service;

import com.littlefisher.core.datasource.interceptor.service.ServiceImpl;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.user.biz.cmd.system.AddSystemParamCmd;
import com.littlefisher.user.biz.cmd.system.DeleteSystemParamByIdCmd;
import com.littlefisher.user.biz.cmd.system.DeleteSystemParamByKeyCmd;
import com.littlefisher.user.biz.cmd.system.GetSystemParamByIdCmd;
import com.littlefisher.user.biz.cmd.system.GetSystemParamByKeyCmd;
import com.littlefisher.user.biz.cmd.system.GetSystemParamList4PagerByCondCmd;
import com.littlefisher.user.biz.cmd.system.UpdateSystemParamCmd;
import com.littlefisher.user.biz.model.SystemParamBizDto;
import com.littlefisher.user.biz.request.AddSystemParamRequest;
import com.littlefisher.user.biz.request.GetSystemParamList4PageByCondRequest;
import com.littlefisher.user.biz.request.UpdateSystemParamRequest;
import com.littlefisher.user.biz.service.ISystemParamService;

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
