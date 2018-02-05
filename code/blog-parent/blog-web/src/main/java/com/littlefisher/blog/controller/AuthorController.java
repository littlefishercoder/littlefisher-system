package com.littlefisher.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.oval.constraint.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.model.FriendLinkDto;
import com.littlefisher.blog.model.ext.AuthorExtDto;
import com.littlefisher.blog.service.IAuthorService;
import com.littlefisher.blog.service.IFriendLinkService;
import com.littlefisher.core.stereotype.constants.BaseConstants;

/**
 * Description: AuthorController.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping(BaseConstants.BASE_API_PREFIX + "/blog/v1/authors")
@Api(value = "author", description = "author 接口API")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @Autowired
    private IFriendLinkService friendLinkService;

    /**
     * 首页作者详情
     * @param authorId 作者id
     * @return 作者详情
     */
    @RequestMapping(value = "/index/{authorId}", method = RequestMethod.GET)
    @ApiOperation("首页作者详情")
    public AuthorExtDto getAuthorInfo4Index(
            @ApiParam(required = true, value = "作者主键") @PathVariable("authorId") @NotNull(message = "用户id不能为空")
            @NotBlank(message = "用户id不能为空") Long authorId) {
        // 首页作者详情
        return authorService.getAuthorInfo4Index(authorId);
    }

    /**
     * 作者友情链接
     * @param authorId 作者id
     * @return 友情链接
     */
    @RequestMapping(value = "/{authorId}/friendLinks", method = RequestMethod.GET)
    @ApiOperation("作者友情链接")
    public List<FriendLinkDto> getFriendLinkList(
            @ApiParam(required = true, value = "作者主键") @PathVariable("authorId") @NotNull(message = "用户id不能为空")
            @NotBlank(message = "用户id不能为空") Long authorId) {
        // 作者友情链接
        return friendLinkService.getFriendLinkList(authorId);
    }
}
