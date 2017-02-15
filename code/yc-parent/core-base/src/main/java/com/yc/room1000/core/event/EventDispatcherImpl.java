package com.yc.room1000.core.event;

import com.yc.room1000.core.exception.BaseAppException;

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
public class EventDispatcherImpl implements EventDispatcher {

    /**
     * eventSupport
     */
    protected EventSupport eventSupport;

    /**
     * enabled
     */
    protected boolean enabled = true;

    /**
     * EventDispatcherImpl
     */
    public EventDispatcherImpl() {
        eventSupport = new EventSupport();
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param enabled <br>
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @return <br>
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param listenerToAdd <br>
     */
    @Override
    public void addEventListener(EventListener listenerToAdd) {
        eventSupport.addEventListener(listenerToAdd);
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param listenerToAdd <br>
     * @param types <br>
     */
    @Override
    public void addEventListener(EventListener listenerToAdd, String... types) {
        eventSupport.addEventListener(listenerToAdd, types);
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param listenerToRemove <br>
     */
    @Override
    public void removeEventListener(EventListener listenerToRemove) {
        eventSupport.removeEventListener(listenerToRemove);
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param event <br>
     * @throws BaseAppException 
     */
    @Override
    public void dispatchEvent(Event event) throws BaseAppException {
        if (enabled) {
            eventSupport.dispatchEvent(event);
        }

    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param type <br>
     * @param entity <br>
     * @throws BaseAppException <br>
     */
    @Override
    public void dispatchEntityEvent(String type, Object entity) throws BaseAppException {
        EntityEvent event = EventBuilder.createEntityEvent(type, entity);
        dispatchEvent(event);

    }
}
