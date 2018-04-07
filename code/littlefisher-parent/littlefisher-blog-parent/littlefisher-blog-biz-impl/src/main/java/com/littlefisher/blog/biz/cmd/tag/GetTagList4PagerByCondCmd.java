package com.littlefisher.blog.biz.cmd.tag;


import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.converter.TagDtoConverter;
import com.littlefisher.blog.biz.model.TagBizDto;
import com.littlefisher.blog.biz.request.GetTagList4PageByCondRequest;
import com.littlefisher.blog.dal.dao.ITagDtoDao;
import com.littlefisher.blog.dal.model.TagDto;
import com.littlefisher.blog.dal.param.SelectTag4PageByCondParam;
import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;

/**
 * Description: GetTagList4PagerByCondCmd.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetTagList4PagerByCondCmd extends AbstractCommand<PageInfo<TagBizDto>> {

    /** request */
    private GetTagList4PageByCondRequest request;

    @Autowired
    private ITagDtoDao tagDtoDao;

    public GetTagList4PagerByCondCmd setRequest(GetTagList4PageByCondRequest request) {
        this.request = request;
        return this;
    }

    @Override
    public PageInfo<TagBizDto> execute() {
        PageInfo<TagDto> pageInfo = tagDtoDao.selectTag4PageByCond(SelectTag4PageByCondParam.Builder.getInstance().build(),
                PageParam.Builder.getInstance().addPageNum(request.getPageNum()).addPageSize(request.getPageSize()).build());
        return new PageInfo<>(pageInfo, TagDtoConverter::convert2TagBizDto);
    }
}
