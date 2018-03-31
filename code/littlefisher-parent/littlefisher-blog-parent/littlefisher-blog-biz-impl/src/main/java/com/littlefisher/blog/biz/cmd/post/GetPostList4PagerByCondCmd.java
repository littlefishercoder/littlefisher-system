package com.littlefisher.blog.biz.cmd.post;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.littlefisher.blog.biz.converter.ArchiveDtoConverter;
import com.littlefisher.blog.biz.converter.AuthorDtoConverter;
import com.littlefisher.blog.biz.converter.PostTagDtoConverter;
import com.littlefisher.blog.biz.converter.TagDtoConverter;
import com.littlefisher.blog.biz.model.ArchiveBizDto;
import com.littlefisher.blog.biz.model.AuthorBizDto;
import com.littlefisher.blog.biz.model.AuthorBizExtDto;
import com.littlefisher.blog.biz.model.PostBizExtDto;
import com.littlefisher.blog.biz.model.PostTagBizDto;
import com.littlefisher.blog.biz.model.TagBizDto;
import com.littlefisher.blog.biz.request.GetPostList4PageByCondRequest;
import com.littlefisher.blog.biz.service.ICountStatisticService;
import com.littlefisher.blog.dal.dao.IArchiveDtoDao;
import com.littlefisher.blog.dal.dao.IAuthorDtoDao;
import com.littlefisher.blog.dal.dao.IPostDtoDao;
import com.littlefisher.blog.dal.dao.IPostTagDtoDao;
import com.littlefisher.blog.dal.dao.ITagDtoDao;
import com.littlefisher.blog.dal.integration.IUserIntegration;
import com.littlefisher.blog.dal.model.ArchiveDto;
import com.littlefisher.blog.dal.model.AuthorDto;
import com.littlefisher.blog.dal.model.PostDto;
import com.littlefisher.blog.dal.model.PostTagDto;
import com.littlefisher.blog.dal.model.TagDto;
import com.littlefisher.blog.dal.param.SelectPost4PageByCondParam;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.core.utils.CollectionUtil;
import com.littlefisher.user.model.UserBizDto;

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
public class GetPostList4PagerByCondCmd extends AbstractCommand<PageInfo<PostBizExtDto>> {

    /**
     * req
     */
    private GetPostList4PageByCondRequest req;

    @Autowired
    private IPostDtoDao postDtoDao;

    @Autowired
    private IPostTagDtoDao postTagDtoDao;

    @Autowired
    private IAuthorDtoDao authorDtoDao;

    @Autowired
    private IUserIntegration bizFrameworkIntegration;

    @Autowired
    private IArchiveDtoDao archiveDtoDao;

    @Autowired
    private ITagDtoDao tagDtoDao;

    @Autowired
    private ICountStatisticService countStatisticService;

    public GetPostList4PagerByCondCmd setReq(GetPostList4PageByCondRequest req) {
        this.req = req;
        return this;
    }

    @Override
    public PageInfo<PostBizExtDto> execute() {
        PageInfo<PostDto> pageInfo = postDtoDao.selectPost4PageByCond(
            SelectPost4PageByCondParam.Builder.getInstance().addTitle(req.getTitle()).addArchiveId(req.getArchiveId())
                .addAuthorId(req.getAuthorId()).addCreatedDateEnd(req.getCreatedDateEnd())
                .addCreatedDateStart(req.getCreatedDateStart()).build(),
            PageParam.Builder.getInstance().addPageNum(req.getPageNum()).addPageSize(req.getPageSize()).build());

        List<Long> authorIdList = Lists.newArrayListWithCapacity(pageInfo.getList().size());
        List<Long> archivedIdList = Lists.newArrayListWithCapacity(pageInfo.getList().size());
        List<Long> tagIdList = Lists.newArrayListWithCapacity(pageInfo.getList().size());
        List<Long> postIdList = Lists.newArrayListWithCapacity(pageInfo.getList().size());

        pageInfo.getList().forEach(postDto -> {
            if (postDto.getAuthorId() != null) {
                authorIdList.add(postDto.getAuthorId());
            }
            if (postDto.getArchiveId() != null) {
                archivedIdList.add(postDto.getArchiveId());
            }
            if (postDto.getId() != null) {
                postIdList.add(postDto.getId());
            }
        });

        Map<Long, AuthorBizDto> authorMap = getAuthorMap(authorIdList);
        Map<Long, UserBizDto> userMap = getUserMap(authorIdList);
        Map<Long, ArchiveBizDto> archiveMap = getArchiveMap(archivedIdList);
        Map<Long, List<PostTagBizDto>> postTagMap = getPostTagMap(postIdList);
        Map<Long, TagBizDto> tagMap = getTagMap(tagIdList);

        return new PageInfo<>(pageInfo, postDto -> {
            List<PostTagBizDto> postTagBizList = postTagMap.get(postDto.getId());
            List<TagBizDto> tagList = Lists.newArrayList();
            if (CollectionUtil.isNotEmpty(postTagBizList)) {
                postTagBizList.forEach(postTagBizDto -> tagList.add(tagMap.get(postTagBizDto.getTagId())));
            }

            return PostBizExtDto.Builder.getInstance()
                // 作者信息
                .addAuthor(AuthorBizExtDto.Builder.getInstance().addAuthor(authorMap.get(postDto.getAuthorId()))
                    // 用户信息
                    .addUser(userMap.get(postDto.getAuthorId())).build())
                // 博文归档信息
                .addArchive(archiveMap.get(postDto.getArchiveId()))
                // tag信息
                .addTagList(tagList)
                // 统计信息
                .addCountStatistic4Post(countStatisticService.getPostCountStatistic(postDto.getId())).build();
        });

    }

    /**
     * 根据文章id查询tag关联
     * 
     * @param postIdList 文章id列表
     * @return tag关联map
     */
    private Map<Long, List<PostTagBizDto>> getPostTagMap(List<Long> postIdList) {
        List<PostTagDto> postTagList = postTagDtoDao.selectByPostIdList(postIdList);
        Map<Long, List<PostTagBizDto>> postTagMap = Maps.newHashMapWithExpectedSize(postTagList.size());
        postTagList.forEach(postTagDto -> {
            if (postTagMap.get(postTagDto.getPostId()) == null) {
                postTagMap.put(postTagDto.getPostId(),
                    Lists.newArrayList(PostTagDtoConverter.convert2PostTagBizDto(postTagDto)));
            } else {
                postTagMap.get(postTagDto.getPostId()).add(PostTagDtoConverter.convert2PostTagBizDto(postTagDto));
            }
        });

        return postTagMap;
    }

    private Map<Long, UserBizDto> getUserMap(List<Long> userIdList) {
        if (CollectionUtil.isEmpty(userIdList)) {
            return Maps.newHashMap();
        }
        List<UserBizDto> userList = bizFrameworkIntegration.getUserByIdList(userIdList);
        Map<Long, UserBizDto> userMap = Maps.newHashMapWithExpectedSize(userList.size());
        userList.forEach(userDto -> userMap.put(userDto.getId(), userDto));
        return userMap;
    }

    /**
     * 根据tagId查询tag信息
     * 
     * @param tagIdList tagId列表
     * @return tag信息map集合
     */
    private Map<Long, TagBizDto> getTagMap(List<Long> tagIdList) {
        if (CollectionUtil.isEmpty(tagIdList)) {
            return Maps.newHashMap();
        }
        List<TagDto> tagList = tagDtoDao.selectByTagIdList(tagIdList);
        Map<Long, TagBizDto> tagMap = Maps.newHashMapWithExpectedSize(tagList.size());
        tagList.forEach(tagDto -> tagMap.put(tagDto.getId(), TagDtoConverter.convert2TagBizDto(tagDto)));
        return tagMap;
    }

    /**
     * 根据归档id列表查询归档信息
     * 
     * @param archivedIdList 归档id列表
     * @return 归档信息map集合
     */
    private Map<Long, ArchiveBizDto> getArchiveMap(List<Long> archivedIdList) {
        if (CollectionUtil.isEmpty(archivedIdList)) {
            return Maps.newHashMap();
        }
        List<ArchiveDto> archiveList = archiveDtoDao.selectArchiveByIdList(archivedIdList);
        Map<Long, ArchiveBizDto> archiveMap = Maps.newHashMapWithExpectedSize(archiveList.size());
        archiveList.forEach(
            archiveDto -> archiveMap.put(archiveDto.getId(), ArchiveDtoConverter.convert2ArchiveBizDto(archiveDto)));
        return archiveMap;
    }

    /**
     * 根据作者id列表查询作者信息
     * 
     * @param authorIdList 作者id列表
     * @return 作者map集合
     */
    private Map<Long, AuthorBizDto> getAuthorMap(List<Long> authorIdList) {
        if (CollectionUtil.isEmpty(authorIdList)) {
            return Maps.newHashMap();
        }
        List<AuthorDto> authorList = authorDtoDao.selectAuthorByAuthorIdList(authorIdList);
        Map<Long, AuthorBizDto> authorMap = Maps.newHashMapWithExpectedSize(authorList.size());
        authorList
            .forEach(authorDto -> authorMap.put(authorDto.getId(), AuthorDtoConverter.convert2AuthorBizDto(authorDto)));
        return authorMap;
    }

}
