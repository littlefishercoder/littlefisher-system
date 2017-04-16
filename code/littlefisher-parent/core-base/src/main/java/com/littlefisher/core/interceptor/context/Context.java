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
     * commandContextThreadLocal
     */
    protected static ThreadLocal<Stack<CommandContext>> commandContextThreadLocal = new ThreadLocal<Stack<CommandContext>>();
    
    /**
     * systemEngineConfigStackThreadLocal
     */
    protected static ThreadLocal<Stack<SystemEngineConfig>> systemEngineConfigStackThreadLocal = new ThreadLocal<Stack<SystemEngineConfig>>();
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public static CommandContext getCommandContext() {
        Stack<CommandContext> stack = getStack(commandContextThreadLocal);
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek();
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param commandContext <br>
     */
    public static void setCommandContext(CommandContext commandContext) {
        getStack(commandContextThreadLocal).push(commandContext);
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public static int getCommandContextStackSize() {
        return getStack(commandContextThreadLocal).size();
        
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    public static void removeCommandContext() {
        getStack(commandContextThreadLocal).pop();
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public static SystemEngineConfig getSystemEngineConfig() {
        Stack<SystemEngineConfig> stack = getStack(systemEngineConfigStackThreadLocal);
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek();
        
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param systemEngineConfig <br>
     */
    public static void setSystemEngineConfig(SystemEngineConfig systemEngineConfig) {
        getStack(systemEngineConfigStackThreadLocal).push(systemEngineConfig);
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br> <br>
     */
    public static void removeEshopEngineConfig() {
        getStack(systemEngineConfigStackThreadLocal).pop();        
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param <T> <br>
     * @param threadLocal <br>
     * @return <br>
     */
    protected static <T> Stack<T> getStack(ThreadLocal<Stack<T>> threadLocal) {
        Stack<T> stack = threadLocal.get();
        if (stack == null) {
            stack = new Stack<T>();
            threadLocal.set(stack);            
        }
        return stack;
    }
}
