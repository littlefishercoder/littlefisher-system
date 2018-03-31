package com.littlefisher.blog.biz.cmd.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.littlefisher.blog.biz.converter.PostDtoConverter;
import com.littlefisher.blog.biz.model.ArchiveBizDto;
import com.littlefisher.blog.biz.model.PostBizDto;
import com.littlefisher.blog.biz.model.PostTagBizDto;
import com.littlefisher.blog.biz.model.TagBizDto;
import com.littlefisher.blog.biz.request.AddPostRequest;
import com.littlefisher.blog.biz.service.IArchiveService;
import com.littlefisher.blog.biz.service.ITagService;
import com.littlefisher.blog.common.enums.EnumPostState;
import com.littlefisher.blog.dal.dao.IPostDtoDao;
import com.littlefisher.blog.dal.model.PostDto;
import com.littlefisher.core.stereotype.enums.EnumBizBool;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.core.utils.DateUtil;

/**
 * Description:
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class AddPostCmd extends AbstractCommand<PostBizDto> {

    /** postDto */
    private AddPostRequest request;

    @Autowired
    private IPostDtoDao postDtoDao;

    @Autowired
    private IArchiveService archiveService;

    @Autowired
    private ITagService tagService;

    public AddPostCmd setRequest(AddPostRequest request) {
        this.request = request;
        return this;
    }

    @Override
    public PostBizDto execute() {
        // 校验archive
        ArchiveBizDto archiveDto = archiveService.addArchive(request.getArchiveName());
        // 校验tag
        List<TagBizDto> tagList = Lists.newArrayListWithCapacity(request.getTagNameList().size());
        request.getTagNameList().forEach(tagName -> tagList.add(tagService.addTag(tagName)));
        // 新增post
        PostDto postDto = PostDto.Builder.getInstance().addArchiveId(archiveDto.getId())
            .addAuthorId(request.getAuthorId()).addTitle(request.getTitle()).addContent(request.getContent())
            .addEnableComment(EnumBizBool.YES).addCreatedDate(DateUtil.getDBDateTime())
            .addOriginalUrl(request.getOriginalUrl()).addType(request.getType()).addState(EnumPostState.PUBLISHED)
            .addStateDate(DateUtil.getDBDateTime()).build();
        postDtoDao.insert(postDto);

        // 关联post和tag
        tagList.forEach(tagDto -> {
            PostTagBizDto postTagDto
                = PostTagBizDto.Builder.getInstance().addPostId(postDto.getId()).addTagId(tagDto.getId()).build();
            tagService.linkPostAndTag(postTagDto);
        });

        return PostDtoConverter.convert2PostBizDto(postDto);
    }

}
