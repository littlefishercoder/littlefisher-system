package com.littlefisher.user.service.impl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.littlefisher.core.datasource.interceptor.service.ServiceImpl;
import com.littlefisher.user.cmd.system.GetResourceCmd;
import com.littlefisher.user.cmd.system.RefreshResourceCmd;
import com.littlefisher.user.service.ISystemService;

/**
 * Description: SystemServiceImpl.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Component
@Service(interfaceClass = ISystemService.class)
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
