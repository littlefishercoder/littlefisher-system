package com.littlefisher.core.event;

import com.littlefisher.core.exception.BaseAppException;

/**
 * Description:
 *
 * Created on 2017年2月10日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface EventDispatcher {

    /**
     * Adds an event-listener which will be notified of ALL events by the dispatcher.
     *
     * @param listenerToAdd the listener to add
     */
    void addEventListener(EventListener listenerToAdd);

    /**
     * Adds an event-listener which will only be notified when an event of the given types occurs.
     *
     * @param listenerToAdd the listener to add
     * @param types types of events the listener should be notified for
     */
    void addEventListener(EventListener listenerToAdd, String... types);

    /**
     * Removes the given listener from this dispatcher. The listener will no longer be notified, regardless of the
     * type(s) it was registered for in the first place.
     *
     * @param listenerToRemove listener to remove
     */
    void removeEventListener(EventListener listenerToRemove);

    /**
     * Dispatches the given event to any listeners that are registered.
     *
     * @param event event to dispatch.
     * @throws BaseAppException <br>
     */
    void dispatchEvent(Event event) throws BaseAppException;

    void dispatchEntityEvent(String type, Object entity) throws BaseAppException;

    /**
     * setEnabled
     *
     * @param enabled true, if event dispatching should be enabled.
     */
    void setEnabled(boolean enabled);

    /**
     * isEnabled
     *
     * @return true, if event dispatcher is enabled.
     */
    boolean isEnabled();
}
