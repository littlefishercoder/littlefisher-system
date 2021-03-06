package com.littlefisher.user.converter;

import com.littlefisher.user.dal.model.UserDto;
import com.littlefisher.user.model.UserBizDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: UserDtoConverter.java, v 0.1 2018/3/26 下午7:45 jinyn22648 Exp $$
 */
public final class UserDtoConverter {

    /**
     * 私有构造函数
     */
    private UserDtoConverter() {}

    /**
     * UserBizDto转UserDto
     * 
     * @param userBizDto userBizDto
     * @return UserDto
     */
    public static UserDto convert2UserDto(UserBizDto userBizDto) {
        return UserDto.Builder.getInstance().addId(userBizDto.getId()).addAccNbr(userBizDto.getAccNbr())
            .addEnName(userBizDto.getEnName()).addLastLoginDate(userBizDto.getLastLoginDate())
            .addNickName(userBizDto.getNickName()).addPassword(userBizDto.getPassword())
            .addRealName(userBizDto.getRealName()).addRegDate(userBizDto.getRegDate()).addState(userBizDto.getState())
            .addUserDesc(userBizDto.getUserDesc()).build();
    }

    /**
     * UserDto转UserBizDto
     * 
     * @param userDto UserDto
     * @return UserBizDto
     */
    public static UserBizDto convert2UserBizDto(UserDto userDto) {
        return UserBizDto.Builder.getInstance().addId(userDto.getId()).addAccNbr(userDto.getAccNbr())
            .addEnName(userDto.getEnName()).addLastLoginDate(userDto.getLastLoginDate())
            .addNickName(userDto.getNickName()).addPassword(userDto.getPassword()).addRealName(userDto.getRealName())
            .addRegDate(userDto.getRegDate()).addState(userDto.getState()).addUserDesc(userDto.getUserDesc()).build();
    }

}
