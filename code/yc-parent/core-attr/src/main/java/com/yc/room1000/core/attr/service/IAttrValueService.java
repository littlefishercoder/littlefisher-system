package com.yc.room1000.core.attr.service;

import java.util.List;

import com.yc.room1000.core.attr.dto.AttrValueDto;
import com.yc.room1000.core.exception.BaseAppException;

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
     * @throws BaseAppException <br>
     */
    List<AttrValueDto> getAttrValueDtoListByAttrId(Long attrId) throws BaseAppException;
    
    /**
     * 
     * Description: 根据attrValueId查询可选项
     * 
     * @author jinyanan
     *
     * @param attrValueId attrValueId
     * @return AttrValueDto
     * @throws BaseAppException <br>
     */
    AttrValueDto getAttrValueDtoById(Long attrValueId) throws BaseAppException;

    /**
     * 
     * Description: 根据attrCode查询可选项
     * 
     * @author jinyanan
     *
     * @param attrCode attrCode
     * @return List<AttrValueDto>
     * @throws BaseAppException <br>
     */
    List<AttrValueDto> getAttrValueDtoListByAttrCode(String attrCode) throws BaseAppException;

    /**
     * 
     * Description: 增加可选项，如果优先级为null，默认在最后（前台无需管优先级，后台直接处理）
     * 
     * @author jinyanan
     *
     * @param attrValueDto attrValueDto
     * @return int
     * @throws BaseAppException <br>
     */
    int addAttrValueDto(AttrValueDto attrValueDto) throws BaseAppException;

    /**
     * 
     * Description: 更新可选项
     * 
     * @author jinyanan
     *
     * @param attrValueDto attrValueDto
     * @return int
     * @throws BaseAppException <br>
     */
    int updateAttrValueDto(AttrValueDto attrValueDto) throws BaseAppException;

    /**
     * 
     * Description: 删除可选项
     * 
     * @author jinyanan
     *
     * @param attrValueId attrValueId
     * @return int
     * @throws BaseAppException <br>
     */
    int deleteAttrValueDto(Long attrValueId) throws BaseAppException;

    /**
     * 
     * Description: 提高一个优先级
     * 
     * @author jinyanan
     *
     * @param attrValueId attrValueId
     * @throws BaseAppException <br>
     */
    void increasePriority(Long attrValueId) throws BaseAppException;

    /**
     * 
     * Description: 降低一个优先级
     * 
     * @author jinyanan
     *
     * @param attrValueId attrValueId
     * @throws BaseAppException <br>
     */
    void decreasePriority(Long attrValueId) throws BaseAppException;
}
