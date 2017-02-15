package com.yc.room1000.core.interceptor;

import com.yc.room1000.core.exception.BaseAppException;

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
public interface CommandExecutor {
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return CommandConfig
     */
    CommandConfig getDefaultConfig();
       
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param config config
     * @param command command
     * @return Object
     * @throws BaseAppException BaseAppException
     */
    Object execute(CommandConfig config, Command command) throws BaseAppException;

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param command command
     * @return Object
     * @throws BaseAppException BaseAppException
     */
    Object execute(Command command) throws BaseAppException;
}
