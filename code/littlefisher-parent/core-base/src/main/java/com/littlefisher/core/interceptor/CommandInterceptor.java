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
public interface CommandInterceptor {

    /**
     * 执行命令
     *
     * @param config 命令配置
     * @param command 具体命令
     * @param <U> 具体命令类型
     * @return 该命令执行的返回
     */
    <U> U execute(CommandConfig config, Command<U> command);

    /**
     * 获取下一个命令拦截器
     *
     * @return CommandInterceptor
     */
    CommandInterceptor getNext();

    /**
     * 设置下一个命令拦截器
     *
     * @param next 下一个命令拦截器
     */
    void setNext(CommandInterceptor next);
}
