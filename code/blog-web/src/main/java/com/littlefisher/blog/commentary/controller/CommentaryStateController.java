package com.littlefisher.blog.commentary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.commentary.model.CommentaryStateDto;
import com.littlefisher.blog.commentary.service.ICommentaryStateService;
import com.littlefisher.core.exception.BaseAppException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Description: 评价状态Controller
 *  
 * Created on 2017年5月25日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping("/api/blog/v1/commentary/commentaryStates")
@Api(value = "commentaryStates", description = "commentaryStates 接口API")
public class CommentaryStateController {
    
    /**
     * commentaryStateService
     */
    @Autowired
    private ICommentaryStateService commentaryStateService;

    /**
     * 
     * Description: 查询所有评价类型
     * 
     * @author jinyanan
     *
     * @return List<CommentaryStateDto>
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation("查询所有评价类型")
    public List<CommentaryStateDto> getAllCommentaryState() throws BaseAppException {
        return commentaryStateService.getAllCommentaryState();
    }

    /**
     * 
     * Description: 新增评价类型
     * 
     * @author jinyanan
     *
     * @param commentaryStateDto commentaryStateDto
     * @return CommentaryStateDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("新增评价类型")
    public CommentaryStateDto addCommentaryState(
        @ApiParam(required = true, value = "评价类型实体") @RequestBody CommentaryStateDto commentaryStateDto) throws BaseAppException {
        return commentaryStateService.addCommentaryState(commentaryStateDto);
    }

    /**
     * 
     * Description: 修改评价类型
     * 
     * @author jinyanan
     *
     * @param commentaryStateDto commentaryStateDto
     * @return CommentaryStateDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation("修改评价类型")
    public CommentaryStateDto updateCommentaryState(
        @ApiParam(required = true, value = "评价类型实体") @RequestBody CommentaryStateDto commentaryStateDto) throws BaseAppException {
        return commentaryStateService.updateCommentaryState(commentaryStateDto);
    }

    /**
     * 
     * Description: 删除评价类型
     * 
     * @author jinyanan
     *
     * @param state state
     * @return int
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/{state}", method = RequestMethod.DELETE)
    @ApiOperation("删除评价类型")
    public int deleteCommentaryState(
        @ApiParam(required = true, value = "评价类型") @PathVariable("state") String state) throws BaseAppException {
        return commentaryStateService.deleteCommentaryState(state);
    }
}
