package com.littlefisher.blog.service.impl.commentary;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.commentary.AddCommentaryStateCmd;
import com.littlefisher.blog.cmd.commentary.DeleteCommentaryStateCmd;
import com.littlefisher.blog.cmd.commentary.GetAllCommentaryStateCmd;
import com.littlefisher.blog.cmd.commentary.UpdateCommentaryStateCmd;
import com.littlefisher.blog.intf.commentary.ICommentaryStateService;
import com.littlefisher.blog.model.commentary.CommentaryStateDto;
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
