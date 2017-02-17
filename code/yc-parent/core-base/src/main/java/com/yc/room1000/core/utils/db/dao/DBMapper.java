package com.yc.room1000.core.utils.db.dao;

import java.util.Date;

import com.yc.room1000.core.mybatis.SuperMapper;

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
public interface DBMapper extends SuperMapper {

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
