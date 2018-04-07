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
public interface Session {

    /**
     * 刷新
     */
    void flush();

    /**
     * 关闭
     */
    void close();
}
