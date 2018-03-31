package com.littlefisher.user.cmd.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.user.converter.UserDtoConverter;
import com.littlefisher.user.dal.dao.IUserDtoDao;
import com.littlefisher.user.dal.model.UserDto;
import com.littlefisher.user.dal.param.SelectUser4PageByCondParam;
import com.littlefisher.user.model.UserBizDto;
import com.littlefisher.user.request.GetUserList4PageByCondRequest;

/**
 * Description:
 *
 * Created on 2017年5月24日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetUserListByCondCmd extends AbstractCommand<PageInfo<UserBizDto>> {

    /**
     * req
     */
    private GetUserList4PageByCondRequest req;

    @Autowired
    private IUserDtoDao userDtoDao;

    public GetUserListByCondCmd setReq(GetUserList4PageByCondRequest req) {
        this.req = req;
        return this;
    }

    @Override
    public PageInfo<UserBizDto> execute() {
        PageInfo<UserDto> pageInfo = userDtoDao.selectUser4PageByCondParam(
            SelectUser4PageByCondParam.Builder.getInstance().addAccNbr(req.getAccNbr()).addRealName(req.getRealName())
                .addNickName(req.getNickName()).addEnName(req.getEnName()).addState(req.getState())
                .addRegDateStart(req.getRegDateStart()).addRegDateEnd(req.getRegDateEnd()).build(),
            PageParam.Builder.getInstance().addPageNum(req.getPageNum()).addPageSize(req.getPageSize()).build());
        return new PageInfo<>(pageInfo, UserDtoConverter::convert2UserBizDto);
    }

}
