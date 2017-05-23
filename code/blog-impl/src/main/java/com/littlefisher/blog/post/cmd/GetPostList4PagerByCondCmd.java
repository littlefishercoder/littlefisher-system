package com.littlefisher.blog.post.cmd;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.littlefisher.blog.post.dao.PostDtoMapper;
import com.littlefisher.blog.post.model.PostDto;
import com.littlefisher.blog.post.model.request.GetPostList4PagerByCondRequest;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * 
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
     * 
     * Description: 
     *
     * @author jinyanan
     *
     * @param req req
     */
    public GetPostList4PagerByCondCmd(GetPostList4PagerByCondRequest req) {
        super();
        this.req = req;
    }

    @Override
    public List<PostDto> execute() throws BaseAppException {
        PostDtoMapper postDtoMapper = this.getMapper(PostDtoMapper.class);
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        return postDtoMapper.selectByCond(req);
    }

}
