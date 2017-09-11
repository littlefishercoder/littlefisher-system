package com.littlefisher.core.engine;

import java.util.Map;

import org.springframework.beans.factory.FactoryBean;

import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * 
 * <Description> <br> 
 *  
 * @author jinyanan<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年2月25日 <br>
 * @since V9<br>
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

    public Class<SystemEngine> getObjectType() {
        return SystemEngine.class;
    }

    public boolean isSingleton() {
        return true;
    }
    
    /**
     * 
     * Description: 通过实现FactoryBean<SystemEngine>接口，实现方法启动时的调用<br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @return SystemEngine
     * @throws BaseAppException <br>
     */
    public SystemEngine getObject() throws BaseAppException {
        systemEngine = (SystemEngineImpl) systemEngineConfig.buildSystemEngine();
        
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
