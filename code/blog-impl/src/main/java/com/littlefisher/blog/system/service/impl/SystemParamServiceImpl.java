package com.littlefisher.blog.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.system.cmd.AddSystemParamCmd;
import com.littlefisher.blog.system.model.SystemParamDto;
import com.littlefisher.blog.system.model.request.GetSystemParamList4PagerByCondRequest;
import com.littlefisher.blog.system.service.ISystemParamService;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * 
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
    public List<SystemParamDto> getSystemParamList4PagerByCond(GetSystemParamList4PagerByCondRequest req)
        throws BaseAppException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SystemParamDto getSystemParamByKey(String paramKey) throws BaseAppException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SystemParamDto getSystemParamById(Long systemParamId) throws BaseAppException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SystemParamDto addSystemParam(SystemParamDto systemParamDto) throws BaseAppException {
        return this.execute(new AddSystemParamCmd(systemParamDto));
    }

    @Override
    public int deleteSystemParamByKey(String paramKey) throws BaseAppException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteSystemParamById(Long systemParamId) throws BaseAppException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public SystemParamDto updateSystemParam(SystemParamDto systemParamDto) throws BaseAppException {
        // TODO Auto-generated method stub
        return null;
    }

}
