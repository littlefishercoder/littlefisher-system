package com.littlefisher.user.biz.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description: ISystemService.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@FeignClient(value = "system-service", path = "/system/resources")
public interface ISystemService {

    /**
     * 刷新Resource文件
     */
    @PatchMapping
    void refreshResource();

    /**
     * 查询Resource
     * 
     * @param dialect 方言
     * @return Resource
     */
    @GetMapping("/{dialect}")
    Map<Object, Object> getResource(@PathVariable("dialect") String dialect);
}
