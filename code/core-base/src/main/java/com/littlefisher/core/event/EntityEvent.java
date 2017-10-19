package com.littlefisher.core.event;

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
public interface EntityEvent extends Event {

    /**
     * 获取事件传参
     * @return 事件的传参
     */
    Object getEntity();
}
