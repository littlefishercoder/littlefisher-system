package com.littlefisher.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author jinyn22648
 * @version $$Id: Application.java, v 0.1 2018/6/22 上午10:20 jinyn22648 Exp $$
 */
@SpringBootApplication
@EnableEurekaServer
@SuppressWarnings("PMD.UseUtilityClass")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
