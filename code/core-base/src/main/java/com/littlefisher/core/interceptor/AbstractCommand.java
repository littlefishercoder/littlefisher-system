package com.littlefisher.core.interceptor;

import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * Description:
 *
 * Created on 2017年2月11日
 *
 * @param <U> <U>
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public abstract class AbstractCommand<U> implements Command<U> {

    /**
     * commandContext
     */
    private CommandContext commandContext;

    public CommandContext getCommandContext() {
        return commandContext;
    }

    /**
     * Description: <br>
     * 此方法只会在command execute 方法内部使用
     */
    protected <T> T getMapper(Class<T> typeClass) {
        return commandContext.getDbSqlSession().getMapper(typeClass);
    }

    //    /**
    //     * Description: <br>
    //     * 此方法只会在command execute 方法内部使用
    //     */
    //    protected EventDispatcher getEventDispatcher() throws BaseAppException {
    //        return commandContext.getSystemEngineConfig().getEventDispatcher();
    //    }

    //    /**
    //     * Description: <br>
    //     *
    //     */
    //    public void dispatchEvent(Event event) throws BaseAppException {
    //        if (getEventDispatcher().isEnabled()) {
    //            getEventDispatcher().dispatchEvent(event);
    //        }
    //    }

    //    public void dispatchEntityEvent(String type, Object entity) throws BaseAppException {
    //        if (getEventDispatcher().isEnabled()) {
    //            getEventDispatcher().dispatchEntityEvent(type, entity);
    //        }
    //    }

    /**
     * Description: <br>
     * 此方法只会在command execute 方法内部使用
     */
    protected ServiceImpl getService(String serviceName) throws BaseAppException {
        return commandContext.getSystemEngineConfig().getService(serviceName);
    }

    /**
     * Description: 获取Service
     *
     * @param <T> <T>
     * @param clazzService clazzService
     * @return ServiceImpl的具体实现类
     * @throws BaseAppException <br>
     */
    protected <T> T getService(Class<? extends ServiceImpl> clazzService) throws BaseAppException {
        return commandContext.getSystemEngineConfig().getService(clazzService);
    }

    /**
     * Description: <br>
     *
     * @param commandContext <br>
     * @return Object <br>
     * @throws BaseAppException <br>
     */
    public U execute(CommandContext commandContext) throws BaseAppException {
        this.commandContext = commandContext;
        return execute();
    }

    public abstract U execute() throws BaseAppException;
}
