package com.yc.room1000.engine.attr.dao;

import com.yc.room1000.core.mybatis.SuperMapper;
import com.yc.room1000.engine.attr.model.UnitDto;

/**
 * 
 * Description: 
 *  
 * Created on 2017年3月1日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface UnitDtoMapper extends SuperMapper {
    /**
     * Description: deleteByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param unit unit
     * @return int int<br>
     */
    int deleteByPrimaryKey(Long unit);

    /**
     * Description: insert<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     */
    int insert(UnitDto record);

    /**
     * Description: insertSelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     */
    int insertSelective(UnitDto record);

    /**
     * Description: selectByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param unit unit
     * @return UnitDto UnitDto<br>
     */
    UnitDto selectByPrimaryKey(Long unit);

    /**
     * Description: updateByPrimaryKeySelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     */
    int updateByPrimaryKeySelective(UnitDto record);

    /**
     * Description: updateByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     */
    int updateByPrimaryKey(UnitDto record);
}