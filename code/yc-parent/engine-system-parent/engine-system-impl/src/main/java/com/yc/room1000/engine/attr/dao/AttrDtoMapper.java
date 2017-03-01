package com.yc.room1000.engine.attr.dao;

import java.util.List;

import com.yc.room1000.core.mybatis.SuperMapper;
import com.yc.room1000.engine.attr.model.AttrDto;
import com.yc.room1000.engine.attr.model.QryAttrListRequest;

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
public interface AttrDtoMapper extends SuperMapper {
    /**
     * Description: deleteByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param id id
     * @return int int<br>
     */
    int deleteByPrimaryKey(Long id);

    /**
     * Description: insert<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     */
    int insert(AttrDto record);

    /**
     * Description: insertSelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     */
    int insertSelective(AttrDto record);

    /**
     * Description: selectByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param id id
     * @return AttrDto AttrDto<br>
     */
    AttrDto selectByPrimaryKey(Long id);

    /**
     * Description: updateByPrimaryKeySelective<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     */
    int updateByPrimaryKeySelective(AttrDto record);

    /**
     * Description: updateByPrimaryKey<br>
     *
     * @author jinyanan <br>
     * @param record record
     * @return int int<br>
     */
    int updateByPrimaryKey(AttrDto record);
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return List<AttrDto> <br>
     */
    List<AttrDto> selectAll();

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param qryAttrListRequest qryAttrListRequest
     * @return List<AttrDto> <br>
     */
    List<AttrDto> selectByCond(QryAttrListRequest qryAttrListRequest);
}