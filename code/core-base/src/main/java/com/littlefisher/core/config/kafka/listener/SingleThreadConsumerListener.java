package com.littlefisher.core.config.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * Description: SingleThreadConsumerListener.java
 *
 * Created on 2017年11月03日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class SingleThreadConsumerListener implements MessageListener<String, String> {

    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(SingleThreadConsumerListener.class);

    @Override
    public void onMessage(ConsumerRecord<String, String> data) {
        logger.debug("接收到的消息：" + data.value());
    }
}
