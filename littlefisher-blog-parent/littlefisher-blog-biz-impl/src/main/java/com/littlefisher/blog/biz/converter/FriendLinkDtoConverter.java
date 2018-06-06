package com.littlefisher.blog.biz.converter;

import com.littlefisher.blog.biz.model.FriendLinkBizDto;
import com.littlefisher.blog.dal.model.FriendLinkDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: FriendLinkDtoConverter.java, v 0.1 2018/3/27 下午8:19 jinyn22648 Exp $$
 */
public final class FriendLinkDtoConverter {

    /**
     * 私有构造函数
     */
    private FriendLinkDtoConverter() {}

    /**
     * FriendLinkBizDto转FriendLinkDto
     * 
     * @param friendLinkBizDto FriendLinkBizDto
     * @return FriendLinkDto
     */
    public static FriendLinkDto convert2FriendLinkDto(FriendLinkBizDto friendLinkBizDto) {
        return FriendLinkDto.Builder.getInstance().addAuthorId(friendLinkBizDto.getAuthorId())
            .addFriendNickName(friendLinkBizDto.getFriendNickName())
            .addFriendRealName(friendLinkBizDto.getFriendRealName())
            .addFriendUrlLink(friendLinkBizDto.getFriendUrlLink()).addId(friendLinkBizDto.getId())
            .addState(friendLinkBizDto.getState()).addUpdateDate(friendLinkBizDto.getUpdateDate()).build();
    }

    /**
     * FriendLinkDto转FriendLinkBizDto
     * 
     * @param friendLinkDto FriendLinkDto
     * @return FriendLinkBizDto
     */
    public static FriendLinkBizDto convert2FriendLinkBizDto(FriendLinkDto friendLinkDto) {
        return FriendLinkBizDto.Builder.getInstance().addAuthorId(friendLinkDto.getAuthorId())
            .addFriendNickName(friendLinkDto.getFriendNickName()).addFriendRealName(friendLinkDto.getFriendRealName())
            .addFriendUrlLink(friendLinkDto.getFriendUrlLink()).addId(friendLinkDto.getId())
            .addState(friendLinkDto.getState()).addUpdateDate(friendLinkDto.getUpdateDate()).build();
    }
}
