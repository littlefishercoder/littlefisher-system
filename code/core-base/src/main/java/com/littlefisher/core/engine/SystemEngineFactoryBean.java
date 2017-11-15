package com.littlefisher.core.engine;

import java.util.Map;

import org.springframework.beans.factory.FactoryBean;

import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * <Description> <br>
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class SystemEngineFactoryBean implements FactoryBean<SystemEngine> {

    /**
     * SystemEngineConfig
     */
    protected SystemEngineConfig systemEngineConfig;

    /**
     * SystemEngine
     */
    protected SystemEngine systemEngine;

    /**
     * registerServices
     */
    protected Map<String, ServiceImpl> registerServices;

    public SystemEngineConfig getSystemEngineConfig() {
        return systemEngineConfig;
    }

    public void setSystemEngineConfig(SystemEngineConfig systemEngineConfig) {
        this.systemEngineConfig = systemEngineConfig;
    }

    @Override
    public Class<SystemEngine> getObjectType() {
        return SystemEngine.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * Description: 通过实现FactoryBean<SystemEngine>接口，实现方法启动时的调用<br>
     *
     * @return SystemEngine
     */
    @Override
    public SystemEngine getObject() {
        systemEngine = systemEngineConfig.buildSystemEngine();

        systemEngineConfig.initServices(registerServices);

        return systemEngine;
    }

    public Map<String, ServiceImpl> getRegisterServices() {
        return registerServices;
    }

    public void setRegisterServices(Map<String, ServiceImpl> registerServices) {
        this.registerServices = registerServices;
    }
}
