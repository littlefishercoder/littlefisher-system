package com.littlefisher.core.interceptor;

import com.littlefisher.core.exception.BaseAppException;

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
     * @param <U> <U>
     * @return Object
     * @throws BaseAppException BaseAppException
     */
    <U> U execute(CommandConfig config, Command<U> command) throws BaseAppException;

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param command command
     * @param <U> <U>
     * @return Object
     * @throws BaseAppException BaseAppException
     */
    <U> U execute(Command<U> command) throws BaseAppException;
}
