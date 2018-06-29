package com.littlefisher.blog.biz.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.littlefisher.blog.biz.model.FriendLinkBizDto;

/**
 * Description: IFriendLinkService.java
 *
 * Created on 2018年01月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@FeignClient(value = "friend-link-service", path = "/friendLinks")
public interface IFriendLinkService {

    /**
     * 查询友情链接
     * 
     * @param authorId 作者id
     * @return 友情链接
     */
    @GetMapping("/{authorId}")
    List<FriendLinkBizDto> getFriendLinkList(@PathVariable("authorId") Long authorId);
}
