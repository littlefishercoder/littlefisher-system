package com.littlefisher.core.datasource.interceptor.context;

import java.util.ArrayDeque;
import java.util.Deque;

import com.littlefisher.core.datasource.engine.SystemEngineConfig;
import com.littlefisher.core.datasource.interceptor.CommandContext;

/**
 * Description: 通过栈的方式时间LIFO 可是在jdk中，已经不推荐使用Stack，用ArrayDeque进行替换
 *
 * Created on 2017年2月10日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class Context {

    /**
     * commandContextThreadLocal 分线程存储命令上下文
     */
    protected static ThreadLocal<Deque<CommandContext>> commandContextThreadLocal = new ThreadLocal<>();

    /**
     * systemEngineConfigStackThreadLocal 分线程存储引擎配置
     */
    protected static ThreadLocal<Deque<SystemEngineConfig>> systemEngineConfigStackThreadLocal = new ThreadLocal<>();

    /**
     * 获取CommandContext
     * 
     * @return CommandContext
     */
    public static CommandContext getCommandContext() {
        // 栈 特点是后进先出
        Deque<CommandContext> deque = getStack(commandContextThreadLocal);
        if (deque.isEmpty()) {
            return null;
        }
        return deque.peek();
    }

    /**
     * 设置CommandContext
     * 
     * @param commandContext CommandContext
     */
    public static void setCommandContext(CommandContext commandContext) {
        getStack(commandContextThreadLocal).push(commandContext);
    }

    /**
     * 获取CommandContext数量
     * 
     * @return 数量
     */
    public static int getCommandContextStackSize() {
        return getStack(commandContextThreadLocal).size();

    }

    public static void removeCommandContext() {
        getStack(commandContextThreadLocal).pop();
    }

    public static void clearCommandContext() {
        commandContextThreadLocal.remove();
    }

    /**
     * 获取系统配置
     * 
     * @return SystemEngineConfig
     */
    public static SystemEngineConfig getSystemEngineConfig() {
        Deque<SystemEngineConfig> deque = getStack(systemEngineConfigStackThreadLocal);
        if (deque.isEmpty()) {
            return null;
        }
        return deque.peek();

    }

    public static void setSystemEngineConfig(SystemEngineConfig systemEngineConfig) {
        getStack(systemEngineConfigStackThreadLocal).push(systemEngineConfig);
    }

    public static void removeSystemEngineConfig() {
        getStack(systemEngineConfigStackThreadLocal).pop();
    }

    public static void clearSystemEngineConfig() {
        systemEngineConfigStackThreadLocal.remove();
    }

    /**
     * 获取队列
     * 
     * @param threadLocal 线程上下文
     * @param <T> 泛型
     * @return 队列
     */
    protected static <T> Deque<T> getStack(ThreadLocal<Deque<T>> threadLocal) {
        Deque<T> deque = threadLocal.get();
        if (deque == null) {
            deque = new ArrayDeque<>();
            threadLocal.set(deque);
        }
        return deque;
    }

}
