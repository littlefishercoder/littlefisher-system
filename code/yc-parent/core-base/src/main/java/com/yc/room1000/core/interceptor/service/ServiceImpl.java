package com.yc.room1000.core.interceptor.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.room1000.core.engine.SystemEngine;
import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.Command;
import com.yc.room1000.core.interceptor.CommandConfig;
import com.yc.room1000.core.interceptor.CommandExecutor;

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
public class ServiceImpl implements InitializingBean {

    /**
     * commandExecutor
     */
    protected CommandExecutor commandExecutor;

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    @SuppressWarnings({
        "unchecked", "rawtypes"
    })
    private void init() { 
        Class mClass = this.getClass();
        Service service = (Service) mClass.getAnnotation(Service.class);
        String value = service.value();
        initService(value, this);
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
     * systemEngine
     */
    @Autowired
    private SystemEngine systemEngine;
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param serviceName <br>
     * @param serviceInstance <br>
     */
    public void initService(String serviceName, ServiceImpl serviceInstance) {
        systemEngine.initService(serviceName, serviceInstance);
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param command <br>
     * @param <U> <U>
     * @return  <br>
     * @throws BaseAppException <br>
     */
    protected <U> U  execute(Command<U> command) throws BaseAppException {
        return commandExecutor.execute(command);
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param config <br>
     * CommandConfig.transactionNotSupported() 不带事务
     * CommandConfig.transactionRequiresNew()  新起事务
     * 缺省是 TransactionPropagation.REQUIRED
     * @param command <br>
     * @param <U> <U>
     * @return <br>
     * @throws BaseAppException <br>
     */
    protected <U> U execute(CommandConfig config, Command<U> command) throws BaseAppException {
        
        return commandExecutor.execute(config, command);
    }

    @Override
    public void afterPropertiesSet() {
        init();
    }

}
