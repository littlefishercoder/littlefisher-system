package com.littlefisher.core.engine;

import com.littlefisher.core.interceptor.CommandExecutor;
import com.littlefisher.core.interceptor.service.ServiceImpl;

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
public interface SystemEngine {

    /**
     * 获取引擎名
     * @return String
     */
    String getName();

    /**
     * 关闭
     */
    void close();

    /**
     * 获取命令执行器
     * @return CommandExecutor
     */
    CommandExecutor getCommandExecutor();

    /**
     * 根据serviceName获取具体实现类
     * @param serviceName service的bean名称
     * @return ServiceImpl
     */
    ServiceImpl getService(String serviceName);

    /**
     * 初始化service
     * @param serviceName service的bean名称
     * @param registerService 具体的ServiceImpl
     */
    void initService(String serviceName, ServiceImpl registerService);
}
