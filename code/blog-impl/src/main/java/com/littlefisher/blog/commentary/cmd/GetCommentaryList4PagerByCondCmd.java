package com.littlefisher.blog.commentary.cmd;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.littlefisher.blog.commentary.dao.CommentaryDtoMapper;
import com.littlefisher.blog.commentary.model.CommentaryDto;
import com.littlefisher.blog.commentary.model.request.GetCommentaryList4PagerByCondRequest;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * 
 * Description: 
 *  
 * Created on 2017年5月24日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class GetCommentaryList4PagerByCondCmd extends AbstractCommand<List<CommentaryDto>> {
    
    /**
     * req
     */
    private GetCommentaryList4PagerByCondRequest req;

    /** 
     * Description: 构造函数
     *
     * @author jinyanan
     *
     * @param req req 
     */ 
    public GetCommentaryList4PagerByCondCmd(GetCommentaryList4PagerByCondRequest req) {
        super();
        this.req = req;
    }

    @Override
    public List<CommentaryDto> execute() {
        CommentaryDtoMapper commentaryDtoMapper = this.getMapper(CommentaryDtoMapper.class);
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        return commentaryDtoMapper.selectByCond(req);
    }

}
