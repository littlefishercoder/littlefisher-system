package com.yc.room1000.core.interceptor;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.interceptor.context.Context;

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
public class CommandInvoker extends AbstractCommandInterceptor {

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
    @Override
    public Object execute(CommandConfig config, Command command) throws BaseAppException {
        return command.execute(Context.getCommandContext());
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
    public CommandInterceptor getNext() {
        return null;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param next <br>
     */
    @Override
    public void setNext(CommandInterceptor next) {
        throw new UnsupportedOperationException("CommandInvoker must be the last interceptor in the chain");
    }
}
