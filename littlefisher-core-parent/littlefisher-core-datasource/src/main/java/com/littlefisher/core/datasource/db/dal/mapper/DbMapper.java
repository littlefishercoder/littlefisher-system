package com.littlefisher.core.datasource.db.dal.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Select;

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
public interface DbMapper {

    /**
     * 
     * Description: 获取数据库当前时间
     * 
     * @author jinyanan
     *
     * @return Date
     */
    @Select("SELECT CURRENT_TIMESTAMP()")
    Date getDBDateTime();
}
