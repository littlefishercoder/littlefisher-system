package com.yc.room1000.engine.attr.service;

import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.engine.attr.model.AttrDto;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月28日 
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
     * @throws BaseAppException <br>
     */
    List<AttrDto> getAllAttr() throws BaseAppException;
}
