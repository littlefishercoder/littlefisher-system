package com.yc.room1000.engine.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.littlefisher.core.spring.config.RootConfig;

/**
 * 
 * Description: 
 *  
 * Created on 2017年4月19日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
@Import({
    RootConfig.class,
//    ActivitiConfig.class
})
public class WebSpringConfig {

}
