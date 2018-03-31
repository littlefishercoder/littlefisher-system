package com.littlefisher.blog.biz.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.littlefisher.blog.biz.cmd.commentary.AddCommentaryCmd;
import com.littlefisher.blog.biz.cmd.commentary.DeleteCommentaryCmd;
import com.littlefisher.blog.biz.cmd.commentary.GetCommentaryByIdCmd;
import com.littlefisher.blog.biz.cmd.commentary.GetCommentaryList4PagerByCondCmd;
import com.littlefisher.blog.biz.cmd.commentary.UpdateCommentaryCmd;
import com.littlefisher.blog.biz.model.CommentaryBizDto;
import com.littlefisher.blog.biz.model.CommentaryBizExtDto;
import com.littlefisher.blog.biz.request.AddCommentaryRequest;
import com.littlefisher.blog.biz.request.GetCommentaryList4PagerByCondRequest;
import com.littlefisher.blog.biz.request.UpdateCommentaryRequest;
import com.littlefisher.blog.biz.service.ICommentaryService;
import com.littlefisher.core.interceptor.service.ServiceImpl;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
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
@Service(interfaceClass = ICommentaryService.class)
public class CommentaryServiceImpl extends ServiceImpl implements ICommentaryService {

    @Override
    public PageInfo<CommentaryBizExtDto> getCommentaryList4PageByCond(GetCommentaryList4PagerByCondRequest req) {
        return this.execute(getCommand(GetCommentaryList4PagerByCondCmd.class).setReq(req));
    }

    @Override
    public CommentaryBizDto getCommentaryById(Long commentaryId) {
        return this.execute(getCommand(GetCommentaryByIdCmd.class).setCommentaryId(commentaryId));
    }

    @Override
    public CommentaryBizDto addCommentary(AddCommentaryRequest request) {
        CommentaryBizDto commentaryDto = new CommentaryBizDto();
        commentaryDto.setParentCommentaryId(request.getParentCommentaryId());
        commentaryDto.setUserId(request.getUserId());
        commentaryDto.setNickName(request.getNickName());
        commentaryDto.setCommentaryIp(request.getCommentaryIp());
        commentaryDto.setPostId(request.getPostId());
        commentaryDto.setContent(request.getContent());
        return this.execute(getCommand(AddCommentaryCmd.class).setCommentaryDto(commentaryDto));
    }

    @Override
    public CommentaryBizDto updateCommentary(UpdateCommentaryRequest request) {
        CommentaryBizDto commentaryDto = this.getCommentaryById(request.getId());
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
