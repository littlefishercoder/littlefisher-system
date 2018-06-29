package com.littlefisher.blog.biz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.littlefisher.blog.biz.model.AuthorBizExtDto;

/**
 * Description: IAuthorService.java
 *
 * Created on 2018年01月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@FeignClient(value = "author-service", path = "/authors")
public interface IAuthorService {

    /**
     * 首页作者信息
     * 
     * @param authorId 作者id
     * @return 作者信息
     */
    @GetMapping("/{authorId}")
    AuthorBizExtDto getAuthorInfo4Index(@PathVariable("authorId") Long authorId);
}
