package com.yc.room1000.engine.attr.controller;


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
import com.yc.room1000.engine.attr.model.AttrDto;
import com.yc.room1000.engine.attr.model.QryAttrListRequest;
import com.yc.room1000.engine.attr.model.QryAttrPagerListRequest;
import com.yc.room1000.engine.attr.service.IAttrService;

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
@RestController
@RequestMapping(value = "api/engine/v1/attrs")
@Api(value = "attr", description = "attr 接口API")
public class AttrController {

    /**
     * attrService
     */
    @Autowired
    private IAttrService attrService;
    
    /**
     * 
     * Description: 根据attrId查询对应Attr
     * 
     * @author jinyanan
     *
     * @param attrId attrId
     * @return AttrDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/{attrId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据attrId查询对应Attr")
    public AttrDto getAttrById(
        @ApiParam(required = true, value = "属性主键") @PathVariable(value = "attrId") Long attrId) throws BaseAppException {
        return attrService.getAttrById(attrId);
    }
    
    /**
     * 
     * Description: 根据传入条件查询Attr列表
     * 
     * @author jinyanan
     *
     * @param qryAttrListRequest qryAttrListRequest
     * @return List<AttrDto>
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "根据传入条件查询Attr列表")
    public List<AttrDto> getAttrListByCond(
        @ApiParam(required = true, value = "查询Attr列表的条件") @ModelAttribute QryAttrListRequest qryAttrListRequest) throws BaseAppException {
        return attrService.getAttrListByCond(qryAttrListRequest);
    }
    
    /**
     * 
     * Description: 根据传入条件查询Attr列表，分页用
     * 
     * @author jinyanan
     *
     * @param qryAttrPagerListRequest qryAttrPagerListRequest
     * @return PageInfo<AttrDto>
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/pager", method = RequestMethod.GET)
    @ApiOperation(value = "根据传入条件查询Attr列表，分页用")
    public PageInfo<AttrDto> getAttrPagerListByCond(
        @ApiParam(required = true, value = "查询Attr列表的条件, 分页用") 
        @ModelAttribute QryAttrPagerListRequest qryAttrPagerListRequest) throws BaseAppException {
        List<AttrDto> attrList = attrService.getAttrPagerListByCond(qryAttrPagerListRequest);
        PageInfo<AttrDto> pageInfo = new PageInfo<>(attrList);
        return pageInfo;
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
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "新增Attr")
    public AttrDto addAttr(@RequestBody AttrDto attrDto) throws BaseAppException {
        return attrService.addAttr(attrDto);
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
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation(value = "修改Attr")
    public AttrDto updateAttr(@RequestBody AttrDto attrDto) throws BaseAppException {
        return attrService.updateAttr(attrDto);
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
    @RequestMapping(value = "/{attrId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除Attr")
    public int deleteAttr(
        @ApiParam(required = true, value = "属性主键") @PathVariable("attrId") Long attrId) throws BaseAppException {
        return attrService.deleteAttr(attrId);
    }
}
