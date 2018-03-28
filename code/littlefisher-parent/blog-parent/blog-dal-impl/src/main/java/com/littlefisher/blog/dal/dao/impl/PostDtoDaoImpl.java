package com.littlefisher.blog.dal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.littlefisher.blog.dal.dao.IPostDtoDao;
import com.littlefisher.blog.dal.example.PostDtoExample;
import com.littlefisher.blog.dal.mapper.PostDtoMapper;
import com.littlefisher.blog.dal.model.PostDto;
import com.littlefisher.blog.dal.param.SelectPost4PageByCondParam;
import com.littlefisher.core.mybatis.dao.AbstractBaseWithBlobDaoImpl;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;
import com.littlefisher.core.utils.StringUtil;

/**
 * Description: PostDtoDaoImpl
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class PostDtoDaoImpl extends AbstractBaseWithBlobDaoImpl<PostDto> implements IPostDtoDao {

    @Autowired
    private PostDtoMapper postDtoMapper;

    @Override
    public PageInfo<PostDto> selectPost4PageByCond(SelectPost4PageByCondParam param, PageParam pageParam) {
        PostDtoExample example = new PostDtoExample();
        PostDtoExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotBlank(param.getTitle())) {
            criteria.andTitleLike(param.getTitle());
        }
        if (param.getAuthorId() != null) {
            criteria.andAuthorIdEqualTo(param.getAuthorId());
        }
        if (param.getArchiveId() != null) {
            criteria.andArchiveIdEqualTo(param.getArchiveId());
        }
        if (param.getCreatedDateEnd() != null) {
            criteria.andCreatedDateGreaterThanOrEqualTo(param.getCreatedDateEnd());
        }
        if (param.getCreatedDateStart() != null) {
            criteria.andCreatedDateLessThanOrEqualTo(param.getCreatedDateStart());
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        return new PageInfo<>(postDtoMapper.selectByExample(example));
    }
}
