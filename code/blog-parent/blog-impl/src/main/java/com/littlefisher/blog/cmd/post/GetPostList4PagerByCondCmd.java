package com.littlefisher.blog.cmd.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.littlefisher.blog.dao.ext.PostDtoExtMapper;
import com.littlefisher.blog.model.ext.PostExtDto;
import com.littlefisher.blog.request.GetPostList4PagerByCondRequest;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;

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

    public GetPostList4PagerByCondCmd setReq(GetPostList4PagerByCondRequest req) {
        this.req = req;
        return this;
    }

    @Override
    public List<PostExtDto> execute() {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        return postDtoMapper.selectByCond(req);
    }

}
