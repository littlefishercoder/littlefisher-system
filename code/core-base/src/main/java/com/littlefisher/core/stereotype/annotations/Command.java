package com.littlefisher.core.stereotype.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Description: Command.java
 * 设置Scope为prototype，以让每一个Command都能放入Spring容器中，并且还能处理多线程问题
 *
 * Created on 2018年01月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@Scope("prototype")
public @interface Command {

    /**
     * command映射为Spring的Bean，该value为Spring的BeanId
     * @return beanId
     */
    String value() default "";
}
