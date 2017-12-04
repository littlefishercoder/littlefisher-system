package com.littlefisher.blog.controller.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.littlefisher.blog.intf.system.ISystemParamService;
import com.littlefisher.blog.model.system.SystemParamDto;
import com.littlefisher.blog.request.system.GetSystemParamList4PagerByCondRequest;

/**
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
     * Description: 根据条件查询分页列表
     *
     * @param req req
     * @return PageInfo<SystemParamDto>
     */
    @RequestMapping(value = "/pager", method = RequestMethod.GET)
    @ApiOperation(value = "根据条件查询分页列表")
    public PageInfo<SystemParamDto> getSystemParamList4PagerByCond(
            @ApiParam(value = "查询系统参数列表条件") @ModelAttribute GetSystemParamList4PagerByCondRequest req) {
        List<SystemParamDto> systemParamList = systemParamService
                .getSystemParamList4PagerByCond(req);
        return new PageInfo<>(systemParamList);
    }

    /**
     * Description: 根据key查询系统参数
     *
     * @param paramKey paramKey
     * @return SystemParamDto
     */
    @RequestMapping(value = "/paramKey/{paramKey}", method = RequestMethod.GET)
    @ApiOperation(value = "根据key查询系统参数")
    public SystemParamDto getSystemParamByKey(
            @ApiParam(required = true, value = "系统参数key值") @PathVariable("paramKey") String paramKey) {
        return systemParamService.getSystemParamByKey(paramKey);
    }

    /**
     * Description: 根据主键查询系统信息
     *
     * @param systemParamId systemParamId
     * @return SystemParamDto
     */
    @RequestMapping(value = "/{systemParamId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据主键查询系统信息")
    public SystemParamDto getSystemParamById(
            @ApiParam(required = true, value = "系统参数主键") @PathVariable("systemParamId") Long systemParamId) {
        return systemParamService.getSystemParamById(systemParamId);
    }

    /**
     * Description: 新增系统参数
     *
     * @param systemParamDto systemParamDto
     * @return SystemParamDto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiParam(value = "新增系统参数")
    public SystemParamDto addSystemParam(
            @ApiParam(required = true, value = "系统参数信息") @RequestBody SystemParamDto systemParamDto) {
        return systemParamService.addSystemParam(systemParamDto);
    }

    /**
     * Description: 删除系统参数
     *
     * @param paramKey paramKey
     * @return int
     */
    @RequestMapping(value = "/paramKey/{paramKey}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除系统参数")
    public int deleteSystemParamByKey(
            @ApiParam(required = true, value = "系统参数key值") @PathVariable("paramKey") String paramKey) {
        return systemParamService.deleteSystemParamByKey(paramKey);
    }

    /**
     * Description: 根据主键删除系统参数
     *
     * @param systemParamId systemParamId
     * @return int
     */
    @RequestMapping(value = "/{systemParamId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "根据主键删除系统参数")
    public int deleteSystemParamById(
            @ApiParam(required = true, value = "系统参数主键") @PathVariable("systemParamId") Long systemParamId) {
        return systemParamService.deleteSystemParamById(systemParamId);
    }

    /**
     * Description: 修改系统参数
     *
     * @param systemParamDto systemParamDto
     * @return SystemParamDto
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation(value = "修改系统参数")
    public SystemParamDto updateSystemParam(
            @ApiParam(required = true, value = "系统参数信息") @RequestBody SystemParamDto systemParamDto) {
        return systemParamService.updateSystemParam(systemParamDto);
    }
}
