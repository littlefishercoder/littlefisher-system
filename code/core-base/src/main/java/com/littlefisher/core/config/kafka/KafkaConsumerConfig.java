package com.littlefisher.core.config.kafka;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.littlefisher.core.config.kafka.consumer.DefaultConsumerMessageListener;

/**
 * Description: KafkaCustomerConfig.java
 *
 * Created on 2017年11月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
public class KafkaConsumerConfig {

    @Value("${consumer_bootstrap_servers}")
    private String bootstrapServers;

    @Value("${consumer_group_id}")
    private String groupId;

    @Value("${consumer_enable_auto_commit}")
    private String enableAutoCommit;

    @Value("${consumer_auto_commit_interval_ms}")
    private String autoCommitIntervalMs;

    @Value("${consumer_session_timeout_ms}")
    private String sessionTimeoutMs;

    @Value("${consumer_key_deserializer}")
    private String keyDeserializer;

    @Value("${consumer_value_deserializer}")
    private String valueDeserializer;

    @Value("${consumer_topics}")
    private String topics;

    @Bean("consumerFactory")
    public <K, V> DefaultKafkaConsumerFactory<K, V> kafkaConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(generateKafkaConsumerConfig());
    }

    private Map<String, Object> generateKafkaConsumerConfig() {
        Map<String, Object> config = Maps.newHashMap();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
        config.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitIntervalMs);
        config.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeoutMs);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);
        return config;
    }

    @Bean
    public DefaultConsumerMessageListener consumerMessageListener() {
        return new DefaultConsumerMessageListener();
    }

    @Bean
    public ContainerProperties containerProperties() {
        ContainerProperties containerProperties = new ContainerProperties(Iterables
                .toArray(Splitter.on(",").omitEmptyStrings().trimResults().split(topics),
                        String.class));
        containerProperties.setMessageListener(consumerMessageListener());
        containerProperties.setAckMode(AbstractMessageListenerContainer.AckMode.RECORD);
        return containerProperties;
    }

    @Bean(initMethod = "doStart")
    public <K, V> KafkaMessageListenerContainer<K, V> kafkaMessageListenerContainer() {
        KafkaMessageListenerContainer<K, V> kafkaMessageListenerContainer = new KafkaMessageListenerContainer<>(
                kafkaConsumerFactory(), containerProperties());
        kafkaMessageListenerContainer.setAutoStartup(true);
        return kafkaMessageListenerContainer;
    }
}
