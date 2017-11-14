package com.littlefisher.core.kafka;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.littlefisher.core.config.RootConfig;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * Description: KafkaConsumerTest.java
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
public class KafkaConsumerTest {

    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(KafkaConsumerTest.class);

    @Test
    public void testGetMessage() throws InterruptedException {
        while (true) {
            logger.debug("currentTime: {}", new Date());
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
