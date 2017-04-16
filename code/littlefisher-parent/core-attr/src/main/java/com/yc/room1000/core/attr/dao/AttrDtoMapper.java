package com.yc.room1000.core.attr.dao;

import java.util.List;

import com.yc.room1000.core.attr.dto.AttrDto;
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
public interface AttrDtoMapper extends SuperMapper {
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
    int insert(AttrDto record);

    /**
     * Description: insertSelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int insertSelective(AttrDto record);

    /**
     * Description: selectByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param id id
     * @return AttrDto AttrDto<br>
     * @mbg.generated
     */
    AttrDto selectByPrimaryKey(Long id);
    
    /**
     * 
     * Description: selectByCode<br>
     * 
     * @author jinyanan<br>
     *
     * @param code code
     * @return AttrDto<br>
     */
    AttrDto selectByCode(String code);

    /**
     * Description: updateByPrimaryKeySelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AttrDto record);

    /**
     * Description: updateByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     * @mbg.generated
     */
    int updateByPrimaryKey(AttrDto record);

    /**
     * 
     * Description: selectAllAttr
     * 
     * @author jinyanan
     *
     * @return List<AttrDto>
     */
    List<AttrDto> selectAllAttr();
}