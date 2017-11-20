package com.littlefisher.core.interceptor.context;

import java.util.Stack;

import com.littlefisher.core.engine.SystemEngineConfig;
import com.littlefisher.core.interceptor.CommandContext;

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
public class Context {

    /**
     * commandContextThreadLocal 分线程存储命令上下文
     */
    protected static ThreadLocal<Stack<CommandContext>> commandContextThreadLocal = new ThreadLocal<>();
    
    /**
     * systemEngineConfigStackThreadLocal 分线程存储引擎配置
     */
    protected static ThreadLocal<Stack<SystemEngineConfig>> systemEngineConfigStackThreadLocal = new ThreadLocal<>();
    
    public static CommandContext getCommandContext() {
        // 栈 特点是后进先出
        Stack<CommandContext> stack = getStack(commandContextThreadLocal);
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek();
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
        Stack<SystemEngineConfig> stack = getStack(systemEngineConfigStackThreadLocal);
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek();
        
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

    protected static <T> Stack<T> getStack(ThreadLocal<Stack<T>> threadLocal) {
        Stack<T> stack = threadLocal.get();
        if (stack == null) {
            stack = new Stack<>();
            threadLocal.set(stack);            
        }
        return stack;
    }

}
