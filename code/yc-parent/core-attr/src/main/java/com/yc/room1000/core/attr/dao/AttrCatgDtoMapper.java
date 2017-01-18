package com.yc.room1000.core.attr.dao;

import java.util.List;

import com.yc.room1000.core.attr.dto.AttrCatgDto;
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
public interface AttrCatgDtoMapper extends SuperMapper {
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
    int insert(AttrCatgDto record);

    /**
     * Description: insertSelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int insertSelective(AttrCatgDto record);

    /**
     * Description: selectByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param id id
     * @return AttrCatgDto AttrCatgDto<br>
     * @mbg.generated
     */
    AttrCatgDto selectByPrimaryKey(Long id);
    
    /**
     * 
     * Description: selectSelective
     * 
     * @author jinyanan
     *
     * @param record record
     * @return List<AttrCatgDto>
     */
    List<AttrCatgDto> selectSelective(AttrCatgDto record);
    
    /**
     * Description: updateByPrimaryKeySelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AttrCatgDto record);

    /**
     * Description: updateByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int updateByPrimaryKey(AttrCatgDto record);
}