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
     * contextReusePossible 是否可被多次使用
     */
    private boolean contextReusePossible;

    /**
     * propagation 事务类型
     */
    private TransactionPropagation propagation;

    /**
     * CommandConfig
     */
    public CommandConfig() {
        this.contextReusePossible = true;
        this.propagation = TransactionPropagation.REQUIRED;
    }

    public CommandConfig(boolean contextReusePossible) {
        this.contextReusePossible = contextReusePossible;
        this.propagation = TransactionPropagation.REQUIRED;
    }

    protected CommandConfig(CommandConfig commandConfig) {
        this.contextReusePossible = commandConfig.contextReusePossible;
        this.propagation = commandConfig.propagation;
    }

    public CommandConfig setContextReusePossible(boolean contextReusePossible) {
        CommandConfig config = new CommandConfig(this);
        config.contextReusePossible = contextReusePossible;
        return config;
    }

    public CommandConfig transactionRequired() {
        CommandConfig config = new CommandConfig(this);
        config.propagation = TransactionPropagation.REQUIRED;
        return config;
    }

    public static CommandConfig transactionRequiresNew() {
        CommandConfig config = new CommandConfig();
        config.contextReusePossible = false;
        config.propagation = TransactionPropagation.REQUIRES_NEW;
        return config;
    }

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
