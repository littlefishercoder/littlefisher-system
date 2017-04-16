package com.yc.room1000.jyn.attr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.yc.room1000.jyn.attr.model.QryAttrPagerListRequest;
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
@RequestMapping("/api/v1/jyn/attrs")
public class AttrController {
    
    /**
     * attrService
     */
    @Autowired
    public IAttrService attrService;
    
    /**
     * 
     * Description: 根据attrId查询唯一Attr，其中attrId是在url中附带的
     * 
     * @author jinyanan
     *
     * @param attrId attrId
     * @return AttrDto
     * @throws BaseAppException 
     */
    @RequestMapping(value = "/{attrId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据attrId获取Attr")
    public AttrDto getAttrById(
        @ApiParam(required = true, value = "attrId") @PathVariable("attrId") Long attrId) throws BaseAppException {
        AttrDto attr = attrService.qryAttrById(attrId);
        return attr;
    }
    
    /**
     * 
     * Description: 根据条件查询Attr列表，其中包括分页逻辑，由于Controller入参中带有实体，所以有以下解决方案
     * 1、使用POST请求，对入参实体加@RequestBody注解
     * 2、还是使用GET请求，具体的入参放入url里的?后，例如：/api/v1/attr?pageNum=1&pageSize=20，同时实体上加上@ModelAttribute注解
     * 
     * 该Controller使用第二种方案
     * 
     * @author jinyanan
     *
     * @param qryAttrPagerListRequest qryAttrPagerListRequest
     * @return PageInfo<AttrDto>
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/pager", method = RequestMethod.GET)
    @ApiOperation(value = "根据条件查询Attr列表，使用分页")
    public PageInfo<AttrDto> getAttrPagerListByConf(
        @ApiParam(required = true, value = "qryAttrPagerListRequest") 
        @ModelAttribute QryAttrPagerListRequest qryAttrPagerListRequest) throws BaseAppException {
//        List<AttrDto> attrList =  attrService.getAttrPagerByConf(qryAttrPagerListRequest);
//        PageInfo<AttrDto> pageInfo = new PageInfo<AttrDto>(attrList);
//        return pageInfo;
        return null;
    }
    
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
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "根据条件查询Attr列表")
    public List<AttrDto> getAttrListByConf(
        @ApiParam(required = true, value = "qryAttrListRequest") @ModelAttribute QryAttrListRequest qryAttrListRequest) throws BaseAppException {
//        return attrService.getAttrByConf(qryAttrListRequest);
        return null;
    }
    
    /**
     * 
     * Description: 新增Attr
     * 
     * @author jinyanan
     *
     * @param attrDto attrDto
     * @return AttrDto
     * @throws BaseAppException <br>
     */
    @ApiOperation(value = "新增Attr")
    @RequestMapping(method = RequestMethod.POST)
    public AttrDto addAttr(@RequestBody AttrDto attrDto) throws BaseAppException {
//        return attrService.addAttr(attrDto);
        return null;
    }
    
    /**
     * 
     * Description: 修改Attr
     * 
     * @author jinyanan
     *
     * @param attrDto attrDto
     * @return AttrDto
     * @throws BaseAppException <br>
     */
    @ApiOperation(value = "修改Attr")
    @RequestMapping(method = RequestMethod.PATCH)
    public AttrDto updateAttr(@RequestBody AttrDto attrDto) throws BaseAppException {
//        return attrService.updateAttr(attrDto);
        return null;
    }
    
    /**
     * 
     * Description: 删除Attr
     * 
     * @author jinyanan
     *
     * @param attrId attrId
     * @return int
     * @throws BaseAppException <br>
     */
    @ApiOperation(value = "删除Attr")
    @RequestMapping(value = "/{attrId}", method = RequestMethod.DELETE)
    public int deleteAttr(
        @ApiParam(required = true, value = "attrId") @PathVariable("attrId") Long attrId) throws BaseAppException {
//        return attrService.deleteAttrById(attrId);
        return 0;
    }
    
    
    
}
