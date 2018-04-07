package com.littlefisher.blog.dal.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.blog.dal.dao.IAuthorDtoDao;
import com.littlefisher.blog.dal.example.AuthorDtoExample;
import com.littlefisher.blog.dal.mapper.AuthorDtoMapper;
import com.littlefisher.blog.dal.model.AuthorDto;
import com.littlefisher.core.mybatis.dao.AbstractBaseDaoImpl;

/**
 * Description: AuthorDtoDaoImpl
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class AuthorDtoDaoImpl extends AbstractBaseDaoImpl<AuthorDto, AuthorDtoMapper> implements IAuthorDtoDao {

    @Autowired
    private AuthorDtoMapper authorDtoMapper;

    @Override
    public List<AuthorDto> selectAuthorByAuthorIdList(List<Long> authorIdList) {
        AuthorDtoExample example = new AuthorDtoExample();
        example.createCriteria().andIdIn(authorIdList);
        return authorDtoMapper.selectByExample(example);
    }
}
