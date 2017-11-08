package com.littlefisher.core.config.kafka.consumer;

import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * Description: DefaultConsumerMessageListener.java
 *
 * Created on 2017年11月06日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class DefaultConsumerMessageListener extends AbstractConsumerMessageListener {

    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(DefaultConsumerMessageListener.class);

    @Override
    protected void doBusiness(MessageRecord messageRecord) {
        logger.debug("doBusiness, paramter is [{}]", messageRecord);
    }
}
