package com.littlefisher.core.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.utils.LittleFisherLogger;

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
public class EventSupport {

    /**
     * logger
     */
    private static final LittleFisherLogger logger = LittleFisherLogger.getLogger(EventSupport.class);

    /**
     * eventListeners
     */
    protected List<EventListener> eventListeners;

    /**
     * typedListeners
     */
    protected Map<String, List<EventListener>> typedListeners;

    /**
     * EventSupport
     */
    public EventSupport() {
        eventListeners = new ArrayList<EventListener>();
        typedListeners = new HashMap<String, List<EventListener>>();
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param listenerToAdd <br>
     */
    public synchronized void addEventListener(EventListener listenerToAdd) {
        if (listenerToAdd == null) {
            throw new IllegalArgumentException("Listener cannot be null.");
        }
        if (!eventListeners.contains(listenerToAdd)) {
            eventListeners.add(listenerToAdd);
        }
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
    public synchronized void addEventListener(EventListener listenerToAdd, String... types) {
        if (listenerToAdd == null) {
            throw new IllegalArgumentException("Listener cannot be null.");
        }

        if (types == null || types.length == 0) {
            addEventListener(listenerToAdd);

        }
        else {
            for (String type : types) {
                addTypedEventListener(listenerToAdd, type);
            }
        }
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param listenerToRemove <br>
     */
    public void removeEventListener(EventListener listenerToRemove) {
        eventListeners.remove(listenerToRemove);

        for (List<EventListener> listeners : typedListeners.values()) {
            listeners.remove(listenerToRemove);
        }
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
    public void dispatchEvent(Event event) throws BaseAppException {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null.");
        }

        if (event.getType() == null) {
            throw new IllegalArgumentException("Event type cannot be null.");
        }

        // Call global listeners
        if (eventListeners != null && !eventListeners.isEmpty()) {
            for (EventListener listener : eventListeners) {
                dispatchEvent(event, listener);
            }
        }

        // Call typed listeners, if any
        List<EventListener> typed = typedListeners.get(event.getType());
        if (typed != null && !typed.isEmpty()) {
            for (EventListener listener : typed) {
                dispatchEvent(event, listener);
            }
        }
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param event <br>
     * @param listener <br>
     * @throws BaseAppException 
     */
    protected void dispatchEvent(Event event, EventListener listener) throws BaseAppException {
        try {
            listener.onEvent(event);
        }
        catch (Exception ex) {
            if (listener.isFailOnException()) {
                logger.error(ex.getMessage());
                throw new BaseAppException("S-SYSTEMCOM-004", ex);
            }
            else {
                // Ignore the exception and continue notifying remaining listeners. The
                // listener
                // explicitly states that the exception should not bubble up
                logger.warn("Exception while executing event-listener, which was ignored", ex);
            }
        }
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param listener <br>
     * @param type <br>
     */
    protected synchronized void addTypedEventListener(EventListener listener, String type) {
        List<EventListener> listeners = typedListeners.get(type);
        if (listeners == null) {
            // Add an empty list of listeners for this type
            listeners = new ArrayList<EventListener>();
            typedListeners.put(type, listeners);
        }

        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }
}
