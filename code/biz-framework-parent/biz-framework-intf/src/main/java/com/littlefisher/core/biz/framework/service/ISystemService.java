package com.littlefisher.core.biz.framework.service;

import java.util.Properties;

/**
 * Description: ISystemService.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ISystemService {

    /**
     * 刷新Resource文件
     */
    void refreshResource();

    /**
     * 查询Resource
     * @param dialect 方言
     * @return Resource
     */
    Properties getResource(String dialect);
}
