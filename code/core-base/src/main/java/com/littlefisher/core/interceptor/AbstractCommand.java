package com.littlefisher.core.interceptor;

import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月11日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 * @param <U> <U>
 */
public abstract class AbstractCommand<U> implements Command<U> {

    /**
     * commandContext
     */
    private CommandContext commandContext;

    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @return <br>
     */
    public CommandContext getCommandContext() {
        return commandContext;
    }

    /**
     * Description: <br>
     * 此方法只会在command execute 方法内部使用
     * 
     * @author jinyanan<br>
     * @taskId <br>
     * @param <T> <br>
     * @param typeClass <br>
     * @return <T> <br>
     * @throws BaseAppException <br>
     */
    protected <T> T getMapper(Class<T> typeClass) throws BaseAppException {
        return commandContext.getDbSqlSession().getMapper(typeClass);
    }

    /**
     * Description: <br>
     * 此方法只会在command execute 方法内部使用
     * 
     * @author jinyanan<br>
     * @taskId <br>
     * @return EventDispatcher <br>
     * @throws BaseAppException <br>
     */
//    protected EventDispatcher getEventDispatcher() throws BaseAppException {
//        return commandContext.getSystemEngineConfig().getEventDispatcher();
//    }

    /**
     * Description: <br>
     * 
     * @author jinyanan<br>
     * @taskId <br>
     * @param event <br>
     * @throws BaseAppException <br>
     */
//    public void dispatchEvent(Event event) throws BaseAppException {
//        if (getEventDispatcher().isEnabled()) {
//            getEventDispatcher().dispatchEvent(event);
//        }   
//    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @param type <br>
     * @param entity <br>
     * @throws BaseAppException <br>
     */
//    public void dispatchEntityEvent(String type, Object entity) throws BaseAppException {
//        if (getEventDispatcher().isEnabled()) {
//            getEventDispatcher().dispatchEntityEvent(type, entity);
//        }
//    }

    /**
     * Description: <br>
     * 此方法只会在command execute 方法内部使用
     * 
     * @author jinyanan<br>
     * @taskId <br>
     * @param serviceName <br>
     * @return ServiceImpl <br>
     * @throws BaseAppException <br>
     */
    protected ServiceImpl getService(String serviceName) throws BaseAppException {
        return commandContext.getSystemEngineConfig().getService(serviceName);
    }

    /**
     * Description: <br>
     * 
     * @author jinyanan<br>
     * @taskId <br>
     * @param commandContext <br>
     * @return Object <br>
     * @throws BaseAppException <br>
     */
    public U execute(CommandContext commandContext) throws BaseAppException {
        this.commandContext = commandContext;
        return execute();
    }

    /**
     * Description: <br>
     * 
     * @author jinyanan<br>
     * @taskId <br>
     * @return Object <br>
     * @throws BaseAppException <br>
     */
    public abstract U execute() throws BaseAppException;
}
