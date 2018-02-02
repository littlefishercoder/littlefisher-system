package com.littlefisher.core.biz.framework.service.impl;

import org.springframework.stereotype.Service;

import com.littlefisher.core.biz.framework.cmd.system.RefreshResourceCmd;
import com.littlefisher.core.biz.framework.service.ISystemService;
import com.littlefisher.core.interceptor.service.ServiceImpl;

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
}
