package com.littlefisher.blog.biz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.littlefisher.blog.biz.model.CommentaryBizDto;
import com.littlefisher.blog.biz.model.CommentaryBizExtDto;
import com.littlefisher.blog.biz.request.AddCommentaryRequest;
import com.littlefisher.blog.biz.request.GetCommentaryList4PagerByCondRequest;
import com.littlefisher.blog.biz.request.UpdateCommentaryRequest;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.spring.cloud.feign.annotation.JsonArgument;

/**
 * Description: 评价接口
 *
 * Created on 2017年5月22日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@FeignClient(value = "commentary-service", path = "/commentaries")
public interface ICommentaryService {

    /**
     * Description: 根据条件查询评价列表
     *
     * @param req req
     * @return 评价列表
     */
    @GetMapping("/page")
    PageInfo<CommentaryBizExtDto>
        getCommentaryList4PageByCond(@JsonArgument("request") GetCommentaryList4PagerByCondRequest req);

    /**
     * Description: 根据主键查询评价
     *
     * @param commentaryId commentaryId
     * @return CommentaryDto
     */
    @GetMapping("/{commentaryId}")
    CommentaryBizDto getCommentaryById(@PathVariable("commentaryId") Long commentaryId);

    /**
     * Description: 新增评价
     *
     * @param request commentaryDto
     * @return CommentaryDto
     */
    @PostMapping
    CommentaryBizDto addCommentary(@RequestBody AddCommentaryRequest request);

    /**
     * Description: 修改评价
     *
     * @param request commentaryDto
     * @return CommentaryDto
     */
    @PatchMapping
    CommentaryBizDto updateCommentary(@RequestBody UpdateCommentaryRequest request);

    /**
     * Description: 删除评价
     *
     * @param commentaryId commentaryId
     * @return int
     */
    @DeleteMapping("/{commentaryId}")
    int deleteCommentary(@PathVariable("commentaryId") Long commentaryId);

}
