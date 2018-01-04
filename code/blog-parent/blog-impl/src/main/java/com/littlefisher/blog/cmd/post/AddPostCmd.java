package com.littlefisher.blog.cmd.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.littlefisher.blog.dao.PostDtoMapper;
import com.littlefisher.blog.model.ArchiveDto;
import com.littlefisher.blog.model.PostDto;
import com.littlefisher.blog.model.PostTagDto;
import com.littlefisher.blog.model.TagDto;
import com.littlefisher.blog.request.AddPostRequest;
import com.littlefisher.blog.service.IArchiveService;
import com.littlefisher.blog.service.ITagService;
import com.littlefisher.core.enums.EnumBizBool;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;
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
public class AddPostCmd extends AbstractCommand<PostDto> {

    /** postDto */
    private AddPostRequest request;

    @Autowired
    private PostDtoMapper postDtoMapper;

    @Autowired
    private IArchiveService archiveService;

    @Autowired
    private ITagService tagService;

    public AddPostCmd setRequest(AddPostRequest request) {
        this.request = request;
        return this;
    }

    @Override
    public PostDto execute() {
        // 校验archive
        ArchiveDto archiveDto = archiveService.addArchive(request.getArchiveName());
        // 校验tag
        List<TagDto> tagList = Lists.newArrayListWithCapacity(request.getTagNameList().size());
        request.getTagNameList().forEach(tagName -> {
            tagList.add(tagService.addTag(tagName));
        });
        // 新增post
        PostDto postDto = new PostDto();
        postDto.setArchiveId(archiveDto.getId());
        postDto.setAuthorId(request.getAuthorId());
        postDto.setTitle(request.getTitle());
        postDto.setContent(request.getContent());
        postDto.setEnableComment(EnumBizBool.YES);
        postDto.setCreatedDate(DateUtil.getDBDateTime());
        postDto.setOriginalUrl(request.getOriginalUrl());
        postDto.setType(request.getType());
        postDtoMapper.insert(postDto);

        // 关联post和tag
        tagList.forEach(tagDto -> {
            PostTagDto postTagDto = new PostTagDto();
            postTagDto.setPostId(postDto.getId());
            postTagDto.setTagId(tagDto.getId());
            tagService.linkPostAndTag(postTagDto);
        });

        return postDto;
    }

}
