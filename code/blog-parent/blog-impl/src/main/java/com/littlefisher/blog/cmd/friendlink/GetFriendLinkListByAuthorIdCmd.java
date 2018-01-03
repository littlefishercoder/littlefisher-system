package com.littlefisher.blog.cmd.friendlink;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.FriendLinkDtoMapper;
import com.littlefisher.blog.example.FriendLinkDtoExample;
import com.littlefisher.blog.model.FriendLinkDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;

/**
 * Description: GetFriendLinkListByAuthorIdCommand.java
 *
 * Created on 2018年01月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetFriendLinkListByAuthorIdCmd extends AbstractCommand<List<FriendLinkDto>> {

    /**
     * 作者id
     */
    private Long authorId;

    @Autowired
    private FriendLinkDtoMapper mapper;

    public GetFriendLinkListByAuthorIdCmd setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    @Override
    public List<FriendLinkDto> execute() {
        FriendLinkDtoExample example = new FriendLinkDtoExample();
        example.createCriteria().andAuthorIdEqualTo(authorId);
        return mapper.selectByExample(example);
    }
}
