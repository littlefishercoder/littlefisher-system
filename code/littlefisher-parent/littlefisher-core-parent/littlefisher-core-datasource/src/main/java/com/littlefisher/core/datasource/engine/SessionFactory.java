package com.littlefisher.core.datasource.engine;

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
public interface SessionFactory {

    /**
     * 获取Session类型
     *
     * @return Class
     */
    Class<?> getSessionType();

    /**
     * 开启Session
     * @return Session
     */
    Session openSession();
}
