package com.littlefisher.blog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.commentary.AddCommentaryCmd;
import com.littlefisher.blog.cmd.commentary.DeleteCommentaryCmd;
import com.littlefisher.blog.cmd.commentary.GetCommentaryByIdCmd;
import com.littlefisher.blog.cmd.commentary.GetCommentaryList4PagerByCondCmd;
import com.littlefisher.blog.cmd.commentary.UpdateCommentaryCmd;
import com.littlefisher.blog.request.AddCommentaryRequest;
import com.littlefisher.blog.request.UpdateCommentaryRequest;
import com.littlefisher.blog.service.ICommentaryService;
import com.littlefisher.blog.model.CommentaryDto;
import com.littlefisher.blog.model.ext.CommentaryExtDto;
import com.littlefisher.blog.request.GetCommentaryList4PagerByCondRequest;
import com.littlefisher.core.interceptor.service.ServiceImpl;
import com.littlefisher.core.utils.DateUtil;

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
    public List<CommentaryExtDto> getCommentaryList4PagerByCond(GetCommentaryList4PagerByCondRequest req) {
        return this.execute(getCommand(GetCommentaryList4PagerByCondCmd.class).setReq(req));
    }

    @Override
    public CommentaryDto getCommentaryById(Long commentaryId) {
        return this.execute(getCommand(GetCommentaryByIdCmd.class).setCommentaryId(commentaryId));
    }

    @Override
    public CommentaryDto addCommentary(AddCommentaryRequest request) {
        CommentaryDto commentaryDto = new CommentaryDto();
        commentaryDto.setParentCommentaryId(request.getParentCommentaryId());
        commentaryDto.setUserId(request.getUserId());
        commentaryDto.setNickName(request.getNickName());
        commentaryDto.setCommentaryIp(request.getCommentaryIp());
        commentaryDto.setPostId(request.getPostId());
        commentaryDto.setContent(request.getContent());
        return this.execute(getCommand(AddCommentaryCmd.class).setCommentaryDto(commentaryDto));
    }

    @Override
    public CommentaryDto updateCommentary(UpdateCommentaryRequest request) {
        CommentaryDto commentaryDto = this.getCommentaryById(request.getId());
        if (request.getState() != null) {
            commentaryDto.setState(request.getState());
            commentaryDto.setStateDate(DateUtil.getDBDateTime());
        }
        commentaryDto.setContent(request.getContent());
        commentaryDto.setUpdateDate(DateUtil.getDBDateTime());
        return this.execute(getCommand(UpdateCommentaryCmd.class).setCommentaryDto(commentaryDto));
    }

    @Override
    public int deleteCommentary(Long commentaryId) {
        return this.execute(getCommand(DeleteCommentaryCmd.class).setCommentaryId(commentaryId));
    }

}
