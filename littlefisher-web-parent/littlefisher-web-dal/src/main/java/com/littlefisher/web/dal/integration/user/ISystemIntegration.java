package com.littlefisher.web.dal.integration.user;

import java.util.Map;

/**
 * Description: ISystemIntegration.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ISystemIntegration {

    /**
     * 刷新Resource文件
     */
    void refreshResource();

    /**
     * 查询Resource
     *
     * @param dialect 方言
     * @return Resource
     */
    Map<Object, Object> getResource(String dialect);
}
