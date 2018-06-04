package com.littlefisher.blog.biz.service;

import java.util.List;

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
public interface IFriendLinkService {

    /**
     * 查询友情链接
     * @param authorId 作者id
     * @return 友情链接
     */
    List<FriendLinkBizDto> getFriendLinkList(Long authorId);
}
