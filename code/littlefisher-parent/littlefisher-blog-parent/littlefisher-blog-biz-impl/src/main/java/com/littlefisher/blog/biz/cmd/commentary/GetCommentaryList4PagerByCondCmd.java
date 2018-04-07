package com.littlefisher.blog.biz.cmd.commentary;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.littlefisher.blog.biz.converter.CommentaryDtoConverter;
import com.littlefisher.blog.biz.model.CommentaryBizExtDto;
import com.littlefisher.blog.biz.request.GetCommentaryList4PagerByCondRequest;
import com.littlefisher.blog.dal.dao.ICommentaryDtoDao;
import com.littlefisher.blog.dal.integration.IUserIntegration;
import com.littlefisher.blog.dal.model.CommentaryDto;
import com.littlefisher.blog.dal.param.SelectCommentary4PageByCondParam;
import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;
import com.littlefisher.user.model.UserBizDto;

/**
 *
 * Description:
 *
 * Created on 2017年5月24日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetCommentaryList4PagerByCondCmd extends AbstractCommand<PageInfo<CommentaryBizExtDto>> {

    /**
     * req
     */
    private GetCommentaryList4PagerByCondRequest req;

    @Autowired
    private ICommentaryDtoDao commentaryDtoDao;

    @Autowired
    private IUserIntegration bizFrameworkIntegration;

    public GetCommentaryList4PagerByCondCmd setReq(GetCommentaryList4PagerByCondRequest req) {
        this.req = req;
        return this;
    }

    @Override
    public PageInfo<CommentaryBizExtDto> execute() {
        PageInfo<CommentaryDto> pageInfo = commentaryDtoDao.selectCommentary4PageByCond(
            SelectCommentary4PageByCondParam.Builder.getInstance().addPostId(req.getPostId())
                .addCreatedDateEnd(req.getCreatedDateEnd()).addCreatedDateStart(req.getCreatedDateStart())
                .addKeyword(req.getKeyword()).build(),
            PageParam.Builder.getInstance().addPageNum(req.getPageNum()).addPageSize(req.getPageSize()).build());

        Map<Long, UserBizDto> userMap = getUserMap(pageInfo.getList());

        return new PageInfo<>(pageInfo,
            commentaryDto -> CommentaryBizExtDto.Builder.getInstance()
                .addCommentaryBizDto(CommentaryDtoConverter.convert2CommentaryBizDto(commentaryDto))
                .addUserBizDto(userMap.get(commentaryDto.getUserId())).build());
    }

    private Map<Long, UserBizDto> getUserMap(List<CommentaryDto> commentaryList) {
        Map<Long, UserBizDto> userMap = Maps.newHashMapWithExpectedSize(commentaryList.size());
        List<Long> userIdList
            = Lists.newArrayList(Iterators.transform(commentaryList.iterator(), CommentaryDto::getUserId));
        List<UserBizDto> userList = bizFrameworkIntegration.getUserByIdList(userIdList);
        userList.forEach(user -> userMap.put(user.getId(), user));
        return userMap;
    }
}
