package com.littlefisher.core.kafka;

import org.springframework.kafka.annotation.KafkaListener;

import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * Description: GetKafkaMessage.java
 *
 * Created on 2017年12月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
// 如果要使用kafka消息，把下面的注释打开
//@Component
public class GetKafkaMessage {

    private LittleFisherLogger logger = LittleFisherLogger.getLogger(GetKafkaMessage.class);

    @KafkaListener(topics = "TestTopic")
    public void getMessage(String message) {
        logger.debug("Message: [{}]", message);
    }

}
