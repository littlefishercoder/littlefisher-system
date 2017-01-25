package com.yc.room1000.jyn.attr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import com.yc.room1000.core.attr.dto.AttrDto;
import com.yc.room1000.core.attr.service.IAttrService;

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
     */
    @RequestMapping(value = "/{attrId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据attrId获取Attr")
    public AttrDto getAttrById(@PathVariable("attrId") Long attrId) {
        AttrDto attr = attrService.getAttrDtoById(attrId);
        return attr;
    }
}
