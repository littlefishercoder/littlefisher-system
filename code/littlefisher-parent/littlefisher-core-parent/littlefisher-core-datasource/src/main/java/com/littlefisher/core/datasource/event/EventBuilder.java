package com.littlefisher.core.datasource.event;

/**
 * Description:
 *
 * Created on 2017年2月10日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class EventBuilder {

    public static Event createGlobalEvent(String type) {
        return new EventImpl(type);
    }

    public static EntityEvent createEntityEvent(String type, Object entity) {
        return new EntityEventImpl(entity, type);
    }
}
