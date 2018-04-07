package com.littlefisher.blog.biz.service;

import com.littlefisher.blog.biz.model.CommentaryBizDto;
import com.littlefisher.blog.biz.model.CommentaryBizExtDto;
import com.littlefisher.blog.biz.request.AddCommentaryRequest;
import com.littlefisher.blog.biz.request.GetCommentaryList4PagerByCondRequest;
import com.littlefisher.blog.biz.request.UpdateCommentaryRequest;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;

/**
 * Description: 评价接口
 *
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ICommentaryService {

    /**
     * Description: 根据条件查询评价列表
     *
     * @param req req
     * @return List<CommentaryExtDto>
     */
    PageInfo<CommentaryBizExtDto> getCommentaryList4PageByCond(GetCommentaryList4PagerByCondRequest req);

    /**
     * Description: 根据主键查询评价
     *
     * @param commentaryId commentaryId
     * @return CommentaryDto
     */
    CommentaryBizDto getCommentaryById(Long commentaryId);

    /**
     * Description: 新增评价
     *
     * @param request commentaryDto
     * @return CommentaryDto
     */
    CommentaryBizDto addCommentary(AddCommentaryRequest request);

    /**
     * Description: 修改评价
     *
     * @param request commentaryDto
     * @return CommentaryDto
     */
    CommentaryBizDto updateCommentary(UpdateCommentaryRequest request);

    /**
     * Description: 删除评价
     *
     * @param commentaryId commentaryId
     * @return int
     */
    int deleteCommentary(Long commentaryId);

}
