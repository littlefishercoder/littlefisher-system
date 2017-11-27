package com.littlefisher.blog.cmd.post;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.littlefisher.blog.dao.post.PostDtoMapper;
import com.littlefisher.blog.model.post.PostDto;
import com.littlefisher.blog.request.post.GetPostList4PagerByCondRequest;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description:
 *
 * Created on 2017年5月23日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class GetPostList4PagerByCondCmd extends AbstractCommand<List<PostDto>> {

    /**
     * req
     */
    private GetPostList4PagerByCondRequest req;

    /**
     * Description: 构造函数
     *
     * @param req req
     */
    public GetPostList4PagerByCondCmd(GetPostList4PagerByCondRequest req) {
        super();
        this.req = req;
    }

    @Override
    public List<PostDto> execute() {
        PostDtoMapper postDtoMapper = this.getMapper(PostDtoMapper.class);
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        return postDtoMapper.selectByCond(req);
    }

}
