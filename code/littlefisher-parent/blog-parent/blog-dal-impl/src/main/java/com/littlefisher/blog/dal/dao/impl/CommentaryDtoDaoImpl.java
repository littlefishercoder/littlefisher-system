package com.littlefisher.blog.dal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.littlefisher.blog.dal.dao.ICommentaryDtoDao;
import com.littlefisher.blog.dal.example.CommentaryDtoExample;
import com.littlefisher.blog.dal.mapper.CommentaryDtoMapper;
import com.littlefisher.blog.dal.model.CommentaryDto;
import com.littlefisher.blog.dal.param.SelectCommentary4PageByCondParam;
import com.littlefisher.core.mybatis.dao.AbstractBaseDaoImpl;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;
import com.littlefisher.core.utils.StringUtil;

/**
 *
 * @author jinyn22648
 * @version $$Id: CommentaryDtoDaoImpl.java, v 0.1 2018/3/27 下午3:41 jinyn22648 Exp $$
 */
@Repository
public class CommentaryDtoDaoImpl extends AbstractBaseDaoImpl<CommentaryDto, CommentaryDtoMapper> implements ICommentaryDtoDao {

    @Autowired
    private CommentaryDtoMapper commentaryDtoMapper;

    @Override
    public PageInfo<CommentaryDto> selectCommentary4PageByCond(SelectCommentary4PageByCondParam param,
        PageParam pageParam) {
        CommentaryDtoExample example = new CommentaryDtoExample();
        CommentaryDtoExample.Criteria criteria = example.createCriteria();
        if (param.getPostId() != null) {
            criteria.andPostIdEqualTo(param.getPostId());
        }
        if (StringUtil.isNotBlank(param.getKeyword())) {
            // TODO: 对keyword做查询
        }
        if (param.getCreatedDateStart() != null) {
            criteria.andCreatedDateGreaterThanOrEqualTo(param.getCreatedDateStart());
        }
        if (param.getCreatedDateEnd() != null) {
            criteria.andCreatedDateLessThanOrEqualTo(param.getCreatedDateEnd());
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        return new PageInfo<>(commentaryDtoMapper.selectByExample(example));
    }
}
