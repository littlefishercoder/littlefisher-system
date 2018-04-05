package com.littlefisher.web.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * Description: Application.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDubboConfiguration
@ComponentScan(basePackages = {"com.littlefisher.**"})
//@DubboComponentScan(basePackages = "com.littlefisher.**.service.impl")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
