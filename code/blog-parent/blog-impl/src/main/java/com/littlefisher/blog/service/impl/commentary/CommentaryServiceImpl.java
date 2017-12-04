package com.littlefisher.blog.service.impl.commentary;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.commentary.AddCommentaryCmd;
import com.littlefisher.blog.cmd.commentary.DeleteCommentaryCmd;
import com.littlefisher.blog.cmd.commentary.GetCommentaryByIdCmd;
import com.littlefisher.blog.cmd.commentary.GetCommentaryList4PagerByCondCmd;
import com.littlefisher.blog.cmd.commentary.UpdateCommentaryCmd;
import com.littlefisher.blog.intf.commentary.ICommentaryService;
import com.littlefisher.blog.model.commentary.CommentaryDto;
import com.littlefisher.blog.request.commentary.GetCommentaryList4PagerByCondRequest;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * Description: 评价Service
 *
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class CommentaryServiceImpl extends ServiceImpl implements ICommentaryService {

    @Override
    public List<CommentaryDto> getCommentaryList4PagerByCond(
            GetCommentaryList4PagerByCondRequest req) {
        return this.execute(new GetCommentaryList4PagerByCondCmd(req));
    }

    @Override
    public CommentaryDto getCommentaryById(Long commentaryId) {
        return this.execute(new GetCommentaryByIdCmd(commentaryId));
    }

    @Override
    public CommentaryDto addCommentary(CommentaryDto commentaryDto) {
        return this.execute(new AddCommentaryCmd(commentaryDto));
    }

    @Override
    public CommentaryDto updateCommentary(CommentaryDto commentaryDto) {
        return this.execute(new UpdateCommentaryCmd(commentaryDto));
    }

    @Override
    public int deleteCommentary(Long commentaryId) {
        return this.execute(new DeleteCommentaryCmd(commentaryId));
    }

}
