package com.littlefisher.blog.commentary.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.commentary.cmd.AddCommentaryStateCmd;
import com.littlefisher.blog.commentary.cmd.DeleteCommentaryStateCmd;
import com.littlefisher.blog.commentary.cmd.GetAllCommentaryStateCmd;
import com.littlefisher.blog.commentary.cmd.UpdateCommentaryStateCmd;
import com.littlefisher.blog.commentary.model.CommentaryStateDto;
import com.littlefisher.blog.commentary.service.ICommentaryStateService;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * Description:
 *
 * Created on 2017年5月25日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class CommentaryStateServiceImpl extends ServiceImpl implements ICommentaryStateService {

    @Override
    public List<CommentaryStateDto> getAllCommentaryState() {
        return this.execute(new GetAllCommentaryStateCmd());
    }

    @Override
    public CommentaryStateDto addCommentaryState(CommentaryStateDto commentaryStateDto) {
        return this.execute(new AddCommentaryStateCmd(commentaryStateDto));
    }

    @Override
    public CommentaryStateDto updateCommentaryState(CommentaryStateDto commentaryStateDto) {
        return this.execute(new UpdateCommentaryStateCmd(commentaryStateDto));
    }

    @Override
    public int deleteCommentaryState(String state) {
        return this.execute(new DeleteCommentaryStateCmd(state));
    }

}
