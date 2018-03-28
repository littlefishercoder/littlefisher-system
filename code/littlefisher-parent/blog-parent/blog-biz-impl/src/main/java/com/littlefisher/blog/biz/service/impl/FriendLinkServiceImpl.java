package com.littlefisher.blog.biz.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.biz.cmd.friendlink.GetFriendLinkListByAuthorIdCmd;
import com.littlefisher.blog.biz.model.FriendLinkBizDto;
import com.littlefisher.blog.biz.service.IFriendLinkService;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * Description: FriendLinkService.java
 *
 * Created on 2018年01月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class FriendLinkServiceImpl extends ServiceImpl implements IFriendLinkService {

    @Override
    public List<FriendLinkBizDto> getFriendLinkList(Long authorId) {
        return execute(getCommand(GetFriendLinkListByAuthorIdCmd.class).setAuthorId(authorId));
    }
}
