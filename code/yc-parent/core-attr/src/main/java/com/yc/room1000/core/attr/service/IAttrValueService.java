package com.yc.room1000.core.attr.service;

import java.util.List;

import com.yc.room1000.core.attr.dto.AttrValueDto;

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
public interface IAttrValueService {
    
    /**
     * 
     * Description: 根据attrId查询可选项
     * 
     * @author jinyanan
     *
     * @param attrId attrId
     * @return List<AttrValueDto>
     */
    List<AttrValueDto> getAttrValueDtoByAttrId(Long attrId);

    /**
     * 
     * Description: 根据attrCode查询可选项
     * 
     * @author jinyanan
     *
     * @param attrCode attrCode
     * @return List<AttrValueDto>
     */
    List<AttrValueDto> getAttrValueDtoByAttrCode(String attrCode);

    /**
     * 
     * Description: 增加可选项，如果优先级为null，默认在最后
     * 
     * @author jinyanan
     *
     * @param attrValueDto attrValueDto
     * @return int
     */
    int addAttrValueDto(AttrValueDto attrValueDto);

    /**
     * 
     * Description: 更新可选项
     * 
     * @author jinyanan
     *
     * @param attrValueDto attrValueDto
     * @return int
     */
    int updateAttrValueDto(AttrValueDto attrValueDto);

    /**
     * 
     * Description: 删除可选项
     * 
     * @author jinyanan
     *
     * @param attrValueId attrValueId
     * @return int
     */
    int deleteAttrValueDto(Long attrValueId);

    /**
     * 
     * Description: 提高一个优先级
     * 
     * @author jinyanan
     *
     * @param attrValueId attrValueId
     */
    void increasePriority(Long attrValueId);

    /**
     * 
     * Description: 降低一个优先级
     * 
     * @author jinyanan
     *
     * @param attrValueId attrValueId
     */
    void decreasePriority(Long attrValueId);
}
