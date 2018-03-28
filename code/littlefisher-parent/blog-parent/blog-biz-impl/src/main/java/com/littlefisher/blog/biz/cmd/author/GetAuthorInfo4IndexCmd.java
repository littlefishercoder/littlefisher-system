package com.littlefisher.blog.biz.cmd.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.littlefisher.blog.biz.converter.ArchiveDtoConverter;
import com.littlefisher.blog.biz.converter.AuthorDtoConverter;
import com.littlefisher.blog.biz.converter.TagDtoConverter;
import com.littlefisher.blog.biz.model.ArchiveBizDto;
import com.littlefisher.blog.biz.model.AuthorBizExtDto;
import com.littlefisher.blog.biz.model.TagBizDto;
import com.littlefisher.blog.dal.dao.IArchiveDtoDao;
import com.littlefisher.blog.dal.dao.IAuthorDtoDao;
import com.littlefisher.blog.dal.dao.IPostDtoDao;
import com.littlefisher.blog.dal.dao.IPostTagDtoDao;
import com.littlefisher.blog.dal.dao.ITagDtoDao;
import com.littlefisher.blog.dal.integration.IBizFrameworkIntegration;
import com.littlefisher.blog.dal.model.ArchiveDto;
import com.littlefisher.blog.dal.model.AuthorDto;
import com.littlefisher.blog.dal.model.PostDto;
import com.littlefisher.blog.dal.model.PostTagDto;
import com.littlefisher.blog.dal.model.TagDto;
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
public class GetAuthorInfo4IndexCmd extends AbstractCommand<AuthorBizExtDto> {

    /** 作者id */
    private Long authorId;

    @Autowired
    private IAuthorDtoDao authorDtoDao;

    @Autowired
    private IBizFrameworkIntegration bizFrameworkIntegration;

    @Autowired
    private IArchiveDtoDao archiveDtoDao;

    @Autowired
    private ITagDtoDao tagDtoDao;

    @Autowired
    private IPostDtoDao postDtoDao;

    @Autowired
    private IPostTagDtoDao postTagDtoDao;

    public GetAuthorInfo4IndexCmd setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    @Override
    public AuthorBizExtDto execute() {
        AuthorDto authorDto = authorDtoDao.selectByPrimaryKey(authorId);
        if (authorDto == null) {
            return null;
        }
        List<PostDto> postList = getPostByAuthorId(authorId);
        return AuthorBizExtDto.Builder.getInstance().addAuthor(AuthorDtoConverter.convert2AuthorBizDto(authorDto))
            .addUser(bizFrameworkIntegration.getUserById(authorId))
            .addUserContactStation4WebsiteList(bizFrameworkIntegration.getUserContactStation4WebsiteByUserId(authorId))
            .addArchiveList(getArchiveByPostList(postList)).addTagList(getTagListByPostList(postList)).build();
    }

    /**
     * 根据文章查询tag列表
     * 
     * @param postList 文章
     * @return tag列表
     */
    private List<TagBizDto> getTagListByPostList(List<PostDto> postList) {
        List<Long> postIdList = Lists.newArrayList(Iterators.transform(postList.iterator(), PostDto::getId));
        List<PostTagDto> postTagList = postTagDtoDao.selectByPostIdList(postIdList);
        List<Long> tagIdList = Lists.newArrayList(Iterators.transform(postTagList.iterator(), PostTagDto::getTagId));
        List<TagDto> tagList = tagDtoDao.selectByTagIdList(tagIdList);
        return Lists.newArrayList(Iterators.transform(tagList.iterator(), TagDtoConverter::convert2TagBizDto));
    }

    /**
     * 查询作者名下的文章归类
     * 
     * @param postList 文章列表
     * @return 文章分类列表
     */
    private List<ArchiveBizDto> getArchiveByPostList(List<PostDto> postList) {
        List<Long> archiveIdList = Lists.newArrayList(Iterators.transform(postList.iterator(), PostDto::getArchiveId));
        List<ArchiveDto> archiveList = archiveDtoDao.selectArchiveByIdList(archiveIdList);
        return Lists
            .newArrayList(Iterators.transform(archiveList.iterator(), ArchiveDtoConverter::convert2ArchiveBizDto));
    }

    private List<PostDto> getPostByAuthorId(Long authorId) {
        return postDtoDao.selectWithoutBlobByRecord(PostDto.Builder.getInstance().addAuthorId(authorId).build());
    }

}
