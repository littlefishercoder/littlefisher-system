package com.littlefisher.core.spring.cloud.feign;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.AnnotatedParameterProcessor;
import org.springframework.cloud.openfeign.annotation.PathVariableParameterProcessor;
import org.springframework.cloud.openfeign.annotation.RequestHeaderParameterProcessor;
import org.springframework.cloud.openfeign.annotation.RequestParamParameterProcessor;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

/**
 *
 * @author jinyn22648
 * @version $$Id: FeignConfiguration.java, v 0.1 2018/6/28 下午5:25 jinyn22648 Exp $$
 */
@Configuration
public class FeignConfiguration {

    /**
     * 设置Feign参数配置时能解析的注解
     * 
     * @return Contract
     */
    @Bean
    public Contract feignContract() {
        List<AnnotatedParameterProcessor> processors = new ArrayList<>();
        processors.add(new JsonArgumentParameterProcessor());
        processors.add(new PathVariableParameterProcessor());
        processors.add(new RequestHeaderParameterProcessor());
        processors.add(new RequestParamParameterProcessor());
        return new SpringMvcContract(processors);
    }
}
