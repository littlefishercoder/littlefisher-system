package com.littlefisher.core.interceptor.context;

import java.util.ArrayDeque;
import java.util.Deque;

import com.littlefisher.core.engine.SystemEngineConfig;
import com.littlefisher.core.interceptor.CommandContext;

/**
 * Description: 通过栈的方式时间LIFO
 * 可是在jdk中，已经不推荐使用Stack，用ArrayDeque进行替换
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

    public static CommandContext getCommandContext() {
        // 栈 特点是后进先出
        Deque<CommandContext> deque = getStack(commandContextThreadLocal);
        if (deque.isEmpty()) {
            return null;
        }
        return deque.peek();
    }

    public static void setCommandContext(CommandContext commandContext) {
        getStack(commandContextThreadLocal).push(commandContext);
    }

    public static int getCommandContextStackSize() {
        return getStack(commandContextThreadLocal).size();

    }

    public static void removeCommandContext() {
        getStack(commandContextThreadLocal).pop();
    }

    public static void clearCommandContext() {
        commandContextThreadLocal.remove();
    }

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

    protected static <T> Deque<T> getStack(ThreadLocal<Deque<T>> threadLocal) {
        Deque<T> deque = threadLocal.get();
        if (deque == null) {
            deque = new ArrayDeque<>();
            threadLocal.set(deque);
        }
        return deque;
    }

}
