package com.littlefisher.core.event;

import com.littlefisher.core.exception.BaseAppException;

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
public class EventBuilder {

    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @param type <br>
     * @return <br>
     */
    public static Event createGlobalEvent(String type) {
        EventImpl newEvent = new EventImpl(type);
        return newEvent;
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @param type <br>
     * @param entity <br>
     * @return <br>
     * @throws BaseAppException 
     */
    public static EntityEvent createEntityEvent(String type, Object entity) throws BaseAppException {
        EntityEventImpl newEvent = new EntityEventImpl(entity, type);
        return newEvent;
    }
}
