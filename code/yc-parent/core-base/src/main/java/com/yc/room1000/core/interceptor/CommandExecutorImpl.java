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
public class CommandExecutorImpl implements CommandExecutor {

    /**
     * defaultConfig
     */
    private final CommandConfig defaultConfig;

    /**
     * first
     */
    private final CommandInterceptor first;
    
    /**
     * CommandExecutorImpl
     * @param defaultConfig <br>
     * @param first <br>
     */
    public CommandExecutorImpl(CommandConfig defaultConfig, CommandInterceptor first) {
        this.defaultConfig = defaultConfig;
        this.first = first;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public CommandInterceptor getFirst() {
        return first;
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
    public CommandConfig getDefaultConfig() {
        return defaultConfig;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param command <br>
     * @param <U> <U>
     * @return <br>
     * @throws BaseAppException <br>
     */
    @Override
    public <U> U execute(Command<U> command) throws BaseAppException {
        return execute(defaultConfig, command);
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param config <br>
     * @param command <br>
     * @param <U> <U>
     * @return <br>
     * @throws BaseAppException <br>
     */
    @Override
    public <U> U execute(CommandConfig config, Command<U> command) throws BaseAppException {
        return first.execute(config, command);
    }
}
