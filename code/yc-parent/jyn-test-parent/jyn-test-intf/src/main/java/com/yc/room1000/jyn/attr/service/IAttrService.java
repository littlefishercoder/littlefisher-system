package com.yc.room1000.jyn.attr.service;

import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.jyn.attr.model.AttrDto;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月12日 
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
     * @throws BaseAppException 
     */
    AttrDto qryAttrById(Long attrId) throws BaseAppException;

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return List<AttrDto>
     * @throws BaseAppException 
     */
    List<AttrDto> qryAllAttr() throws BaseAppException;
}
