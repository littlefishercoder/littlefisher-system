package com.littlefisher.web.dal.integration.user.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.user.biz.service.ISystemService;
import com.littlefisher.web.dal.integration.user.ISystemIntegration;

/**
 * Description: SystemIntegrationImpl.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class SystemIntegrationImpl implements ISystemIntegration {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ISystemService systemService;

    @Override
    public void refreshResource() {
        systemService.refreshResource();
    }

    @Override
    public Map<Object, Object> getResource(String dialect) {
        return systemService.getResource(dialect);
    }
}
