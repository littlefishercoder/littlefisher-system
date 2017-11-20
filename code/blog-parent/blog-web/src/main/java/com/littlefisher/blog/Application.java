package com.littlefisher.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Description: Application.java
 *
 * Created on 2017年11月17日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@SpringBootApplication
@MapperScan("com.littlefisher.**.dao")
@ComponentScan(basePackages = {
        "com.littlefisher.core.interceptor.service",
        "com.littlefisher.**.service.impl",
        "com.littlefisher.core.utils",
        "com.littlefisher.core.exception",
        "com.littlefisher.core.config",
})
@PropertySource("file:${SYSTEM_HOME}/etc/properties/jdbc.properties")
@PropertySource("file:${SYSTEM_HOME}/etc/properties/kafka.properties")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
