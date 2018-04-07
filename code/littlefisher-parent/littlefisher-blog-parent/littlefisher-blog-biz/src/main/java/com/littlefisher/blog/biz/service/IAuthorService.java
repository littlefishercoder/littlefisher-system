package com.littlefisher.blog.biz.service;

import com.littlefisher.blog.biz.model.AuthorBizExtDto;

/**
 * Description: IAuthorService.java
 *
 * Created on 2018年01月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IAuthorService {

    /**
     * 首页作者信息
     * @param authorId 作者id
     * @return 作者信息
     */
    AuthorBizExtDto getAuthorInfo4Index(Long authorId);
}
