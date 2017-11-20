package com.littlefisher.core.engine;

import java.util.Map;

import org.springframework.beans.factory.FactoryBean;

import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class SystemEngineFactoryBean implements FactoryBean<SystemEngine> {

    /**
     * SystemEngineConfig 配置
     */
    protected SystemEngineConfig systemEngineConfig;

    /**
     * SystemEngine
     */
    protected SystemEngine systemEngine;

    /**
     * registerServices 初始化需要的Command
     */
    protected Map<String, ServiceImpl> registerServices;

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

    public void setSystemEngineConfig(SystemEngineConfig systemEngineConfig) {
        this.systemEngineConfig = systemEngineConfig;
    }

    public SystemEngineConfig getSystemEngineConfig() {

        return systemEngineConfig;
    }
}
