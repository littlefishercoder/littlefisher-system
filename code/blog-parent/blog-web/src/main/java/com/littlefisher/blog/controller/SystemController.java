package com.littlefisher.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.core.biz.framework.request.GetResourceRequest;
import com.littlefisher.core.biz.framework.service.ISystemService;
import com.littlefisher.core.stereotype.constants.BaseConstants;

import java.util.Properties;

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
    private ISystemService systemService;

    /**
     * 刷新Resource文件
     */
    @RequestMapping(value = "/resources/refresh", method = RequestMethod.PATCH)
    @ApiOperation(value = "刷新Resource文件")
    public void refreshResource() {
        systemService.refreshResource();
    }

    /**
     * 查询Resource
     * @param request 请求入参
     */
    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    @ApiOperation(value = "查询Resource")
    public Properties getResource(@ApiParam(value = "查询Resource条件") @ModelAttribute GetResourceRequest request) {
        return systemService.getResource(request.getDialect());
    }
}
