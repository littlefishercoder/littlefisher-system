package com.littlefisher.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.core.common.stereotype.constants.BaseConstants;
import com.littlefisher.user.biz.request.GetResourceRequest;
import com.littlefisher.web.dal.integration.user.ISystemIntegration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.oval.constraint.NotNull;

/**
 * Description: SystemController.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping(BaseConstants.BASE_API_PREFIX + "/blog/v1/system")
@Api(value = "system", description = "system操作相关API")
public class SystemController {

    @Autowired
    private ISystemIntegration systemIntegration;

    /**
     * 刷新Resource文件
     */
    @RequestMapping(value = "/resources/refresh", method = RequestMethod.PATCH)
    @ApiOperation(value = "刷新Resource文件")
    public void refreshResource() {
        systemIntegration.refreshResource();
    }

    /**
     * 查询Resource
     * 
     * @param request 请求入参
     * @return Resource资源
     */
    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    @ApiOperation(value = "查询Resource")
    public Map<Object, Object> getResource(
        @ApiParam(value = "查询Resource条件") @ModelAttribute @NotNull(message = "请求不能为空") GetResourceRequest request) {
        return systemIntegration.getResource(request.getDialect());
    }
}
