package com.littlefisher.core.kafka;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.littlefisher.core.config.RootConfig;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * Description: KafkaPruducerTest.java
 *
 * Created on 2017年11月03日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
@Transactional
@Rollback
public class KafkaPruducerTest {

    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(KafkaPruducerTest.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void testSendMessage() throws InterruptedException {
        String topic = "TestTopic";

        for (int i = 0; i < 100; i++) {
            logger.debug("开始发送第{}条数据", i);
            kafkaTemplate.send(topic, "TestTopic-" + i);
        }
        logger.debug("消息发送完毕");

        while (true) {
            logger.debug("currentTime: {}", new Date());
            Thread.sleep(2000);
        }
    }
}
