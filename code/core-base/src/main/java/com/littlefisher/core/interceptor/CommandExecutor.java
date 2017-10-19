package com.littlefisher.core.interceptor;

import com.littlefisher.core.exception.BaseAppException;

/**
 * Description:
 *
 * Created on 2017年2月10日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface CommandExecutor {

    /**
     * 获取默认配置
     * @return CommandConfig
     */
    CommandConfig getDefaultConfig();

    /**
     * 执行命令
     * @param config 命令配置
     * @param command 具体命令
     * @param <U> 命令执行的返回参数
     * @return 具体返回参数
     * @throws BaseAppException </br>
     */
    <U> U execute(CommandConfig config, Command<U> command) throws BaseAppException;

    /**
     * 执行命令
     * @param command 具体命令
     * @param <U> 命令执行的返回参数
     * @return 具体返回参数
     * @throws BaseAppException </br>
     */
    <U> U execute(Command<U> command) throws BaseAppException;
}
