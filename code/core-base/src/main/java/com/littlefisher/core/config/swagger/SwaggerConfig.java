package com.littlefisher.core.config.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * Description:
 *
 * Created on 2017年1月25日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
@EnableSwagger
public class SwaggerConfig {

    /**
     * springSwaggerConfig
     */
    @Autowired
    private SpringSwaggerConfig springSwaggerConfig;

    /**
     * Description: Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc framework - allowing for multiple
     * swagger groups i.e. same code base multiple swagger resource listings.
     *
     * @return SwaggerSpringMvcPlugin
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*?")
                // 是否展示通用的HTTP 返回码的含义
                .useDefaultResponseMessages(false);
    }

    /**
     * Description:
     *
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfo("Littlefisher REST API", "API Description", "API terms of service", "jinyanan@room1000.com",
                "Version 1.0", "No License URL");
    }
}
