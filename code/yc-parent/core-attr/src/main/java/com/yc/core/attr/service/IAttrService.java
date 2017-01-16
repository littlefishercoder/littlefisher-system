package com.yc.core.attr.service;

import com.yc.core.attr.dto.AttrDto;

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
     * Description: 
     * 
     * @author jinyanan
     *
     * @param attrId attrId
     * @return AttrDto
     */
    AttrDto getAttrDtoById(Long attrId);
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param attrCode attrCode
     * @return AttrDto
     */
//    AttrDto getAttrDtoByCode(String attrCode);
    
}
