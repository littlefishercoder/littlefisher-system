package com.littlefisher.user.biz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.spring.cloud.feign.annotation.JsonArgument;
import com.littlefisher.user.biz.model.SystemParamBizDto;
import com.littlefisher.user.biz.request.AddSystemParamRequest;
import com.littlefisher.user.biz.request.GetSystemParamList4PageByCondRequest;
import com.littlefisher.user.biz.request.UpdateSystemParamRequest;

/**
 * 系统信息参数
 *
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@FeignClient(value = "system-param-service", path = "/system/systemParams")
public interface ISystemParamService {

    /**
     * 根据条件查询
     *
     * @param req req
     * @return 系统参数列表
     */
    @GetMapping("/page")
    PageInfo<SystemParamBizDto>
        getSystemParamList4PageByCond(@JsonArgument("request")
            GetSystemParamList4PageByCondRequest req);

    /**
     * 根据key值查询系统参数
     *
     * @param paramKey paramKey
     * @return SystemParamDto
     */
    @GetMapping("/paramKey/{paramKey}")
    SystemParamBizDto getSystemParamByKey(@PathVariable("paramKey") String paramKey);

    /**
     * 根据id查询系统参数
     *
     * @param systemParamId systemParamId
     * @return SystemParamDto
     */
    @GetMapping("/{systemParamId}")
    SystemParamBizDto getSystemParamById(@PathVariable("systemParamId") Long systemParamId);

    /**
     * 新增系统参数
     *
     * @param request systemParamDto
     * @return SystemParamDto
     */
    @PostMapping
    SystemParamBizDto addSystemParam(@RequestBody AddSystemParamRequest request);

    /**
     * 根据key删除系统参数
     *
     * @param paramKey paramKey
     * @return int
     */
    @DeleteMapping("/paramKey/{paramKey}")
    int deleteSystemParamByKey(@PathVariable("paramKey") String paramKey);

    /**
     * 根据主键删除系统参数
     *
     * @param systemParamId systemParamId
     * @return int
     */
    @DeleteMapping("/{systemParamId}")
    int deleteSystemParamById(@PathVariable("systemParamId") Long systemParamId);

    /**
     * 修改系统参数
     *
     * @param request systemParamDto
     * @return SystemParamDto
     */
    @PatchMapping
    SystemParamBizDto updateSystemParam(@RequestBody UpdateSystemParamRequest request);
}
