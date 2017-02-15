package com.yc.room1000.core.engine;

import com.yc.room1000.core.interceptor.CommandExecutor;
import com.yc.room1000.core.interceptor.service.ServiceImpl;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月10日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class SystemEngineImpl implements SystemEngine {

    /**
     * systemEngineConfig
     */
    private SystemEngineConfig systemEngineConfig;

    /**
     * name
     */
    private String name;

    /**
     * commandExecutor
     */
    protected CommandExecutor commandExecutor;

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public SystemEngineConfig getSystemEngineConfig() {
        return systemEngineConfig;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param systemEngineConfig <br>
     */
    public void setSystemEngineConfig(SystemEngineConfig systemEngineConfig) {
        this.systemEngineConfig = systemEngineConfig;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param commandExecutor <br>
     */
    public void setCommandExecutor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param name <br>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Description: <br> 
     * @param systemEngineConfig <br>
     */
    public SystemEngineImpl(SystemEngineConfig systemEngineConfig) {
        this.systemEngineConfig = systemEngineConfig;
        this.name = systemEngineConfig.getSystemEngineName();
        this.commandExecutor = systemEngineConfig.getCommandExecutor();
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    @Override
    public void close() {
        

    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param serviceName <br>
     * @return <br>
     */
    @Override
    public ServiceImpl getService(String serviceName) {
        return systemEngineConfig.getService(serviceName);
    }

    @Override
    public void initService(String serviceName, ServiceImpl registerService) {
        systemEngineConfig.initService(serviceName, registerService);
        
    }
}
