package com.littlefisher.blog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.friendlink.GetFriendLinkListByAuthorIdCmd;
import com.littlefisher.blog.model.FriendLinkDto;
import com.littlefisher.blog.service.IFriendLinkService;
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
    public List<FriendLinkDto> getFriendLinkList(Long authorId) {
        return execute(getCommand(GetFriendLinkListByAuthorIdCmd.class).setAuthorId(authorId));
    }
}
