package com.yc.room1000.core.engine;

import java.util.Map;

import org.springframework.beans.factory.FactoryBean;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.service.ServiceImpl;

/**
 * 
 * <Description> <br> 
 *  
 * @author zeng.ligeng<br>
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
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return SystemEngine
     * @throws BaseAppException <br>
     */
    public SystemEngine getObject() throws BaseAppException {
        systemEngine = (SystemEngineImpl) systemEngineConfig.buildSystemEngine();
        
        systemEngineConfig.initServices(registerServices);
        
        return systemEngine;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public Map<String, ServiceImpl> getRegisterServices() {
        return registerServices;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param registerServices <br>
     */
    public void setRegisterServices(Map<String, ServiceImpl> registerServices) {
        this.registerServices = registerServices;
    }
}
