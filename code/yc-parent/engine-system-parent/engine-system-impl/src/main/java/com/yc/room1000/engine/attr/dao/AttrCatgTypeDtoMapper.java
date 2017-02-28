package com.yc.room1000.engine.attr.dao;

import com.yc.room1000.core.mybatis.SuperMapper;
import com.yc.room1000.engine.attr.model.AttrCatgTypeDto;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月28日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface AttrCatgTypeDtoMapper extends SuperMapper {
    /**
     * Description: deleteByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param type type
     * @return int int<br>
     */
    int deleteByPrimaryKey(String type);

    /**
     * Description: insert<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     */
    int insert(AttrCatgTypeDto record);

    /**
     * Description: insertSelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     */
    int insertSelective(AttrCatgTypeDto record);

    /**
     * Description: selectByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param type type
     * @return AttrCatgTypeDto AttrCatgTypeDto<br>
     */
    AttrCatgTypeDto selectByPrimaryKey(String type);

    /**
     * Description: updateByPrimaryKeySelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     */
    int updateByPrimaryKeySelective(AttrCatgTypeDto record);

    /**
     * Description: updateByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     */
    int updateByPrimaryKey(AttrCatgTypeDto record);
}