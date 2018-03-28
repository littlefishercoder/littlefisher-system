package com.littlefisher.core.biz.framework.converter;

import com.littlefisher.core.biz.framework.dal.model.UserContactStation4WebsiteDto;
import com.littlefisher.core.biz.framework.model.UserContactStation4WebsiteBizDto;

/**
 * Description: UserContactStation4WebsiteDtoConverter
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class UserContactStation4WebsiteDtoConverter {

    public static UserContactStation4WebsiteDto
        convert2UserContactStation4WebsiteDto(UserContactStation4WebsiteBizDto userContactStation4WebsiteBizDto) {
        return UserContactStation4WebsiteDto.Builder.getInstance()
            .addContactStationId(userContactStation4WebsiteBizDto.getContactStationId())
            .addCreateDate(userContactStation4WebsiteBizDto.getCreateDate())
            .addType(userContactStation4WebsiteBizDto.getType())
            .addUpdateDate(userContactStation4WebsiteBizDto.getUpdateDate())
            .addWebsite(userContactStation4WebsiteBizDto.getWebsite()).build();

    }

    public static UserContactStation4WebsiteBizDto
        convert2UserContactStation4WebsiteBizDto(UserContactStation4WebsiteDto userContactStation4WebsiteDto) {
        return UserContactStation4WebsiteBizDto.Builder.getInstance()
            .addContactStationId(userContactStation4WebsiteDto.getContactStationId())
            .addCreateDate(userContactStation4WebsiteDto.getCreateDate())
            .addType(userContactStation4WebsiteDto.getType())
            .addUpdateDate(userContactStation4WebsiteDto.getUpdateDate())
            .addWebsite(userContactStation4WebsiteDto.getWebsite()).build();

    }
}
