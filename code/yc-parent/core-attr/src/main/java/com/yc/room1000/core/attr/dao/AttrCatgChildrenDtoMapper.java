package com.yc.room1000.core.attr.dao;

import com.yc.room1000.core.attr.dto.AttrCatgChildrenDto;
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
public interface AttrCatgChildrenDtoMapper extends SuperMapper {
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
    int insert(AttrCatgChildrenDto record);

    /**
     * Description: insertSelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int insertSelective(AttrCatgChildrenDto record);

    /**
     * Description: selectByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param id id
     * @return AttrCatgChildrenDto AttrCatgChildrenDto<br>
     * @mbg.generated
     */
    AttrCatgChildrenDto selectByPrimaryKey(Long id);
    
    /**
     * 
     * Description: selectSelective
     * 
     * @author jinyanan
     *
     * @param attrCatgChildrenDto attrCatgChildrenDto
     * @return AttrCatgChildrenDto
     */
    AttrCatgChildrenDto selectSelective(AttrCatgChildrenDto attrCatgChildrenDto);

    /**
     * Description: updateByPrimaryKeySelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AttrCatgChildrenDto record);

    /**
     * Description: updateByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int updateByPrimaryKey(AttrCatgChildrenDto record);
}