package com.littlefisher.web.dal.integration.blog;

import com.littlefisher.blog.biz.model.AuthorBizExtDto;

/**
 * Description: IAuthorIntegration.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IAuthorIntegration {

    /**
     * 首页作者信息
     * @param authorId 作者id
     * @return 作者信息
     */
    AuthorBizExtDto getAuthorInfo4Index(Long authorId);
}
