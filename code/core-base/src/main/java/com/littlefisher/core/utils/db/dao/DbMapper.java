package com.littlefisher.core.utils.db.dao;

import java.util.Date;

import com.littlefisher.core.mybatis.SuperMapper;

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
public interface DbMapper extends SuperMapper {

    /**
     * 
     * Description: 获取数据库当前时间
     * 
     * @author jinyanan
     *
     * @return Date
     */
    Date getDBDateTime();
}
