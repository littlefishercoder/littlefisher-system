package com.littlefisher.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.core.common.stereotype.constants.BaseConstants;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.user.biz.model.SystemParamBizDto;
import com.littlefisher.user.biz.request.AddSystemParamRequest;
import com.littlefisher.user.biz.request.GetSystemParamList4PageByCondRequest;
import com.littlefisher.user.biz.request.UpdateSystemParamRequest;
import com.littlefisher.web.dal.integration.user.ISystemParamIntegration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

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
@RequestMapping(BaseConstants.BASE_API_PREFIX + "/blog/v1/system/systemParam")
@Api(value = "systemParam", description = "systemParam 接口API")
public class SystemParamController {

    @Autowired
    private ISystemParamIntegration systemParamIntegration;

    /**
     * Description: 根据条件查询分页列表
     *
     * @param req req
     * @return SystemParamDto分页信息
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation(value = "根据条件查询分页列表")
    public PageInfo<SystemParamBizDto> getSystemParamList4PagerByCond(@ApiParam(
        value = "查询系统参数列表条件") @ModelAttribute @NotNull(message = "请求不能为空") GetSystemParamList4PageByCondRequest req) {
        return systemParamIntegration.getSystemParamList4PageByCond(req);
    }

    /**
     * Description: 根据key查询系统参数
     *
     * @param paramKey paramKey
     * @return SystemParamDto
     */
    @RequestMapping(value = "/paramKey/{paramKey}", method = RequestMethod.GET)
    @ApiOperation(value = "根据key查询系统参数")
    public SystemParamBizDto
        getSystemParamByKey(@ApiParam(required = true, value = "系统参数key值") @PathVariable("paramKey") @NotNull(
            message = "key不能为空") @NotBlank(message = "key不能为空") String paramKey) {
        return systemParamIntegration.getSystemParamByKey(paramKey);
    }

    /**
     * Description: 根据主键查询系统信息
     *
     * @param systemParamId systemParamId
     * @return SystemParamDto
     */
    @RequestMapping(value = "/{systemParamId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据主键查询系统信息")
    public SystemParamBizDto
        getSystemParamById(@ApiParam(required = true, value = "系统参数主键") @PathVariable("systemParamId") @NotNull(
            message = "systemParamId不能为空") @NotBlank(message = "systemParamId不能为空") Long systemParamId) {
        return systemParamIntegration.getSystemParamById(systemParamId);
    }

    /**
     * Description: 新增系统参数
     *
     * @param request 请求入参
     * @return SystemParamDto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiParam(value = "新增系统参数")
    public SystemParamBizDto addSystemParam(@ApiParam(required = true,
        value = "系统参数信息") @RequestBody @NotNull(message = "请求不能为空") AddSystemParamRequest request) {
        return systemParamIntegration.addSystemParam(request);
    }

    /**
     * Description: 删除系统参数
     *
     * @param paramKey paramKey
     * @return int
     */
    @RequestMapping(value = "/paramKey/{paramKey}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除系统参数")
    public int deleteSystemParamByKey(@ApiParam(required = true, value = "系统参数key值") @PathVariable("paramKey") @NotNull(
        message = "paramKey不能为空") @NotBlank(message = "paramKey不能为空") String paramKey) {
        return systemParamIntegration.deleteSystemParamByKey(paramKey);
    }

    /**
     * Description: 根据主键删除系统参数
     *
     * @param systemParamId systemParamId
     * @return int
     */
    @RequestMapping(value = "/{systemParamId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "根据主键删除系统参数")
    public int
        deleteSystemParamById(@ApiParam(required = true, value = "系统参数主键") @PathVariable("systemParamId") @NotNull(
            message = "systemParamId不能为空") @NotBlank(message = "systemParamId不能为空") Long systemParamId) {
        return systemParamIntegration.deleteSystemParamById(systemParamId);
    }

    /**
     * Description: 修改系统参数
     *
     * @param request 请求入参
     * @return SystemParamDto
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation(value = "修改系统参数")
    public SystemParamBizDto updateSystemParam(@ApiParam(required = true,
        value = "系统参数信息") @RequestBody @NotNull(message = "请求参数不能为空") UpdateSystemParamRequest request) {
        return systemParamIntegration.updateSystemParam(request);
    }
}
