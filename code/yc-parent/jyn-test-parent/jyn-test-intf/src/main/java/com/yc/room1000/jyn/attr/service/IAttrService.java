package com.yc.room1000.jyn.attr.service;

import java.util.List;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.jyn.attr.model.AttrDto;
import com.yc.room1000.jyn.attr.model.QryAttrListRequest;
import com.yc.room1000.jyn.attr.model.QryAttrPagerListRequest;

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
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param attrIds attrIds
     * @return List<AttrDto>
     * @throws BaseAppException <br>
     */
    List<AttrDto> qryAttrByIds(String attrIds) throws BaseAppException;

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
    List<AttrDto> getAttrPagerByConf(QryAttrPagerListRequest qryAttrPagerListRequest) throws BaseAppException;

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
    AttrDto updateAttr(AttrDto attrDto) throws BaseAppException;

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param attrId attrId
     * @return int
     * @throws BaseAppException <br>
     */
    int deleteAttrById(Long attrId) throws BaseAppException;

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param attrName attrName
     * @return AttrDto
     * @throws BaseAppException <br>
     */
    AttrDto getAttrByName(String attrName) throws BaseAppException;

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @param qryAttrListRequest qryAttrListRequest
     * @return List<AttrDto>
     * @throws BaseAppException <br>
     */
    List<AttrDto> getAttrByConf(QryAttrListRequest qryAttrListRequest) throws BaseAppException;
}
