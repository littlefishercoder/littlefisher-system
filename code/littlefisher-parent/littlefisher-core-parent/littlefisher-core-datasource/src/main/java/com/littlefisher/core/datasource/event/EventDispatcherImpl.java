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

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void addEventListener(EventListener listenerToAdd) {
        eventSupport.addEventListener(listenerToAdd);
    }

    @Override
    public void addEventListener(EventListener listenerToAdd, String... types) {
        eventSupport.addEventListener(listenerToAdd, types);
    }

    @Override
    public void removeEventListener(EventListener listenerToRemove) {
        eventSupport.removeEventListener(listenerToRemove);
    }

    @Override
    public void dispatchEvent(Event event) {
        if (enabled) {
            eventSupport.dispatchEvent(event);
        }

    }

    @Override
    public void dispatchEntityEvent(String type, Object entity) {
        EntityEvent event = EventBuilder.createEntityEvent(type, entity);
        dispatchEvent(event);
    }
}
