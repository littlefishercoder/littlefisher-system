package com.littlefisher.blog.cmd.tag;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.littlefisher.blog.dao.ext.TagDtoExtMapper;
import com.littlefisher.blog.model.TagDto;
import com.littlefisher.blog.request.GetTagList4PagerByCondRequest;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description: GetTagList4PagerByCondCommand.java
 *
 * Created on 2017年12月27日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class GetTagList4PagerByCondCommand extends AbstractCommand<List<TagDto>> {

    private GetTagList4PagerByCondRequest request;

    public GetTagList4PagerByCondCommand(GetTagList4PagerByCondRequest request) {
        this.request = request;
    }

    @Override
    public List<TagDto> execute() {
        TagDtoExtMapper mapper = this.getMapper(TagDtoExtMapper.class);
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        return mapper.selectByCond(request);
    }
}
