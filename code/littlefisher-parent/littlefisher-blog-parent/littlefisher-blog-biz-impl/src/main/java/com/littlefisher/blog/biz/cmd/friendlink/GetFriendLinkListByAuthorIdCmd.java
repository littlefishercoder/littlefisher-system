package com.littlefisher.blog.biz.cmd.friendlink;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.littlefisher.blog.biz.converter.FriendLinkDtoConverter;
import com.littlefisher.blog.biz.model.FriendLinkBizDto;
import com.littlefisher.blog.dal.dao.IFriendLinkDtoDao;
import com.littlefisher.blog.dal.model.FriendLinkDto;
import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;

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
public class GetFriendLinkListByAuthorIdCmd extends AbstractCommand<List<FriendLinkBizDto>> {

    /**
     * 作者id
     */
    private Long authorId;

    @Autowired
    private IFriendLinkDtoDao friendLinkDtoDao;

    public GetFriendLinkListByAuthorIdCmd setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    @Override
    public List<FriendLinkBizDto> execute() {
        List<FriendLinkDto> friendLinkList
            = friendLinkDtoDao.selectByRecord(FriendLinkDto.Builder.getInstance().addAuthorId(authorId).build());
        return Lists.newArrayList(
            Iterators.transform(friendLinkList.iterator(), FriendLinkDtoConverter::convert2FriendLinkBizDto));
    }
}
