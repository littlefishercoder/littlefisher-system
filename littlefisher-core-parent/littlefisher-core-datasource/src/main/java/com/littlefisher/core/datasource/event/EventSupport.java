package com.littlefisher.core.datasource.event;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.littlefisher.core.common.utils.CollectionUtil;
import com.littlefisher.core.common.utils.ExceptionHandler;
import com.littlefisher.core.common.utils.LittleFisherLogger;

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
     * 构造函数
     * 
     * EventSupport
     */
    public EventSupport() {
        eventListeners = Lists.newArrayList();
        typedListeners = Maps.newHashMap();
    }

    /**
     * 增加监听器
     * 
     * @param listenerToAdd 要增加的监听器
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
     * 增加监听器
     * 
     * @param listenerToAdd 要增加的监听器
     * @param types 类型
     */
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

    /**
     * 移除监听
     * 
     * @param listenerToRemove 要移除的监听器
     */
    public void removeEventListener(EventListener listenerToRemove) {
        eventListeners.remove(listenerToRemove);

        typedListeners.values().forEach(listeners -> listeners.remove(listenerToRemove));
    }

    /**
     * 发布事件
     * 
     * @param event 事件
     */
    public void dispatchEvent(Event event) {
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

    /**
     * 发布事件
     * 
     * @param event 事件
     * @param listener 监听器
     */
    protected void dispatchEvent(Event event, EventListener listener) {
        try {
            listener.onEvent(event);
        } catch (Exception e) {
            if (listener.isFailOnException()) {
                ExceptionHandler.publish("COMMON-000002", null, e);
            } else {
                // Ignore the exception and continue notifying remaining listeners. The
                // listener
                // explicitly states that the exception should not bubble up
                logger.warn("Exception while executing event-listener, which was ignored", e);
            }
        }
    }

    /**
     * 根据类型增加监听
     * 
     * @param listener 时间监听器
     * @param type 类型
     */
    protected synchronized void addTypedEventListener(EventListener listener, String type) {
        List<EventListener> listeners = typedListeners.computeIfAbsent(type, k -> Lists.newArrayList());
        // Add an empty list of listeners for this type

        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }
}
