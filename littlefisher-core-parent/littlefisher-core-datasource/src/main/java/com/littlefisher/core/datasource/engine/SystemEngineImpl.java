package com.littlefisher.core.datasource.engine;

import com.littlefisher.core.datasource.interceptor.CommandExecutor;
import com.littlefisher.core.datasource.interceptor.service.ServiceImpl;

/**
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

    public SystemEngineConfig getSystemEngineConfig() {
        return systemEngineConfig;
    }

    public void setSystemEngineConfig(SystemEngineConfig systemEngineConfig) {
        this.systemEngineConfig = systemEngineConfig;
    }

    @Override
    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }

    public void setCommandExecutor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 构造函数
     * 
     * @param systemEngineConfig 配置
     */
    public SystemEngineImpl(SystemEngineConfig systemEngineConfig) {
        this.systemEngineConfig = systemEngineConfig;
        this.name = systemEngineConfig.getSystemEngineName();
        this.commandExecutor = systemEngineConfig.getCommandExecutor();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void close() {

    }

    @Override
    public ServiceImpl getService(String serviceName) {
        return systemEngineConfig.getService(serviceName);
    }

    @Override
    public void initService(String serviceName, ServiceImpl registerService) {
        systemEngineConfig.initService(serviceName, registerService);

    }
}
