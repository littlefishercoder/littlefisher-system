package com.yc.room1000.engine.attr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.engine.attr.model.AttrDto;
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
@RequestMapping(value = "api/engine/vi/attrs")
@Api(value = "attr", description = "attr 接口API")
public class AttrController {

    /**
     * attrService
     */
    @Autowired
    private IAttrService attrService;
    
    /**
     * 
     * Description: 获取所有attr
     * 
     * @author jinyanan
     *
     * @return List<AttrDto>
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "获取所有attr")
    public List<AttrDto> getAllAttr() throws BaseAppException {
        return attrService.getAllAttr();
    }
}
