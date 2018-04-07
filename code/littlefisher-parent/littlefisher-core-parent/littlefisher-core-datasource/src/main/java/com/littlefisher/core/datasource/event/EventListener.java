package com.littlefisher.core.datasource.event;

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
public interface EventListener {

    /**
     * Called when an event has been fired
     * @param event the event
     */
    void onEvent(Event event);
    
    /**
     * isFailOnException
     * @return whether or not the current operation should fail when this listeners execution
     * throws an exception. 
     */
    boolean isFailOnException();
}
