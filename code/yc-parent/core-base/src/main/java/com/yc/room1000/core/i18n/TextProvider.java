package com.yc.room1000.core.i18n;

/**
 * 
 * Description: 消息提供者,供各种资源消息来源继承
 *  
 * Created on 2017年1月3日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface TextProvider {

    /**
     * 
     * Description: 根据key获取资源信息
     * 
     * @author jinyanan
     *
     * @param key key
     * @return String
     */
    String getText(String key);
    
    /**
     * 
     * Description: 根据local方言和key获取资源信息
     * 
     * @author jinyanan
     *
     * @param dialect 方言
     * @param key key
     * @return String
     */
    String getText(String dialect, String key);
}
