package com.littlefisher.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.biz.model.AuthorBizExtDto;
import com.littlefisher.blog.biz.model.FriendLinkBizDto;
import com.littlefisher.core.stereotype.constants.BaseConstants;
import com.littlefisher.web.dal.integration.blog.IAuthorIntegration;
import com.littlefisher.web.dal.integration.blog.IFriendLinkIntegration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.oval.constraint.NotBlank;

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
    private IAuthorIntegration authorIntegration;

    @Autowired
    private IFriendLinkIntegration friendLinkIntegration;

    /**
     * 首页作者详情
     * @param authorId 作者id
     * @return 作者详情
     */
    @RequestMapping(value = "/index/{authorId}", method = RequestMethod.GET)
    @ApiOperation("首页作者详情")
    public AuthorBizExtDto getAuthorInfo4Index(
            @ApiParam(required = true, value = "作者主键") @PathVariable("authorId") @NotNull(message = "用户id不能为空")
            @NotBlank(message = "用户id不能为空") Long authorId) {
        // 首页作者详情
        return authorIntegration.getAuthorInfo4Index(authorId);
    }

    /**
     * 作者友情链接
     * @param authorId 作者id
     * @return 友情链接
     */
    @RequestMapping(value = "/{authorId}/friendLinks", method = RequestMethod.GET)
    @ApiOperation("作者友情链接")
    public List<FriendLinkBizDto> getFriendLinkList(
            @ApiParam(required = true, value = "作者主键") @PathVariable("authorId") @NotNull(message = "用户id不能为空")
            @NotBlank(message = "用户id不能为空") Long authorId) {
        // 作者友情链接
        return friendLinkIntegration.getFriendLinkList(authorId);
    }
}
