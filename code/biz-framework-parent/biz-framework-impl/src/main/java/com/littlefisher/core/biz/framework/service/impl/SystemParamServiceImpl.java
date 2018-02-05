package com.littlefisher.core.biz.framework.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.core.biz.framework.cmd.system.AddSystemParamCmd;
import com.littlefisher.core.biz.framework.cmd.system.DeleteSystemParamByIdCmd;
import com.littlefisher.core.biz.framework.cmd.system.DeleteSystemParamByKeyCmd;
import com.littlefisher.core.biz.framework.cmd.system.GetSystemParamByIdCmd;
import com.littlefisher.core.biz.framework.cmd.system.GetSystemParamByKeyCmd;
import com.littlefisher.core.biz.framework.cmd.system.GetSystemParamList4PagerByCondCmd;
import com.littlefisher.core.biz.framework.cmd.system.UpdateSystemParamCmd;
import com.littlefisher.core.biz.framework.request.AddSystemParamRequest;
import com.littlefisher.core.biz.framework.request.UpdateSystemParamRequest;
import com.littlefisher.core.biz.framework.service.ISystemParamService;
import com.littlefisher.core.biz.framework.model.SystemParamDto;
import com.littlefisher.core.biz.framework.request.GetSystemParamList4PagerByCondRequest;
import com.littlefisher.core.interceptor.service.ServiceImpl;

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
    public List<SystemParamDto> getSystemParamList4PagerByCond(GetSystemParamList4PagerByCondRequest req) {
        return this.execute(getCommand(GetSystemParamList4PagerByCondCmd.class).setReq(req));
    }

    @Override
    public SystemParamDto getSystemParamByKey(String paramKey) {
        return this.execute(getCommand(GetSystemParamByKeyCmd.class).setParamKey(paramKey));
    }

    @Override
    public SystemParamDto getSystemParamById(Long systemParamId) {
        return this.execute(getCommand(GetSystemParamByIdCmd.class).setSystemParamId(systemParamId));
    }

    @Override
    public SystemParamDto addSystemParam(AddSystemParamRequest request) {
        SystemParamDto systemParamDto = new SystemParamDto();
        systemParamDto.setParamKey(request.getParamKey());
        systemParamDto.setParamValue(request.getParamValue());
        systemParamDto.setDefaultValue(request.getDefaultValue());
        systemParamDto.setParamDesc(request.getParamDesc());
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
    public SystemParamDto updateSystemParam(UpdateSystemParamRequest request) {
        SystemParamDto systemParamDto = this.getSystemParamById(request.getId());
        systemParamDto.setParamValue(request.getParamValue());
        systemParamDto.setDefaultValue(request.getDefaultValue());
        systemParamDto.setParamDesc(request.getParamDesc());

        return this.execute(getCommand(UpdateSystemParamCmd.class).setSystemParamDto(systemParamDto));
    }

}
