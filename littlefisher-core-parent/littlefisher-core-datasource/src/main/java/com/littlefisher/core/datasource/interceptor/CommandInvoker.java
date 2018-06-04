package com.littlefisher.core.datasource.interceptor;

import com.littlefisher.core.datasource.interceptor.context.Context;

/**
 * Description:
 *
 * Created on 2017年2月10日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class CommandInvoker extends AbstractCommandInterceptor {

    @Override
    public <U> U execute(CommandConfig config, Command<U> command) {
        // Context.getCommandContext()是为了能让业务的command中，调用工具方法
        // 例如commandContext.getSystemEngineConfig().getService()获取其他Service
        // 例如commandContext.getDbSqlSession().getMapper()获取Mapper
        return command.execute(Context.getCommandContext());
    }

    @Override
    public CommandInterceptor getNext() {
        return null;
    }

    @Override
    public void setNext(CommandInterceptor next) {
        throw new UnsupportedOperationException(
                "CommandInvoker must be the last interceptor in the chain");
    }
}
