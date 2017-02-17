package com.yc.room1000.core.engine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.room1000.core.utils.Room1000Logger;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月17日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class BeanFactory {
    
    /**
     * logger
     */
    private static Room1000Logger logger = Room1000Logger.getLogger(BeanFactory.class);
    
    /**
     * context
     */
    private static ApplicationContext context;

    static {
        try {
            context = new ClassPathXmlApplicationContext("classpath*:spring/EngineConfig.xml");
        }
        catch (Exception e) {
            logger.error("BeanFactory init error", e);
        }
    }
    
    /**
     * BeanFactory
     */
    private BeanFactory() {
    }
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param name name
     * @return Object
     */
    public static Object getBean(String name) {
        return context.getBean(name);
    }
}
