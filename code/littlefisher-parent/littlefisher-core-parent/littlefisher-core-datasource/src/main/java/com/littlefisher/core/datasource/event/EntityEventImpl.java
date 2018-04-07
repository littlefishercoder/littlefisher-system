package com.littlefisher.core.datasource.event;

import com.littlefisher.core.common.utils.ExceptionHandler;

/**
 * Description:
 *
 * Created on 2017年2月10日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class EntityEventImpl extends EventImpl implements EntityEvent {

    /**
     * entity
     */
    protected Object entity;

    public EntityEventImpl(Object entity, String type) {
        super(type);
        if (entity == null) {
            //  Entity cannot be null.
            ExceptionHandler.publish("COMMON-000001", null, "Entity");
        }
        this.entity = entity;
    }

    @Override
    public Object getEntity() {
        return entity;
    }
}
