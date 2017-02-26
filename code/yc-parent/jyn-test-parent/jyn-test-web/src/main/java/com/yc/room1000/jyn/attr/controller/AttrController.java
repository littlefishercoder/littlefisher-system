package com.yc.room1000.jyn.attr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.jyn.attr.model.AttrDto;
import com.yc.room1000.jyn.attr.model.QryAttrListRequest;
import com.yc.room1000.jyn.attr.service.IAttrService;


/**
 * 
 * Description: 
 *  
 * Created on 2017年1月24日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Api(value = "attr", description = "attr 接口API")
@RestController
@RequestMapping("/api/v1/jyn/attr")
public class AttrController {
    
    /**
     * attrService
     */
    @Autowired
    public IAttrService attrService;
    
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
    @RequestMapping(value = "/{attrId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据attrId获取Attr")
    public AttrDto getAttrById(@ApiParam(required = true, value = "attrId") @PathVariable("attrId") Long attrId) throws BaseAppException {
        AttrDto attr = attrService.qryAttrById(attrId);
        return attr;
    }
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return List<AttrDto>
     * @throws BaseAppException 
     */
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    @ApiOperation(value = "查询所有Attr")
//    public List<AttrDto> getAllAttr() throws BaseAppException {
//        List<AttrDto> attrList = attrService.qryAllAttr();
//        return attrList;
//    }
    
    /**
     * 
     * Description: 根据条件查询Attr列表
     * 
     * @author jinyanan
     *
     * @param qryAttrListRequest qryAttrListRequest
     * @return PageInfo<AttrDto>
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "根据条件查询Attr列表")
    public PageInfo<AttrDto> getAttrByConf(
        @ApiParam(required = true, value = "qryAttrListRequest") @RequestBody QryAttrListRequest qryAttrListRequest) throws BaseAppException {
        List<AttrDto> attrList =  attrService.getAttrByConf(qryAttrListRequest);
        PageInfo<AttrDto> pageInfo = new PageInfo<AttrDto>(attrList);
        return pageInfo;
    }
    
}
