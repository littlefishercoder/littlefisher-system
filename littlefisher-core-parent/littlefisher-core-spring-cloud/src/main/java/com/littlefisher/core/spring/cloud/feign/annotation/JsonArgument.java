package com.littlefisher.core.spring.cloud.feign.annotation;

import org.springframework.core.annotation.AliasFor;

/**
 *
 * @author jinyn22648
 * @version $$Id: JsonArgument.java, v 0.1 2018/6/28 下午5:24 jinyn22648 Exp $$
 */
public @interface JsonArgument {

    /**
     * Alias for {@link #name}.
     * 
     * @return name
     */
    @AliasFor("name")
    String value() default "";

    /**
     * The name of the object model to bind to.
     * 
     * @return name
     */
    @AliasFor("value")
    String name() default "";
}
