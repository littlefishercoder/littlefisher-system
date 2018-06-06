package com.littlefisher.blog.biz.converter;

import com.littlefisher.blog.biz.model.AuthorBizDto;
import com.littlefisher.blog.dal.model.AuthorDto;

/**
 * Description: AuthorDtoConverter
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class AuthorDtoConverter {
    /**
     * 私有构造函数
     */
    private AuthorDtoConverter() {
    }

    public static AuthorDto convert2AuthorDto(AuthorBizDto authorBizDto) {
        return AuthorDto.Builder.getInstance().addId(authorBizDto.getId()).addMotto(authorBizDto.getMotto())
            .addPenName(authorBizDto.getPenName()).addState(authorBizDto.getState())
            .addUpdateDate(authorBizDto.getUpdateDate()).build();
    }

    public static AuthorBizDto convert2AuthorBizDto(AuthorDto authorDto) {
        return AuthorBizDto.Builder.getInstance().addId(authorDto.getId()).addMotto(authorDto.getMotto())
            .addPenName(authorDto.getPenName()).addState(authorDto.getState()).addUpdateDate(authorDto.getUpdateDate())
            .build();
    }
}
