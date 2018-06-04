package com.littlefisher.core.datasource.interceptor;

import com.littlefisher.core.datasource.interceptor.service.ServiceImpl;

/**
 * Description:
 *
 * Created on 2017年2月11日
 *
 * @param <U> 泛型
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
     *  此方法只会在command execute 方法内部使用
     * @param typeClass Mapper对应的class
     * @param <T> 泛型
     * @return Mapper
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
     * 此方法只会在command execute 方法内部使用
     * @param serviceName 服务名
     * @return 具体的ServiceImpl
     */
    protected ServiceImpl getService(String serviceName) {
        return commandContext.getSystemEngineConfig().getService(serviceName);
    }

    /**
     * Description: 获取Service
     *
     * @param <T> 泛型
     * @param clazzService clazzService
     * @return ServiceImpl的具体实现类
     */
    protected <T> T getService(Class<? extends ServiceImpl> clazzService) {
        return commandContext.getSystemEngineConfig().getService(clazzService);
    }

    /**
     * Description: <br>
     *
     * @param commandContext <br>
     * @return Object <br>
     */
    @Override
    public U execute(CommandContext commandContext) {
        this.commandContext = commandContext;
        return execute();
    }

    /**
     * 执行命令
     *
     * @return 命令返回值
     */
    public abstract U execute();
}
