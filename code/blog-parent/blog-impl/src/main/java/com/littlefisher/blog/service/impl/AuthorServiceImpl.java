package com.littlefisher.blog.service.impl;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.author.GetAuthorInfo4IndexCmd;
import com.littlefisher.blog.model.ext.AuthorExtDto;
import com.littlefisher.blog.service.IAuthorService;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * Description: AuthorServiceImpl.java
 *
 * Created on 2018年01月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class AuthorServiceImpl extends ServiceImpl implements IAuthorService {

    @Override
    public AuthorExtDto getAuthorInfo4Index(Long authorId) {
        return execute(getCommand(GetAuthorInfo4IndexCmd.class).setAuthorId(authorId));
    }
}
