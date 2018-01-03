package com.littlefisher.core.biz.framework.cmd.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.littlefisher.core.biz.framework.dao.ext.UserDtoExtMapper;
import com.littlefisher.core.biz.framework.model.UserDto;
import com.littlefisher.core.biz.framework.request.GetUserList4PagerByCondRequest;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;

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
public class GetUserListByCondCmd extends AbstractCommand<List<UserDto>> {

    /**
     * req
     */
    private GetUserList4PagerByCondRequest req;

    @Autowired
    private UserDtoExtMapper userDtoMapper;

    public GetUserListByCondCmd setReq(GetUserList4PagerByCondRequest req) {
        this.req = req;
        return this;
    }

    @Override
    public List<UserDto> execute() {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        return userDtoMapper.selectByCond(req);
    }

}
