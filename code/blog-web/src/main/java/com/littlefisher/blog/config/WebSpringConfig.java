package com.littlefisher.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.littlefisher.core.config.RootConfig;

/**
 * 
 * Description: 
 *  
 * Created on 2017年5月17日 
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
