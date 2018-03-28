package com.littlefisher.core.biz.framework.converter;

import com.littlefisher.core.biz.framework.dal.model.UserContactStation4EmailDto;
import com.littlefisher.core.biz.framework.model.UserContactStation4EmailBizDto;

/**
 * Description: UserContactStation4EmailDtoConverter
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class UserContactStation4EmailDtoConverter {

    public static UserContactStation4EmailDto
        convert2UserContactStation4EmailDto(UserContactStation4EmailBizDto userContactStation4EmailBizDto) {
        return UserContactStation4EmailDto.Builder.getInstance().addType(userContactStation4EmailBizDto.getType())
            .addContactStationId(userContactStation4EmailBizDto.getContactStationId())
            .addCreateDate(userContactStation4EmailBizDto.getCreateDate())
            .addEmail(userContactStation4EmailBizDto.getEmail())
            .addUpdateDate(userContactStation4EmailBizDto.getUpdateDate()).build();
    }

    public static UserContactStation4EmailBizDto
        convert2UserContactStation4EmailBizDto(UserContactStation4EmailDto userContactStation4EmailDto) {
        return UserContactStation4EmailBizDto.Builder.getInstance().addType(userContactStation4EmailDto.getType())
            .addContactStationId(userContactStation4EmailDto.getContactStationId())
            .addCreateDate(userContactStation4EmailDto.getCreateDate()).addEmail(userContactStation4EmailDto.getEmail())
            .addUpdateDate(userContactStation4EmailDto.getUpdateDate()).build();
    }

}
