package com.littlefisher.core.biz.framework.converter;

import com.littlefisher.core.biz.framework.dal.model.UserContactStation4SocialDto;
import com.littlefisher.core.biz.framework.model.UserContactStation4SocialBizDto;

/**
 * Description: UserContactStation4SocialDtoConverter
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class UserContactStation4SocialDtoConverter {

    public static UserContactStation4SocialDto
        convert2UserContactStation4SocialDto(UserContactStation4SocialBizDto userContactStation4SocialBizDto) {
        return UserContactStation4SocialDto.Builder.getInstance()
            .addAccount(userContactStation4SocialBizDto.getAccount())
            .addContactStationId(userContactStation4SocialBizDto.getContactStationId())
            .addCreateDate(userContactStation4SocialBizDto.getCreateDate())
            .addNickName(userContactStation4SocialBizDto.getNickName())
            .addType(userContactStation4SocialBizDto.getType())
            .addUpdateDate(userContactStation4SocialBizDto.getUpdateDate()).build();
    }

    public static UserContactStation4SocialBizDto
        convert2UserContactStation4SocialBizDto(UserContactStation4SocialDto userContactStation4SocialDto) {
        return UserContactStation4SocialBizDto.Builder.getInstance()
            .addAccount(userContactStation4SocialDto.getAccount())
            .addContactStationId(userContactStation4SocialDto.getContactStationId())
            .addCreateDate(userContactStation4SocialDto.getCreateDate())
            .addNickName(userContactStation4SocialDto.getNickName()).addType(userContactStation4SocialDto.getType())
            .addUpdateDate(userContactStation4SocialDto.getUpdateDate()).build();
    }
}
