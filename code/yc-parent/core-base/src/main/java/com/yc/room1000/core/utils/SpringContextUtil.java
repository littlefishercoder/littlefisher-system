package com.yc.room1000.core.utils;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.yc.room1000.core.exception.BaseAppException;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月18日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Component("CORE.SpringContextUtil")
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
     * 
     * 从文件系统初始化 <br> 
     *  
     * @author Qcwc<br>
     * @taskId <br>
     * @param filePaths <br>
     * @throws BaseAppException <br>
     */
    @SuppressWarnings("resource")
    public static void initFromFile(String... filePaths) throws BaseAppException {
        try {
            new FileSystemXmlApplicationContext(filePaths);
        }
        catch (BeansException e) {
            throw ExceptionHandler.publish("", e);
        }
    }
    
    /**
     * 
     * 从classpath初始化 <br> 
     *  
     * @author Qcwc<br>
     * @taskId <br>
     * @param classpaths <br>
     * @throws BaseAppException <br>
     */
    @SuppressWarnings("resource")
    public static void initFromClasspath(String... classpaths) throws BaseAppException {
        try {
            new ClassPathXmlApplicationContext(classpaths);
        }
        catch (BeansException e) {
            throw ExceptionHandler.publish("S-CRMCOM-037", e);
        }     
    }
    
    /**
     * 
     * 获取bean <br> 
     *  
     * @author Qcwc<br>
     * @taskId <br>
     * @param <T> <br>
     * @param beanName <br>
     * @return T <br>
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) {
        return (T) context.getBean(beanName);
    }
    
    /**
     * 
     * 获取bean <br> 
     *  
     * @author Qcwc<br>
     * @taskId <br>
     * @param <T> <br>
     * @param beanClass <br>
     * @return T <br>
     */
    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
    
    /**
     * 
     * 获取bean类 <br> 
     *  
     * @author Qcwc<br>
     * @taskId <br>
     * @param beanName <br>
     * @return Class<T> <br>
     */
    public static Class<?> getBeanClass(String beanName) {
        return context.getType(beanName);
    }
    
    /**
     * 
     * 获取指定类型的所有bean名称 <br> 
     *  
     * @author Qcwc<br>
     * @taskId <br>
     * @param type <br>
     * @return <br>
     */
    public static String[] getBeanNamesForType(Class<?> type) {
        return context.getBeanNamesForType(type);
    }
    
    /**
     * 
     * 获取指定类型的所有bean名称 <br> 
     *  
     * @author Qcwc<br>
     * @taskId <br>
     * @param type <br>
     * @param includeNonSingletons <br>
     * @param allowEagerInit <br>
     * @return <br>
     */
    public static String[] getBeanNamesForType(Class<?> type, boolean includeNonSingletons, boolean allowEagerInit) {
        return context.getBeanNamesForType(type, includeNonSingletons, allowEagerInit);
    }
    
    /**
     * 
     * 获取指定类型的所有bean <br> 
     *  
     * @author Qcwc<br>
     * @taskId <br>
     * @param <T> <br>
     * @param type <br>
     * @return <br>
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> type) {
        return context.getBeansOfType(type);
    }
    
    /**
     * 
     * 获取指定类型的所有bean <br> 
     *  
     * @author Qcwc<br>
     * @taskId <br>
     * @param <T> <br>
     * @param type <br>
     * @param includeNonSingletons <br>
     * @param allowEagerInit <br>
     * @return <br>
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> type, boolean includeNonSingletons, boolean allowEagerInit) {
        return context.getBeansOfType(type, includeNonSingletons, allowEagerInit);
    }
    
    @SuppressWarnings("static-access")
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

}
