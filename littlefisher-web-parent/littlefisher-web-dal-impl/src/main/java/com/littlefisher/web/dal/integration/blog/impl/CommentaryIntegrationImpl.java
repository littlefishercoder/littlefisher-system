package com.littlefisher.web.dal.integration.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.blog.biz.model.CommentaryBizDto;
import com.littlefisher.blog.biz.model.CommentaryBizExtDto;
import com.littlefisher.blog.biz.request.AddCommentaryRequest;
import com.littlefisher.blog.biz.request.GetCommentaryList4PagerByCondRequest;
import com.littlefisher.blog.biz.request.UpdateCommentaryRequest;
import com.littlefisher.blog.biz.service.ICommentaryService;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.web.dal.integration.blog.ICommentaryIntegration;

/**
 * Description: CommentaryIntegrationImpl.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class CommentaryIntegrationImpl implements ICommentaryIntegration {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ICommentaryService commentaryService;

    @Override
    public PageInfo<CommentaryBizExtDto> getCommentaryList4PageByCond(GetCommentaryList4PagerByCondRequest req) {
        return commentaryService.getCommentaryList4PageByCond(req);
    }

    @Override
    public CommentaryBizDto getCommentaryById(Long commentaryId) {
        return commentaryService.getCommentaryById(commentaryId);
    }

    @Override
    public CommentaryBizDto addCommentary(AddCommentaryRequest request) {
        return commentaryService.addCommentary(request);
    }

    @Override
    public CommentaryBizDto updateCommentary(UpdateCommentaryRequest request) {
        return commentaryService.updateCommentary(request);
    }

    @Override
    public int deleteCommentary(Long commentaryId) {
        return commentaryService.deleteCommentary(commentaryId);
    }
}
