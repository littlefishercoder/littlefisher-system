package com.littlefisher.blog.cmd.commentary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.littlefisher.blog.dao.ext.CommentaryDtoExtMapper;
import com.littlefisher.blog.model.ext.CommentaryExtDto;
import com.littlefisher.blog.request.GetCommentaryList4PagerByCondRequest;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

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
@Command
public class GetCommentaryList4PagerByCondCmd extends AbstractCommand<List<CommentaryExtDto>> {

    /**
     * req
     */
    private GetCommentaryList4PagerByCondRequest req;

    @Autowired
    private CommentaryDtoExtMapper commentaryDtoMapper;

    public GetCommentaryList4PagerByCondCmd setReq(GetCommentaryList4PagerByCondRequest req) {
        this.req = req;
        return this;
    }

    @Override
    public List<CommentaryExtDto> execute() {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        return commentaryDtoMapper.selectByCond(req);
    }
}
