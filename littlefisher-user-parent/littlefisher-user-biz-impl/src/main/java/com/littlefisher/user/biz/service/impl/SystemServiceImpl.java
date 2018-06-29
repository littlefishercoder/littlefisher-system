package com.littlefisher.user.biz.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.littlefisher.core.datasource.interceptor.service.ServiceImpl;
import com.littlefisher.user.biz.cmd.system.GetResourceCmd;
import com.littlefisher.user.biz.cmd.system.RefreshResourceCmd;
import com.littlefisher.user.biz.service.ISystemService;

/**
 * Description: SystemServiceImpl.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class SystemServiceImpl extends ServiceImpl implements ISystemService {

    @Override
    public void refreshResource() {
        execute(getCommand(RefreshResourceCmd.class));
    }

    @Override
    public Map<Object, Object> getResource(String dialect) {
        return execute(getCommand(GetResourceCmd.class).setDialect(dialect));
    }
}
