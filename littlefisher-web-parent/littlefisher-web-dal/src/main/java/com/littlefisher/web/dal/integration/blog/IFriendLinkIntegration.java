package com.littlefisher.web.dal.integration.blog;

import java.util.List;

import com.littlefisher.blog.biz.model.FriendLinkBizDto;

/**
 * Description: IFriendLinkIntegration.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IFriendLinkIntegration {

    /**
     * 查询友情链接
     * @param authorId 作者id
     * @return 友情链接
     */
    List<FriendLinkBizDto> getFriendLinkList(Long authorId);
}
