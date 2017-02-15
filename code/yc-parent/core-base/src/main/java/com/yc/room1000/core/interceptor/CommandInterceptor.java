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
public interface CommandInterceptor {

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param config <br>
     * @param command <br>
     * @return <br>
     * @throws BaseAppException <br>
     */
    Object execute(CommandConfig config, Command command) throws BaseAppException;
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    CommandInterceptor getNext();

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param next <br>
     */
    void setNext(CommandInterceptor next);
}
