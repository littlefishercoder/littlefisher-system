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

    String getName();
    
    void close();
    
    CommandExecutor getCommandExecutor();
    
    ServiceImpl getService(String serviceName);
    
    void initService(String serviceName, ServiceImpl registerService);
}
