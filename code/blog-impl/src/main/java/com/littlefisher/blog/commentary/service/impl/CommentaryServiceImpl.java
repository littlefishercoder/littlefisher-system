package com.littlefisher.blog.commentary.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.commentary.cmd.AddCommentaryCmd;
import com.littlefisher.blog.commentary.cmd.DeleteCommentaryCmd;
import com.littlefisher.blog.commentary.cmd.GetAllCommentaryStateCmd;
import com.littlefisher.blog.commentary.cmd.GetCommentaryByIdCmd;
import com.littlefisher.blog.commentary.cmd.GetCommentaryList4PagerByCondCmd;
import com.littlefisher.blog.commentary.cmd.UpdateCommentaryCmd;
import com.littlefisher.blog.commentary.model.CommentaryDto;
import com.littlefisher.blog.commentary.model.CommentaryStateDto;
import com.littlefisher.blog.commentary.model.request.GetCommentaryList4PagerByCondRequest;
import com.littlefisher.blog.commentary.service.ICommentaryService;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.service.ServiceImpl;

/**
 * 
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
    public List<CommentaryDto> getCommentaryList4PagerByCond(GetCommentaryList4PagerByCondRequest req)
        throws BaseAppException {
        return this.execute(new GetCommentaryList4PagerByCondCmd(req));
    }

    @Override
    public CommentaryDto getCommentaryById(Long commentaryId) throws BaseAppException {
        return this.execute(new GetCommentaryByIdCmd(commentaryId));
    }

    @Override
    public CommentaryDto addCommentary(CommentaryDto commentaryDto) throws BaseAppException {
        return this.execute(new AddCommentaryCmd(commentaryDto));
    }

    @Override
    public CommentaryDto updateCommentary(CommentaryDto commentaryDto) throws BaseAppException {
        return this.execute(new UpdateCommentaryCmd(commentaryDto));
    }

    @Override
    public int deleteCommentary(Long commentaryId) throws BaseAppException {
        return this.execute(new DeleteCommentaryCmd(commentaryId));
    }

    @Override
    public List<CommentaryStateDto> getAllCommentaryState() throws BaseAppException {
        return this.execute(new GetAllCommentaryStateCmd());
    }
    
}
