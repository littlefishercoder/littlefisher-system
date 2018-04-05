package com.littlefisher.core.validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.oval.IValidator;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.configuration.annotation.BeanValidationAnnotationsConfigurer;

/**
 * Description: OvalConfig.java
 *
 * Created on 2018年02月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
public class OvalConfig {

    @Bean
    public IValidator getValidator() {
        // BeanValidationAnnotationsConfigurer 引入javax.validation的业界通用校验规范
        // AnnotationsConfigurer默认校验配置
        return new Validator(new BeanValidationAnnotationsConfigurer(), new AnnotationsConfigurer());
    }
}
