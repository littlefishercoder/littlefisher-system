package com.littlefisher.blog.dal.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.littlefisher.blog.dal.dao.ITagDtoDao;
import com.littlefisher.blog.dal.example.TagDtoExample;
import com.littlefisher.blog.dal.mapper.TagDtoMapper;
import com.littlefisher.blog.dal.model.TagDto;
import com.littlefisher.blog.dal.param.SelectTag4PageByCondParam;
import com.littlefisher.core.mybatis.dao.AbstractBaseDaoImpl;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;

/**
 *
 * @author jinyn22648
 * @version $$Id: TagDtoDaoImpl.java, v 0.1 2018/3/27 下午8:56 jinyn22648 Exp $$
 */
@Repository
public class TagDtoDaoImpl extends AbstractBaseDaoImpl<TagDto, TagDtoMapper> implements ITagDtoDao {

    @Autowired
    private TagDtoMapper tagDtoMapper;

    @Override
    public PageInfo<TagDto> selectTag4PageByCond(SelectTag4PageByCondParam param,
            PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        return new PageInfo<>(tagDtoMapper.selectAll());
    }

    @Override
    public List<TagDto> selectByTagIdList(List<Long> tagIdList) {
        TagDtoExample example = new TagDtoExample();
        example.createCriteria().andIdIn(tagIdList);
        return tagDtoMapper.selectByExample(example);
    }
}
