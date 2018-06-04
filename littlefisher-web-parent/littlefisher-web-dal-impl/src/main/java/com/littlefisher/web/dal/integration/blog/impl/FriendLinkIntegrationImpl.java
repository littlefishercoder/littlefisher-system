package com.littlefisher.web.dal.integration.blog.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.config.annotation.Reference;
import com.littlefisher.blog.biz.model.FriendLinkBizDto;
import com.littlefisher.blog.biz.service.IFriendLinkService;
import com.littlefisher.web.dal.integration.blog.IFriendLinkIntegration;

/**
 * Description: FriendLinkIntegrationImpl.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class FriendLinkIntegrationImpl implements IFriendLinkIntegration {

    @Reference
    private IFriendLinkService friendLinkService;

    @Override
    public List<FriendLinkBizDto> getFriendLinkList(Long authorId) {
        return friendLinkService.getFriendLinkList(authorId);
    }
}
