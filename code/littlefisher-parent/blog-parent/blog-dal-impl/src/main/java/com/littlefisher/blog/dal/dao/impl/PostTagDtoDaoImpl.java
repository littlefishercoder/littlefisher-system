package com.littlefisher.blog.dal.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.blog.dal.dao.IPostTagDtoDao;
import com.littlefisher.blog.dal.example.PostTagDtoExample;
import com.littlefisher.blog.dal.mapper.PostTagDtoMapper;
import com.littlefisher.blog.dal.model.PostTagDto;
import com.littlefisher.core.mybatis.dao.AbstractBaseDaoImpl;

/**
 * Description: PostTagDtoDaoImpl
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class PostTagDtoDaoImpl extends AbstractBaseDaoImpl<PostTagDto, PostTagDtoMapper> implements IPostTagDtoDao {

    @Autowired
    private PostTagDtoMapper postTagDtoMapper;

    @Override
    public List<PostTagDto> selectByPostIdList(List<Long> postIdList) {
        PostTagDtoExample example = new PostTagDtoExample();
        example.createCriteria().andPostIdIn(postIdList);
        return postTagDtoMapper.selectByExample(example);
    }
}
