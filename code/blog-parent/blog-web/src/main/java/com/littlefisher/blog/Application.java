package com.littlefisher.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
