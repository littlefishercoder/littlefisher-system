package com.littlefisher.core.biz.framework.service.impl;

import com.littlefisher.core.biz.framework.cmd.system.GetResourceCmd;
import org.springframework.stereotype.Service;

import com.littlefisher.core.biz.framework.cmd.system.RefreshResourceCmd;
import com.littlefisher.core.biz.framework.service.ISystemService;
import com.littlefisher.core.interceptor.service.ServiceImpl;

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
