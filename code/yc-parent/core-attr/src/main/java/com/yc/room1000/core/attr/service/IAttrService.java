package com.yc.room1000.core.attr.service;

import com.yc.room1000.core.attr.dto.AttrDto;

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
public interface IAttrService {

    /**
     * 
     * Description: 根据attrId查询AttrDto
     * 
     * @author jinyanan
     *
     * @param attrId attrId
     * @return AttrDto
     */
    AttrDto getAttrDtoById(Long attrId);
    
    /**
     * 
     * Description: 根据attrCode查询AttrDto
     * 
     * @author jinyanan
     *
     * @param attrCode attrCode
     * @return AttrDto
     */
    AttrDto getAttrDtoByCode(String attrCode);
    
    /**
     * 
     * Description: 新增AttrDto
     * 
     * @author jinyanan
     *
     * @param attrDto attrDto
     * @return int
     */
    int addAttrDto(AttrDto attrDto);
    
    /**
     * 
     * Description: 更新AttrDto
     * 
     * @author jinyanan
     *
     * @param attrDto attrDto
     * @return int
     */
    int updateAttrDto(AttrDto attrDto);
    
    /**
     * 
     * Description: 根据attrId删除AttrDto。删除逻辑为逻辑删除，即修改STATE字段
     * 
     * @author jinyanan
     *
     * @param attrId attrId
     * @return int
     */
    int deleteAttrDtoById(Long attrId);
    
    /**
     * 
     * Description: 根据attrCode删除AttrDto。删除逻辑为逻辑删除，即修改STATE字段
     * 
     * @author jinyanan
     *
     * @param attrCode attrCode
     * @return int
     */
    int deleteAttrDtoByCode(String attrCode);
    
    /**
     * 
     * Description: 把AttrDto绑定到AttrCatgDto上
     * 
     * @author jinyanan
     *
     * @param attrId attrId
     * @param attrCatgId attrCatgId
     */
    void bindAttrCatg(Long attrId, Long attrCatgId);
    
    /**
     * 
     * Description: 把AttrDto和AttrCatgDto进行解绑。逻辑解绑，把STATE置为失效
     * 
     * @author jinyanan
     *
     * @param attrId attrId
     * @param attrCatgId attrCatgId
     */
    void unbindAttrCatg(Long attrId, Long attrCatgId);
}
