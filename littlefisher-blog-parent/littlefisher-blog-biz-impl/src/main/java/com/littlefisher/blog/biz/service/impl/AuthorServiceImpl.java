package com.littlefisher.blog.biz.service.impl;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.littlefisher.blog.biz.cmd.author.GetAuthorInfo4IndexCmd;
import com.littlefisher.blog.biz.model.AuthorBizExtDto;
import com.littlefisher.blog.biz.service.IAuthorService;
import com.littlefisher.core.datasource.interceptor.service.ServiceImpl;

/**
 * Description: AuthorServiceImpl.java
 *
 * Created on 2018年01月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Component
@Service(interfaceClass = IAuthorService.class)
public class AuthorServiceImpl extends ServiceImpl implements IAuthorService {

    @Override
    public AuthorBizExtDto getAuthorInfo4Index(Long authorId) {
        return execute(getCommand(GetAuthorInfo4IndexCmd.class).setAuthorId(authorId));
    }
}
