package com.yc.room1000.engine.attr.service;

import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.engine.attr.model.AttrDto;
import com.yc.room1000.engine.attr.model.QryAttrListRequest;
import com.yc.room1000.engine.attr.model.QryAttrPagerListRequest;

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

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param attrId attrId
     * @return AttrDto
     * @throws BaseAppException <br>
     */
    AttrDto getAttrById(Long attrId) throws BaseAppException;

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param qryAttrListRequest qryAttrListRequest
     * @return List<AttrDto
     * @throws BaseAppException <br>
     */
    List<AttrDto> getAttrListByCond(QryAttrListRequest qryAttrListRequest) throws BaseAppException;

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param qryAttrPagerListRequest qryAttrPagerListRequest
     * @return List<AttrDto>
     * @throws BaseAppException <br>
     */
    List<AttrDto> getAttrPagerListByCond(QryAttrPagerListRequest qryAttrPagerListRequest) throws BaseAppException;

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param attrDto attrDto
     * @return AttrDto
     * @throws BaseAppException <br>
     */
    AttrDto addAttr(AttrDto attrDto) throws BaseAppException;
}
