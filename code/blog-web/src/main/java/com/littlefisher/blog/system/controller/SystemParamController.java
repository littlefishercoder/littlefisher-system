package com.littlefisher.blog.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.littlefisher.blog.system.model.SystemParamDto;
import com.littlefisher.blog.system.model.request.GetSystemParamList4PagerByCondRequest;
import com.littlefisher.blog.system.service.ISystemParamService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Description: 系统信息Controller
 *  
 * Created on 2017年5月22日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping("/api/blog/v1/system/systemParam")
@Api(value = "systemParam", description = "systemParam 接口API")
public class SystemParamController {

    /**
     * systemParamService
     */
    @Autowired
    private ISystemParamService systemParamService;
    
    /**
     * 
     * Description: 根据条件查询分页列表
     * 
     * @author jinyanan
     *
     * @param req req
     * @return PageInfo<SystemParamDto>
     */
    @RequestMapping(value = "/pager", method = RequestMethod.GET)
    @ApiOperation(value = "根据条件查询分页列表")
    public PageInfo<SystemParamDto> getSystemParamList4PagerByCond(
        @ApiParam(value = "查询系统参数列表条件") @RequestBody GetSystemParamList4PagerByCondRequest req) {
        return null;
    }
    
    /**
     * 
     * Description: 根据key查询系统参数
     * 
     * @author jinyanan
     *
     * @param paramKey paramKey
     * @return SystemParamDto
     */
    @RequestMapping(value = "/{paramKey}", method = RequestMethod.GET)
    @ApiOperation(value = "根据key查询系统参数")
    public SystemParamDto getSystemParamByKey(
        @ApiParam(required = true, value = "系统参数key值") @PathVariable("paramKey") String paramKey) {
        return null;
    }
    
    /**
     * 
     * Description: 新增系统参数
     * 
     * @author jinyanan
     *
     * @param systemParamDto systemParamDto
     * @return SystemParamDto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiParam(value = "新增系统参数")
    public SystemParamDto addSystemParam(
        @ApiParam(required = true, value = "系统参数信息") @RequestBody SystemParamDto systemParamDto) {
        return null;
    }
    
    /**
     * 
     * Description: 删除系统参数
     * 
     * @author jinyanan
     *
     * @param paramKey paramKey
     * @return int
     */
    @RequestMapping(value = "/{paramKey}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除系统参数")
    public int deleteSystemParamByKey(
        @ApiParam(required = true, value = "系统参数key值") @PathVariable("paramKey") String paramKey) {
        return 0;
    }
    
    /**
     * 
     * Description: 修改系统参数
     * 
     * @author jinyanan
     *
     * @param systemParamDto systemParamDto
     * @return SystemParamDto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "修改系统参数")
    public SystemParamDto updateSystemParam(
        @ApiParam(required = true, value = "系统参数信息") @RequestBody SystemParamDto systemParamDto) {
        return null;
    }
}
