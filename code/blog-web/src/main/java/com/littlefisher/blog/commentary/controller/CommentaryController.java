package com.littlefisher.blog.commentary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.littlefisher.blog.commentary.model.CommentaryDto;
import com.littlefisher.blog.commentary.model.request.GetCommentaryList4PagerByCondRequest;
import com.littlefisher.blog.commentary.service.ICommentaryService;
import com.littlefisher.core.exception.BaseAppException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Description: 评价Controller
 *  
 * Created on 2017年5月22日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping("api/blog/v1/commentaries")
@Api(value = "commentary", description = "commentary 接口API")
public class CommentaryController {
    
    /**
     * commentaryService
     */
    @Autowired
    private ICommentaryService commentaryService;

    /**
     * 
     * Description: 查询评价列表，分页用
     * 
     * @author jinyanan
     *
     * @param req req
     * @return PageInfo<CommentaryDto>
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation("查询评价列表，分页用")
    public PageInfo<CommentaryDto> getCommentaryList4PagerByCond(
        @ApiParam(required = true, value = "查询评价列表条件") @ModelAttribute GetCommentaryList4PagerByCondRequest req) throws BaseAppException {
        List<CommentaryDto> commentaryList = commentaryService.getCommentaryList4PagerByCond(req);
        return new PageInfo<>(commentaryList);
    }
    
    /**
     * 
     * Description: 根据主键查询评价
     * 
     * @author jinyanan
     *
     * @param commentaryId commentaryId
     * @return CommentaryDto
     * @throws BaseAppException <br>
     */
    public CommentaryDto getCommentaryById(
        @ApiParam(required = true, value = "评价主键") @PathVariable("commentaryId") Long commentaryId) throws BaseAppException {
        return commentaryService.getCommentaryById(commentaryId);
    }
    
    /**
     * 
     * Description: 新增评价
     * 
     * @author jinyanan
     *
     * @param commentaryDto commentaryDto
     * @return CommentaryDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("新增评价")
    public CommentaryDto addCommentary(
        @ApiParam(required = true, value = "评价实体") @RequestBody CommentaryDto commentaryDto) throws BaseAppException {
        return commentaryService.addCommentary(commentaryDto);
    }
    
    /**
     * 
     * Description: 修改评价
     * 
     * @author jinyanan
     *
     * @param commentaryDto commentaryDto
     * @return CommentaryDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation("修改评价")
    public CommentaryDto updateCommentary(
        @ApiParam(required = true, value = "评价实体") @RequestBody CommentaryDto commentaryDto) throws BaseAppException {
        return commentaryService.updateCommentary(commentaryDto);
    }
    
    /**
     * 
     * Description: 删除评价
     * 
     * @author jinyanan
     *
     * @param commentaryId commentaryId
     * @return int
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/{commentaryId}", method = RequestMethod.DELETE)
    @ApiOperation("删除评价")
    public int deleteCommentary(
        @ApiParam(required = true, value = "评价主键") @PathVariable("commentaryId") Long commentaryId) throws BaseAppException {
        return commentaryService.deleteCommentary(commentaryId);
    }
}
