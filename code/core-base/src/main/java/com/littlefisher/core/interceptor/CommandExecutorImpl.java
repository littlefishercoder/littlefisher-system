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
public class CommandExecutorImpl implements CommandExecutor {

    /**
     * defaultConfig
     */
    private final CommandConfig defaultConfig;

    /**
     * first
     */
    private final CommandInterceptor first;
    
    public CommandExecutorImpl(CommandConfig defaultConfig, CommandInterceptor first) {
        this.defaultConfig = defaultConfig;
        this.first = first;
    }

    public CommandInterceptor getFirst() {
        return first;
    }

    @Override
    public CommandConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public <U> U execute(Command<U> command) throws BaseAppException {
        return execute(defaultConfig, command);
    }

    @Override
    public <U> U execute(CommandConfig config, Command<U> command) throws BaseAppException {
        return first.execute(config, command);
    }
}
