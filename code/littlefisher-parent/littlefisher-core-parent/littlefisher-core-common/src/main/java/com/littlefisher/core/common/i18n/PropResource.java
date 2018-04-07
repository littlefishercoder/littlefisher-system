package com.littlefisher.core.common.i18n;

import java.util.Properties;

public interface PropResource {

    /**
     * 初始化
     */
    void init();

    /**
     * 根据方言和key查找value
     * @param dialect 方言
     * @param key key
     * @return value
     */
    String getValue(String dialect, String key);

    /**
     * 根据方言查找所有的值
     * @param dialect 方言
     * @return 所有的value
     */
    Properties getResource(String dialect);
}
