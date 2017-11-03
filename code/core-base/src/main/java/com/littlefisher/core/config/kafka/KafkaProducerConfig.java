package com.littlefisher.core.config.kafka;

import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.google.common.collect.Maps;

/**
 * Description: KafkaProducerConfig.java
 *
 * Created on 2017年11月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
public class KafkaProducerConfig {

    @Value("${producer_bootstrap_servers}")
    private String bootstrapServers;

    @Value("${producer_acks}")
    private String acks;

    @Value("${producer_client_id}")
    private String clientId;

    @Value("${producer_retries}")
    private String retries;

    @Value("${producer_batch_size}")
    private String batchSize;

    @Value("${producer_linger_ms}")
    private String lingerMs;

    @Value("${producer_buffer_memory}")
    private String bufferMemory;

    @Value("${producer_request_timeout_ms}")
    private String requestTimeoutMs;

    @Value("${producer_reconnect_backoff_ms}")
    private String reconnectBackoffMs;

    @Value("${producer_retry_backoff_ms}")
    private String retryBackoffMs;

    @Value("${producer_key_serializer}")
    private String keySerializer;

    @Value("${producer_value_serializer}")
    private String valueSerializer;

    @Bean("producerFactory")
    public <K, V> DefaultKafkaProducerFactory<K, V> kafkaProducerFactory() {
        return new DefaultKafkaProducerFactory<>(generateKafkaProducerConfig());
    }

    private Map<String, Object> generateKafkaProducerConfig() {
        Map<String, Object> config = Maps.newHashMap();
        // zk的ip和host，可以多个
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        // ack模式
        config.put(ProducerConfig.ACKS_CONFIG, acks);
        // 用户随意指定，但是不能重复，主要用于跟踪记录消息
         config.put(ProducerConfig.CLIENT_ID_CONFIG, clientId);
        // 重试次数
        config.put(ProducerConfig.RETRIES_CONFIG, retries);
        // Producer会尝试去把发往同一个Partition的多个Requests进行合并，
        // batch.size指明了一次Batch合并后Requests总大小的上限。如果这个值设置的太小，可能会导致所有的Request都不进行Batch
        config.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        // Producer默认会把两次发送时间间隔内收集到的所有Requests进行一次聚合然后再发送，以此提高吞吐量，
        // 而linger.ms则更进一步，这个参数为每次发送增加一些delay，以此来聚合更多的Message
        config.put(ProducerConfig.LINGER_MS_CONFIG, lingerMs);
        // 在Producer端用来存放尚未发送出去的Message的缓冲区大小。
        // 缓冲区满了之后可以选择阻塞发送或抛出异常，由block.on.buffer.full的配置来决定
        config.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        // Broker等待ack的超时时间，若等待时间超过此值，会返回客户端错误信息。
        config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, requestTimeoutMs);
        // 每次重新连接的间隔时间
        config.put(ProducerConfig.RECONNECT_BACKOFF_MS_CONFIG, reconnectBackoffMs);
        // 每次失败后的间隔时间
        config.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, retryBackoffMs);
        // Key的序列化类
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
        // Value的序列化类
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
        return config;
    }

    @Bean
    public <K, V> KafkaTemplate<K, V> kafkaTemplate() {
        KafkaTemplate<K, V> kafkaTemplate =  new KafkaTemplate<>(kafkaProducerFactory(), true);
        kafkaTemplate.setDefaultTopic("TestTopic");
        return kafkaTemplate;
    }
}
