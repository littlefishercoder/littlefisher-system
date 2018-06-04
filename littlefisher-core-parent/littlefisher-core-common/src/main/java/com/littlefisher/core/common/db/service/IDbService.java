package com.littlefisher.core.common.db.service;

import java.util.Date;

/**
 * Description: IDbService.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IDbService {

    /**
     * 获取数据库当前时间
     * @return 时间
     */
    Date getDBDateTime();
}
