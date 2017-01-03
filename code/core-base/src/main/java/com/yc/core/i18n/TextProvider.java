package com.yc.core.i18n;

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
     * Description: 根据key获取资源信息，如果获取不到，则使用传入默认值
     * 
     * @author jinyanan
     *
     * @param key key
     * @param defaultValue 默认信息
     * @return String
     */
    String getText(String key, String defaultValue);
}
