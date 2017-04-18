package com.littlefisher.core.interceptor;

import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.context.Context;

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
     * @author jinyanan<br>
     * @taskId <br>
     * @param config <br>
     * @param command <br>
     * @param <U> <U>
     * @return <br>
     * @throws BaseAppException <br>
     */
    @Override
    public <U> U execute(CommandConfig config, Command<U> command) throws BaseAppException {
        // Context.getCommandContext()是为了能让业务的command中，调用工具方法
        // 例如commandContext.getSystemEngineConfig().getService()获取其他Service
        // 例如commandContext.getDbSqlSession().getMapper()获取Mapper
        return command.execute(Context.getCommandContext());
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
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
     * @author jinyanan<br>
     * @taskId <br>
     * @param next <br>
     */
    @Override
    public void setNext(CommandInterceptor next) {
        throw new UnsupportedOperationException("CommandInvoker must be the last interceptor in the chain");
    }
}
