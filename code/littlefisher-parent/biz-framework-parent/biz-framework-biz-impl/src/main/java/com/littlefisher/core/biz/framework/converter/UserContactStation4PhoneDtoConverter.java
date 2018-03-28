package com.littlefisher.core.biz.framework.converter;

import com.littlefisher.core.biz.framework.dal.model.UserContactStation4PhoneDto;
import com.littlefisher.core.biz.framework.model.UserContactStation4PhoneBizDto;

/**
 * Description: UserContactStation4PhoneDtoConverter
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class UserContactStation4PhoneDtoConverter {

    public static UserContactStation4PhoneDto
        convert2UserContactStation4PhoneDto(UserContactStation4PhoneBizDto userContactStation4PhoneBizDto) {
        return UserContactStation4PhoneDto.Builder.getInstance()
            .addAreaCode(userContactStation4PhoneBizDto.getAreaCode())
            .addContactStationId(userContactStation4PhoneBizDto.getContactStationId())
            .addCreateDate(userContactStation4PhoneBizDto.getCreateDate())
            .addPhoneNbr(userContactStation4PhoneBizDto.getPhoneNbr()).addType(userContactStation4PhoneBizDto.getType())
            .addUpdateDate(userContactStation4PhoneBizDto.getUpdateDate()).build();

    }

    public static UserContactStation4PhoneBizDto
        convert2UserContactStation4PhoneBizDto(UserContactStation4PhoneDto userContactStation4PhoneDto) {
        return UserContactStation4PhoneBizDto.Builder.getInstance()
            .addAreaCode(userContactStation4PhoneDto.getAreaCode())
            .addContactStationId(userContactStation4PhoneDto.getContactStationId())
            .addCreateDate(userContactStation4PhoneDto.getCreateDate())
            .addPhoneNbr(userContactStation4PhoneDto.getPhoneNbr()).addType(userContactStation4PhoneDto.getType())
            .addUpdateDate(userContactStation4PhoneDto.getUpdateDate()).build();

    }
}
