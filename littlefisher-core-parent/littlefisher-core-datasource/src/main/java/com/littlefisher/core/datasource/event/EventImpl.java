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
public class EventImpl implements Event {

    /**
     * type
     */
    private String type;

    /**
     * EventImpl
     *
     * @param type <br>
     */
    public EventImpl(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
