package com.yc.room1000.attr.service;

import java.util.List;

import com.yc.room1000.attr.dto.AttrDto;
import com.yc.room1000.core.exception.BaseAppException;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月11日 
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
     * @return List<AttrDto>
     */
    List<AttrDto> selectAll();
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param attrId attrId
     * @return AttrDto
     * @exception BaseAppException 
     */
    AttrDto selectById(Long attrId) throws BaseAppException;
}
