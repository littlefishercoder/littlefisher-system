package com.littlefisher.blog.biz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.littlefisher.blog.biz.model.ArchiveBizDto;

/**
 * Description: IArchiveService.java
 *
 * Created on 2018年01月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@FeignClient(value = "archive-service", path = "/archives")
public interface IArchiveService {

    /**
     * 根据name查询博文归类
     * 
     * @param name 归类名
     * @return 博文归类
     */
    @GetMapping("/{name}")
    ArchiveBizDto getValidArchiveByName(@PathVariable("name") String name);

    /**
     * 新增博文归类
     * 
     * @param name 归类名
     * @return 博文归类
     */
    @PostMapping("/archiveName/{name}")
    ArchiveBizDto addArchive(@PathVariable("name") String name);

}
