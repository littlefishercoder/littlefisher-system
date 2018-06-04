package com.littlefisher.core.datasource.interceptor;

import com.littlefisher.core.datasource.interceptor.cfg.TransactionPropagation;

/**
 * Description:
 *
 * Created on 2017年2月10日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class CommandConfig {

    /**
     * 该CommandConfig是否可被多次使用
     */
    private boolean contextReusePossible;

    /**
     * propagation 事务类型
     */
    private TransactionPropagation propagation;

    /**
     * 构造函数
     */
    public CommandConfig() {
        this.contextReusePossible = true;
        this.propagation = TransactionPropagation.REQUIRED;
    }

    /**
     * 构造函数
     * 
     * @param contextReusePossible 是否可被多次使用
     */
    public CommandConfig(boolean contextReusePossible) {
        this.contextReusePossible = contextReusePossible;
        this.propagation = TransactionPropagation.REQUIRED;
    }

    /**
     * 构造函数
     * 
     * @param commandConfig 配置
     */
    protected CommandConfig(CommandConfig commandConfig) {
        this.contextReusePossible = commandConfig.contextReusePossible;
        this.propagation = commandConfig.propagation;
    }

    /**
     * 配置是否可以多次使用
     * 
     * @param contextReusePossible 是否可被多次使用
     * @return CommandConfig
     */
    public CommandConfig setContextReusePossible(boolean contextReusePossible) {
        CommandConfig config = new CommandConfig(this);
        config.contextReusePossible = contextReusePossible;
        return config;
    }

    /**
     * 配置事务级别为Required
     * 
     * @return CommandConfig
     */
    public CommandConfig transactionRequired() {
        CommandConfig config = new CommandConfig(this);
        config.propagation = TransactionPropagation.REQUIRED;
        return config;
    }

    /**
     * 配置事务级别为RequiresNew
     * 
     * @return CommandConfig
     */
    public static CommandConfig transactionRequiresNew() {
        CommandConfig config = new CommandConfig();
        config.contextReusePossible = false;
        config.propagation = TransactionPropagation.REQUIRES_NEW;
        return config;
    }

    /**
     * 配置事务级别为NotSupported
     * 
     * @return CommandConfig
     */
    public static CommandConfig transactionNotSupported() {
        CommandConfig config = new CommandConfig();
        config.contextReusePossible = false;
        config.propagation = TransactionPropagation.NOT_SUPPORTED;
        return config;
    }

    public boolean isContextReusePossible() {
        return contextReusePossible;
    }

    public TransactionPropagation getTransactionPropagation() {
        return propagation;
    }
}
