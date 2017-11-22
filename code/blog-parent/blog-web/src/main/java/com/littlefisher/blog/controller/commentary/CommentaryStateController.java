package com.littlefisher.blog.controller.commentary;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.intf.commentary.ICommentaryStateService;
import com.littlefisher.blog.model.commentary.CommentaryStateDto;

/**
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
     * Description: 查询所有评价类型
     *
     * @return List<CommentaryStateDto>
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation("查询所有评价类型")
    public List<CommentaryStateDto> getAllCommentaryState() {
        return commentaryStateService.getAllCommentaryState();
    }

    /**
     * Description: 新增评价类型
     *
     * @param commentaryStateDto commentaryStateDto
     * @return CommentaryStateDto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("新增评价类型")
    public CommentaryStateDto addCommentaryState(
            @ApiParam(required = true, value = "评价类型实体") @RequestBody CommentaryStateDto commentaryStateDto) {
        return commentaryStateService.addCommentaryState(commentaryStateDto);
    }

    /**
     * Description: 修改评价类型
     *
     * @param commentaryStateDto commentaryStateDto
     * @return CommentaryStateDto
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation("修改评价类型")
    public CommentaryStateDto updateCommentaryState(
            @ApiParam(required = true, value = "评价类型实体") @RequestBody CommentaryStateDto commentaryStateDto) {
        return commentaryStateService.updateCommentaryState(commentaryStateDto);
    }

    /**
     * Description: 删除评价类型
     *
     * @param state state
     * @return int
     */
    @RequestMapping(value = "/{state}", method = RequestMethod.DELETE)
    @ApiOperation("删除评价类型")
    public int deleteCommentaryState(
            @ApiParam(required = true, value = "评价类型") @PathVariable("state") String state) {
        return commentaryStateService.deleteCommentaryState(state);
    }
}
