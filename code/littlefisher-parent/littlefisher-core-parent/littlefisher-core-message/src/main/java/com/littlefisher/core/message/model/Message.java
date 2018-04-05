package com.littlefisher.core.message.model;

/**
 * Description: Message.java
 *
 * Created on 2017年12月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class Message {

    /** 消息的主题 */
    private String topic;

    /** 消息的key */
    private String key;

    /** 消息的value */
    private String value;

    public Message() {
    }

    public Message(String topic, String key, String value) {
        this.topic = topic;
        this.key = key;
        this.value = value;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Message{" + "topic='" + topic + '\'' + ", key='" + key + '\'' + ", value='" + value + '\'' + '}';
    }
}
