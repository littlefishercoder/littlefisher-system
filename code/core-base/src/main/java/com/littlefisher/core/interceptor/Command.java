package com.littlefisher.core.interceptor;

/**
 * Description:
 *
 * Created on 2017年2月10日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface Command<U> {

    /**
     * 执行命令
     *
     * @param commandContext 命令上下文
     * @return 命令返回值
     */
    U execute(CommandContext commandContext);

}
