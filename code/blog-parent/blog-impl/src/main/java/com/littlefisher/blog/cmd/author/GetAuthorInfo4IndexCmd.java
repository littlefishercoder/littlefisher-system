package com.littlefisher.blog.cmd.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.littlefisher.blog.dao.AuthorDtoMapper;
import com.littlefisher.blog.dao.ext.ArchiveDtoExtMapper;
import com.littlefisher.blog.dao.ext.TagDtoExtMapper;
import com.littlefisher.blog.model.AuthorDto;
import com.littlefisher.blog.model.ext.AuthorExtDto;
import com.littlefisher.core.biz.framework.dao.UserContactStation4WebsiteDtoMapper;
import com.littlefisher.core.biz.framework.dao.UserContactStationDtoMapper;
import com.littlefisher.core.biz.framework.dao.UserDtoMapper;
import com.littlefisher.core.biz.framework.enums.EnumUserContactStationState;
import com.littlefisher.core.biz.framework.enums.EnumUserContactStationType;
import com.littlefisher.core.biz.framework.example.UserContactStation4WebsiteDtoExample;
import com.littlefisher.core.biz.framework.example.UserContactStationDtoExample;
import com.littlefisher.core.biz.framework.model.UserContactStation4WebsiteDto;
import com.littlefisher.core.biz.framework.model.UserContactStationDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

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
    private ArchiveDtoExtMapper archiveDtoMapper;

    @Autowired
    private TagDtoExtMapper tagDtoExtMapper;

    @Autowired
    private UserContactStationDtoMapper userContactStationDtoMapper;

    @Autowired
    private UserContactStation4WebsiteDtoMapper userContactStation4WebsiteDtoMapper;

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
        authorExtDto.setArchiveList(archiveDtoMapper.selectByAuthorId(authorId));
        authorExtDto.setTagList(tagDtoExtMapper.selectTagListByAuthorId(authorId));
        authorExtDto.setUserContactStation4WebsiteList(getUserWebsite(authorId));
        return authorExtDto;
    }

    /**
     * 查询作者名下所有的网址联系点
     * @param authorId 作者id
     * @return 网址联系点
     */
    private List<UserContactStation4WebsiteDto> getUserWebsite(Long authorId) {
        UserContactStationDtoExample userContactStationDtoExample = new UserContactStationDtoExample();
        userContactStationDtoExample.createCriteria()
                .andUserIdEqualTo(authorId)
                .andTypeEqualTo(EnumUserContactStationType.WEBSITE)
                .andStateEqualTo(EnumUserContactStationState.VALID);
        List<UserContactStationDto> userContactStationList = userContactStationDtoMapper.selectByExample(
                userContactStationDtoExample);
        List<Long> stationIdList = Lists.newArrayListWithCapacity(userContactStationList.size());
        userContactStationList.forEach(item -> stationIdList.add(item.getId()));
        UserContactStation4WebsiteDtoExample userContactStation4WebsiteDtoExample = new UserContactStation4WebsiteDtoExample();
        userContactStation4WebsiteDtoExample.createCriteria()
                .andContactStationIdIn(stationIdList);
        return userContactStation4WebsiteDtoMapper.selectByExample(userContactStation4WebsiteDtoExample);
    }
}
