package com.littlefisher.user.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.littlefisher.core.interceptor.service.ServiceImpl;
import com.littlefisher.user.cmd.system.GetResourceCmd;
import com.littlefisher.user.cmd.system.RefreshResourceCmd;
import com.littlefisher.user.service.ISystemService;

import java.util.Map;

/**
 * Description: SystemServiceImpl.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
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
