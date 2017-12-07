package com.littlefisher.core.event;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.utils.CollectionUtil;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
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
    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(EventSupport.class);

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
        eventListeners = Lists.newArrayList();
        typedListeners = Maps.newHashMap();
    }

    public synchronized void addEventListener(EventListener listenerToAdd) {
        if (listenerToAdd == null) {
            throw new IllegalArgumentException("Listener cannot be null.");
        }
        if (!eventListeners.contains(listenerToAdd)) {
            eventListeners.add(listenerToAdd);
        }
    }

    public synchronized void addEventListener(EventListener listenerToAdd, String... types) {
        if (listenerToAdd == null) {
            throw new IllegalArgumentException("Listener cannot be null.");
        }
        if (ArrayUtils.isEmpty(types)) {
            addEventListener(listenerToAdd);
        } else {
            Arrays.stream(types).forEach(type -> addTypedEventListener(listenerToAdd, type));
        }
    }

    public void removeEventListener(EventListener listenerToRemove) {
        eventListeners.remove(listenerToRemove);

        typedListeners.values().forEach(listeners -> listeners.remove(listenerToRemove));
    }

    public void dispatchEvent(Event event) throws BaseAppException {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null.");
        }
        if (event.getType() == null) {
            throw new IllegalArgumentException("Event type cannot be null.");
        }

        // Call global listeners
        if (CollectionUtil.isNotEmpty(eventListeners)) {
            eventListeners.forEach(listener -> dispatchEvent(event, listener));
        }

        // Call typed listeners, if any
        List<EventListener> typed = typedListeners.get(event.getType());
        if (CollectionUtil.isNotEmpty(typed)) {
            typed.forEach(listener -> dispatchEvent(event, listener));
        }
    }

    protected void dispatchEvent(Event event, EventListener listener) throws BaseAppException {
        try {
            listener.onEvent(event);
        } catch (Exception ex) {
            if (listener.isFailOnException()) {
                logger.error(ex.getMessage());
                throw new BaseAppException("S-SYSTEMCOM-004", ex);
            } else {
                // Ignore the exception and continue notifying remaining listeners. The
                // listener
                // explicitly states that the exception should not bubble up
                logger.warn("Exception while executing event-listener, which was ignored", ex);
            }
        }
    }

    protected synchronized void addTypedEventListener(EventListener listener, String type) {
        List<EventListener> listeners = typedListeners.computeIfAbsent(type, k -> Lists.newArrayList());
        // Add an empty list of listeners for this type

        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }
}
