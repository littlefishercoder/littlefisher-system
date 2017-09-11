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
public class EntityEventImpl extends EventImpl implements EntityEvent {

    /**
     * entity
     */
    protected Object entity;
    
    public EntityEventImpl(Object entity, String type) throws BaseAppException {
        super(type);
        if (entity == null) {
            //  Entity cannot be null.            
            throw new BaseAppException("S-SYSTEMCOM-003");
        }
        this.entity = entity;
    }
    
    @Override
    public Object getEntity() {
        return entity;
    }
}
