package com.yc.room1000.core.attr.dao;

import com.yc.room1000.core.attr.dto.AttrTypeDto;
import com.yc.room1000.core.mybaits.SuperMapper;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月16日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface AttrTypeDtoMapper extends SuperMapper {
    /**
     * Description: deleteByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param type type
     * @return int int<br>
     * @mbg.generated
     */
    int deleteByPrimaryKey(String type);

    /**
     * Description: insert<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int insert(AttrTypeDto record);

    /**
     * Description: insertSelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int insertSelective(AttrTypeDto record);

    /**
     * Description: selectByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param type type
     * @return AttrTypeDto AttrTypeDto<br>
     * @mbg.generated
     */
    AttrTypeDto selectByPrimaryKey(String type);

    /**
     * Description: updateByPrimaryKeySelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AttrTypeDto record);

    /**
     * Description: updateByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int updateByPrimaryKey(AttrTypeDto record);
}