package com.littlefisher.core.config.kafka.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * Description: AbstractConsumerMessageListener.java
 *
 * Created on 2017年11月03日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public abstract class AbstractConsumerMessageListener implements MessageListener<String, String> {

    private static LittleFisherLogger logger = LittleFisherLogger
            .getLogger(AbstractConsumerMessageListener.class);

    /** 初始线程数 */
    private int threadNum = 16;

    /** 最大线程数 */
    private int maxThreadNum = 200;

    /** 队列中最大消息数 */
    private int maxQueueSize = 2000;

    private ExecutorService executorService = new ThreadPoolExecutor(threadNum, maxThreadNum, 0L,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(maxQueueSize),
            new ThreadFactoryBuilder().setNameFormat("ConsumerRecord-%d").build(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    @Override
    public void onMessage(ConsumerRecord<String, String> data) {
        logger.debug("ConsumerRecord: {}", data);
        executorService.execute(() -> {
            logger.info("[{}]开始被消费，该消息偏移量为[{}]", data.topic(), data.offset());
            doBusiness(new MessageRecord(data.topic(), data.key(), data.value()));
            logger.info("[{}]消费结束，该消息偏移量为[{}]", data.topic(), data.offset());
        });
    }

    /**
     * 消息具体业务处理的逻辑
     *
     * @param messageRecord 封装消息的topic、key、value
     */
    protected abstract void doBusiness(MessageRecord messageRecord);
}
