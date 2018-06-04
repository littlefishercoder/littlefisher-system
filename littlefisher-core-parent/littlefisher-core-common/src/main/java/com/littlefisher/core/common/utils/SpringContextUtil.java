package com.littlefisher.core.common.utils;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
     * 从文件系统初始化
     * 
     * @param filePath 类路径
     */
    public static void initFromFile(String... filePath) {
        try {
            new FileSystemXmlApplicationContext(filePath);
        } catch (BeansException e) {
            ExceptionHandler.publish("CORE-000002", null, e);
        }
    }

    /**
     * 从classpath初始化
     * 
     * @param classpath classpath路径
     */
    public static void initFromClasspath(String... classpath) {
        try {
            new ClassPathXmlApplicationContext(classpath);
        } catch (BeansException e) {
            ExceptionHandler.publish("CORE-000002", null, e);
        }
    }

    /**
     * 获取bean
     * 
     * @param beanClass bean的Class
     * @param <T> 泛型
     * @return Bean
     */
    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    /**
     * 校验bean是否存在
     * 
     * @param beanClass clazz
     * @return 是否存在
     */
    public static Boolean existBean(Class<?> beanClass) {
        try {
            context.getBean(beanClass);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 获取bean类
     * 
     * @param beanName bean名称
     * @return Bean
     */
    public static Class<?> getBeanClass(String beanName) {
        return context.getType(beanName);
    }

    /**
     * 获取指定类型的所有bean名称
     * 
     * @param type class类型
     * @return 指定类型的所有bean名称
     */
    public static String[] getBeanNamesForType(Class<?> type) {
        return context.getBeanNamesForType(type);
    }

    /**
     * 获取指定类型的所有bean名称
     * 
     * @param type 类型
     * @param includeNonSingletons 是否仅单例Bean
     * @param allowEagerInit 是否提前初始化bean
     * @return 指定类型的所有bean名称
     */
    public static String[] getBeanNamesForType(Class<?> type, boolean includeNonSingletons, boolean allowEagerInit) {
        return context.getBeanNamesForType(type, includeNonSingletons, allowEagerInit);
    }

    /**
     * 获取指定类型的所有bean
     * 
     * @param type 类型
     * @param <T> 泛型
     * @return 指定类型的所有bean，Map形式
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> type) {
        return context.getBeansOfType(type);
    }

    /**
     * 获取指定类型的所有bean
     *
     * @param type 类型
     * @param includeNonSingletons 是否仅单例Bean
     * @param allowEagerInit 是否提前初始化bean
     * @param <T> 泛型
     * @return 指定类型的所有bean，Map形式
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> type, boolean includeNonSingletons,
        boolean allowEagerInit) {
        return context.getBeansOfType(type, includeNonSingletons, allowEagerInit);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
