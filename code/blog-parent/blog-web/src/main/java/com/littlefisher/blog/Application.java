package com.littlefisher.blog;

import tk.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description: Application.java
 * {@link SpringBootApplication#exclude()}中增加{@link SecurityAutoConfiguration}用于关闭security校验
 *
 * Created on 2017年11月17日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.littlefisher.**.dao")
@ComponentScan(basePackages = {
        "com.littlefisher.**",
})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}
