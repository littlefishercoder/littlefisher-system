package com.littlefisher.blog.cmd.author;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.ArchiveDtoMapper;
import com.littlefisher.blog.dao.AuthorDtoMapper;
import com.littlefisher.blog.example.ArchiveDtoExample;
import com.littlefisher.blog.model.AuthorDto;
import com.littlefisher.blog.model.ext.AuthorExtDto;
import com.littlefisher.core.biz.framework.dao.UserDtoMapper;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;

/**
 * Description: GetAuthorInfo4IndexCommand.java
 *
 * Created on 2018年01月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetAuthorInfo4IndexCmd extends AbstractCommand<AuthorExtDto> {

    /** 作者id */
    private Long authorId;

    @Autowired
    private AuthorDtoMapper authorDtoMapper;

    @Autowired
    private UserDtoMapper userDtoMapper;

    @Autowired
    private ArchiveDtoMapper archiveDtoMapper;

    public GetAuthorInfo4IndexCmd setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    @Override
    public AuthorExtDto execute() {
        AuthorDto authorDto = authorDtoMapper.selectByPrimaryKey(authorId);
        if (authorDto == null) {
            return null;
        }
        AuthorExtDto authorExtDto = (AuthorExtDto) authorDto;
        authorExtDto.setUser(userDtoMapper.selectByPrimaryKey(authorExtDto.getId()));
        ArchiveDtoExample archiveDtoExample = new ArchiveDtoExample();
        return null;
    }
}
