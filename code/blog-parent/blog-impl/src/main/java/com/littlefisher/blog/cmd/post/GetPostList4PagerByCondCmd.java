package com.littlefisher.blog.cmd.post;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.littlefisher.blog.dao.ArchiveDtoMapper;
import com.littlefisher.blog.dao.AuthorDtoMapper;
import com.littlefisher.blog.dao.PostTagDtoMapper;
import com.littlefisher.blog.dao.TagDtoMapper;
import com.littlefisher.blog.dao.ext.PostDtoExtMapper;
import com.littlefisher.blog.enums.EnumPostTagState;
import com.littlefisher.blog.example.ArchiveDtoExample;
import com.littlefisher.blog.example.AuthorDtoExample;
import com.littlefisher.blog.example.PostDtoExample;
import com.littlefisher.blog.example.PostTagDtoExample;
import com.littlefisher.blog.example.TagDtoExample;
import com.littlefisher.blog.model.ArchiveDto;
import com.littlefisher.blog.model.AuthorDto;
import com.littlefisher.blog.model.PostDto;
import com.littlefisher.blog.model.PostTagDto;
import com.littlefisher.blog.model.TagDto;
import com.littlefisher.blog.model.ext.AuthorExtDto;
import com.littlefisher.blog.model.ext.PostExtDto;
import com.littlefisher.blog.request.GetPostList4PagerByCondRequest;
import com.littlefisher.blog.service.ICountStatisticService;
import com.littlefisher.core.biz.framework.dao.UserDtoMapper;
import com.littlefisher.core.biz.framework.example.UserDtoExample;
import com.littlefisher.core.biz.framework.model.UserDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;
import com.littlefisher.core.utils.CollectionUtil;
import com.littlefisher.core.utils.StringUtil;

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
public class GetPostList4PagerByCondCmd extends AbstractCommand<List<PostExtDto>> {

    /**
     * req
     */
    private GetPostList4PagerByCondRequest req;

    @Autowired
    private PostDtoExtMapper postDtoMapper;

    @Autowired
    private PostTagDtoMapper postTagDtoMapper;

    @Autowired
    private AuthorDtoMapper authorDtoMapper;

    @Autowired
    private UserDtoMapper userDtoMapper;

    @Autowired
    private ArchiveDtoMapper archiveDtoMapper;

    @Autowired
    private TagDtoMapper tagDtoMapper;

    @Autowired
    private ICountStatisticService countStatisticService;

    public GetPostList4PagerByCondCmd setReq(GetPostList4PagerByCondRequest req) {
        this.req = req;
        return this;
    }

    @Override
    public List<PostExtDto> execute() {
        PostDtoExample postDtoExample = new PostDtoExample();
        PostDtoExample.Criteria criteria = postDtoExample.createCriteria();
        if (StringUtil.isNotBlank(req.getTitle())) {
            criteria.andTitleLike(req.getTitle());
        }
        if (req.getAuthorId() != null) {
            criteria.andAuthorIdEqualTo(req.getAuthorId());
        }
        if (req.getArchiveId() != null) {
            criteria.andArchiveIdEqualTo(req.getArchiveId());
        }
        if (req.getCreatedDateEnd() != null) {
            criteria.andCreatedDateGreaterThanOrEqualTo(req.getCreatedDateEnd());
        }
        if (req.getCreatedDateStart() != null) {
            criteria.andCreatedDateLessThanOrEqualTo(req.getCreatedDateStart());
        }
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<PostDto> postList = postDtoMapper.selectByExample(postDtoExample);
        List<PostExtDto> postExtList = Lists.newArrayListWithCapacity(postList.size());
        List<Long> authorIdList = Lists.newArrayListWithCapacity(postList.size());
        List<Long> archivedIdList = Lists.newArrayListWithCapacity(postList.size());
        List<Long> tagIdList = Lists.newArrayListWithCapacity(postList.size());
        postList.forEach(postDto -> {
            PostExtDto postExtDto = new PostExtDto();
            BeanUtils.copyProperties(postDto, postExtDto);
            if (postDto.getAuthorId() != null) {
                authorIdList.add(postDto.getAuthorId());
            }
            if (postDto.getArchiveId() != null) {
                archivedIdList.add(postDto.getArchiveId());
            }

            PostTagDtoExample postTagDtoExample = new PostTagDtoExample();
            postTagDtoExample.createCriteria().andPostIdEqualTo(postDto.getId()).andStateEqualTo(EnumPostTagState.VALID);
            List<PostTagDto> postTagList = postTagDtoMapper.selectByExample(postTagDtoExample);
            if (CollectionUtil.isNotEmpty(postTagList)) {
                postTagList.forEach(postTagDto -> {
                    TagDto tagDto = new TagDto();
                    tagDto.setId(postTagDto.getId());
                    tagIdList.add(postTagDto.getTagId());
                    if (CollectionUtil.isEmpty(postExtDto.getTagList())) {
                        postExtDto.setTagList(Lists.newArrayList());
                    }
                    postExtDto.getTagList().add(tagDto);
                });
            }

            postExtList.add(postExtDto);
        });

        Map<Long, AuthorDto> authorMap = getAuthorMap(authorIdList);
        Map<Long, UserDto> userMap = getUserMap(authorIdList);
        Map<Long, ArchiveDto> archiveMap = getArchiveMap(archivedIdList);
        Map<Long, TagDto> tagMap = getTagMap(tagIdList);
        postExtList.forEach(postExtDto -> {
            AuthorExtDto authorExtDto = new AuthorExtDto();
            if (authorMap.get(postExtDto.getAuthorId()) != null) {
                BeanUtils.copyProperties(authorExtDto, authorMap.get(postExtDto.getAuthorId()));
            }

            authorExtDto.setUser(userMap.get(postExtDto.getAuthorId()));
            postExtDto.setAuthor(authorExtDto);

            postExtDto.setArchive(archiveMap.get(postExtDto.getArchiveId()));
            if (CollectionUtil.isNotEmpty(postExtDto.getTagList())) {
                postExtDto.getTagList().forEach(tagDto -> {
                    TagDto tagWithProp = tagMap.get(tagDto.getId());
                    tagDto.setName(tagWithProp.getName());
                    tagDto.setState(tagWithProp.getState());
                    tagDto.setCreateDate(tagWithProp.getCreateDate());
                    tagDto.setStateDate(tagWithProp.getStateDate());
                });
            }

            // 博文统计信息补充
            postExtDto.setCountStatistic4Post(countStatisticService.getPostCountStatistic(postExtDto.getId()));
        });

        return postExtList;
    }

    private Map<Long,UserDto> getUserMap(List<Long> authorIdList) {
        if (CollectionUtil.isEmpty(authorIdList)) {
            return Maps.newHashMap();
        }
        UserDtoExample userDtoExample = new UserDtoExample();
        userDtoExample.createCriteria().andIdIn(authorIdList);
        List<UserDto> userList = userDtoMapper.selectByExample(userDtoExample);
        Map<Long, UserDto> userMap = Maps.newHashMap();
        userList.forEach(userDto -> userMap.put(userDto.getId(), userDto));
        return userMap;
    }

    private Map<Long,TagDto> getTagMap(List<Long> tagIdList) {
        if (CollectionUtil.isEmpty(tagIdList)) {
            return Maps.newHashMap();
        }
        TagDtoExample tagDtoExample = new TagDtoExample();
        tagDtoExample.createCriteria().andIdIn(tagIdList);
        List<TagDto> tagList = tagDtoMapper.selectByExample(tagDtoExample);
        Map<Long, TagDto> tagMap = Maps.newHashMap();
        tagList.forEach(tagDto -> tagMap.put(tagDto.getId(), tagDto));
        return tagMap;
    }

    private Map<Long,ArchiveDto> getArchiveMap(List<Long> archivedIdList) {
        if (CollectionUtil.isEmpty(archivedIdList)) {
            return Maps.newHashMap();
        }
        ArchiveDtoExample archiveDtoExample = new ArchiveDtoExample();
        archiveDtoExample.createCriteria().andIdIn(archivedIdList);
        List<ArchiveDto> archiveList = archiveDtoMapper.selectByExample(archiveDtoExample);
        Map<Long, ArchiveDto> archiveMap = Maps.newHashMap();
        archiveList.forEach(archiveDto -> archiveMap.put(archiveDto.getId(), archiveDto));
        return archiveMap;
    }

    private Map<Long,AuthorDto> getAuthorMap(List<Long> authorIdList) {
        if (CollectionUtil.isEmpty(authorIdList)) {
            return Maps.newHashMap();
        }
        AuthorDtoExample authorDtoExample = new AuthorDtoExample();
        authorDtoExample.createCriteria().andIdIn(authorIdList);
        List<AuthorDto> authorList = authorDtoMapper.selectByExample(authorDtoExample);
        Map<Long, AuthorDto> authorMap = Maps.newHashMap();
        authorList.forEach(authorDto -> authorMap.put(authorDto.getId(), authorDto));
        return authorMap;
    }

}
