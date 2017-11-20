package com.littlefisher.core.config.kafka.consumer;

/**
 * Description: MessageRecord.java
 *
 * Created on 2017年11月06日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class MessageRecord {

    /** 消息的主题 */
    private String topic;

    /** 消息的key */
    private String key;

    /** 消息的value */
    private String value;

    public MessageRecord(String topic, String key, String value) {
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
        return "MessageRecord{" + "topic='" + topic + '\'' + ", key='" + key + '\'' + ", value='"
               + value + '\'' + '}';
    }
}
