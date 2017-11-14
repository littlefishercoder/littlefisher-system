package com.littlefisher.blog.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.system.cmd.AddSystemParamCmd;
import com.littlefisher.blog.system.cmd.DeleteSystemParamByIdCmd;
import com.littlefisher.blog.system.cmd.DeleteSystemParamByKeyCmd;
import com.littlefisher.blog.system.cmd.GetSystemParamByIdCmd;
import com.littlefisher.blog.system.cmd.GetSystemParamByKeyCmd;
import com.littlefisher.blog.system.cmd.GetSystemParamList4PagerByCondCmd;
import com.littlefisher.blog.system.cmd.UpdateSystemParamCmd;
import com.littlefisher.blog.system.model.SystemParamDto;
import com.littlefisher.blog.system.model.request.GetSystemParamList4PagerByCondRequest;
import com.littlefisher.blog.system.service.ISystemParamService;
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
    public List<SystemParamDto> getSystemParamList4PagerByCond(
            GetSystemParamList4PagerByCondRequest req) {
        return this.execute(new GetSystemParamList4PagerByCondCmd(req));
    }

    @Override
    public SystemParamDto getSystemParamByKey(String paramKey) {
        return this.execute(new GetSystemParamByKeyCmd(paramKey));
    }

    @Override
    public SystemParamDto getSystemParamById(Long systemParamId) {
        return this.execute(new GetSystemParamByIdCmd(systemParamId));
    }

    @Override
    public SystemParamDto addSystemParam(SystemParamDto systemParamDto) {
        return this.execute(new AddSystemParamCmd(systemParamDto));
    }

    @Override
    public int deleteSystemParamByKey(String paramKey) {
        return this.execute(new DeleteSystemParamByKeyCmd(paramKey));
    }

    @Override
    public int deleteSystemParamById(Long systemParamId) {
        return this.execute(new DeleteSystemParamByIdCmd(systemParamId));
    }

    @Override
    public SystemParamDto updateSystemParam(SystemParamDto systemParamDto) {
        return this.execute(new UpdateSystemParamCmd(systemParamDto));
    }

}
