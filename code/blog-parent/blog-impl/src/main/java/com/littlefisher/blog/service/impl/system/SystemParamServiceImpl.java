package com.littlefisher.blog.service.impl.system;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.system.AddSystemParamCmd;
import com.littlefisher.blog.cmd.system.DeleteSystemParamByIdCmd;
import com.littlefisher.blog.cmd.system.DeleteSystemParamByKeyCmd;
import com.littlefisher.blog.cmd.system.GetSystemParamByIdCmd;
import com.littlefisher.blog.cmd.system.GetSystemParamByKeyCmd;
import com.littlefisher.blog.cmd.system.GetSystemParamList4PagerByCondCmd;
import com.littlefisher.blog.cmd.system.UpdateSystemParamCmd;
import com.littlefisher.blog.intf.system.ISystemParamService;
import com.littlefisher.blog.model.system.SystemParamDto;
import com.littlefisher.blog.request.system.GetSystemParamList4PagerByCondRequest;
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
