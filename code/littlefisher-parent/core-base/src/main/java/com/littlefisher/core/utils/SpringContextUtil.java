package com.littlefisher.core.utils;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * Created on 2017年2月18日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Component
public final class SpringContextUtil implements ApplicationContextAware {

    /**
     * Spring上下文
     */
    private static ApplicationContext context;

    /**
     * private constructor
     */
    private SpringContextUtil() {

    }

    /**
     * 从文件系统初始化 <br>
     */
    public static void initFromFile(String... filePaths) {
        try {
            new FileSystemXmlApplicationContext(filePaths);
        } catch (BeansException e) {
            ExceptionHandler.publish("CORE-000002", null, e);
        }
    }

    /**
     * 从classpath初始化 <br>
     */
    public static void initFromClasspath(String... classpaths) {
        try {
            new ClassPathXmlApplicationContext(classpaths);
        } catch (BeansException e) {
            ExceptionHandler.publish("CORE-000002", null, e);
        }
    }

    /**
     * 获取bean <br>
     */
    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    /**
     * 获取bean类 <br>
     */
    public static Class<?> getBeanClass(String beanName) {
        return context.getType(beanName);
    }

    /**
     * 获取指定类型的所有bean名称 <br>
     */
    public static String[] getBeanNamesForType(Class<?> type) {
        return context.getBeanNamesForType(type);
    }

    /**
     * 获取指定类型的所有bean名称 <br>
     */
    public static String[] getBeanNamesForType(Class<?> type, boolean includeNonSingletons, boolean allowEagerInit) {
        return context.getBeanNamesForType(type, includeNonSingletons, allowEagerInit);
    }

    /**
     * 获取指定类型的所有bean <br>
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> type) {
        return context.getBeansOfType(type);
    }

    /**
     * 获取指定类型的所有bean <br>
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> type, boolean includeNonSingletons, boolean allowEagerInit) {
        return context.getBeansOfType(type, includeNonSingletons, allowEagerInit);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
