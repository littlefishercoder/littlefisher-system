package com.littlefisher.core.spring.cloud.feign;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;

import org.springframework.cloud.openfeign.AnnotatedParameterProcessor;
import org.springframework.http.HttpMethod;

import com.littlefisher.core.spring.cloud.feign.annotation.JsonArgument;

import feign.MethodMetadata;
import feign.Util;

/**
 * {@link JsonArgument} parameter processor.
 * 
 * @author jinyn22648
 * @version $$Id: JsonArgumentParameterProcessor.java, v 0.1 2018/6/28 下午6:46 jinyn22648 Exp $$
 */
public class JsonArgumentParameterProcessor implements AnnotatedParameterProcessor {

    /** ANNOTATION */
    private static final Class<JsonArgument> ANNOTATION = JsonArgument.class;

    @Override
    public Class<? extends Annotation> getAnnotationType() {
        return ANNOTATION;
    }

    @Override
    public boolean processArgument(AnnotatedParameterContext context, Annotation annotation, Method method) {
        MethodMetadata data = context.getMethodMetadata();
        String name = ANNOTATION.cast(annotation).value();
        String httpMethod = data.template().method();

        Util.checkState(Util.emptyToNull(name) != null, "JsonArgument.value() was empty on parameter %s",
            context.getParameterIndex());

        context.setParameterName(name);

        if (httpMethod != null && (HttpMethod.POST.matches(httpMethod) || HttpMethod.PUT.matches(httpMethod)
            || HttpMethod.DELETE.matches(httpMethod))) {
            data.formParams().add(name);
        } else {
            data.indexToExpanderClass().put(context.getParameterIndex(), ToJsonExpander.class);
            Collection<String> query = context.setTemplateParameter(name, data.template().queries().get(name));
            data.template().query(name, query);
        }

        return true;
    }
}