package com.yc.room1000.core.attr.dao;

import java.util.List;

import com.yc.room1000.core.attr.dto.AttrValueDto;
import com.yc.room1000.core.mybatis.SuperMapper;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月17日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface AttrValueDtoMapper extends SuperMapper {
    /**
     * Description: deleteByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param id id
     * @return int int<br>
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * Description: insert<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int insert(AttrValueDto record);

    /**
     * Description: insertSelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int insertSelective(AttrValueDto record);

    /**
     * Description: selectByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param id id
     * @return AttrValueDto AttrValueDto<br>
     * @mbg.generated
     */
    AttrValueDto selectByPrimaryKey(Long id);
    
    /**
     * 
     * Description: selectAttrValueListByAttrId
     * 
     * @author jinyanan
     *
     * @param attrId attrId
     * @return List<AttrValueDto>
     */
    List<AttrValueDto> selectAttrValueListByAttrId(Long attrId);

    /**
     * Description: updateByPrimaryKeySelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AttrValueDto record);

    /**
     * Description: updateByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int updateByPrimaryKey(AttrValueDto record);
}