package com.littlefisher.core.config.kafka;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Description: KafkaConfig.java
 *
 * Created on 2017年11月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
@Import({ KafkaProducerConfig.class, KafkaConsumerConfig.class })
public class KafkaConfig {
}
