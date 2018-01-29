package com.littlefisher.core.biz.framework.cmd.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.littlefisher.core.biz.framework.dao.UserDtoMapper;
import com.littlefisher.core.biz.framework.example.UserDtoExample;
import com.littlefisher.core.biz.framework.model.UserDto;
import com.littlefisher.core.biz.framework.request.GetUserList4PagerByCondRequest;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.Command;
import com.littlefisher.core.utils.StringUtil;

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
    private UserDtoMapper userDtoMapper;

    public GetUserListByCondCmd setReq(GetUserList4PagerByCondRequest req) {
        this.req = req;
        return this;
    }

    @Override
    public List<UserDto> execute() {
        UserDtoExample example = new UserDtoExample();
        UserDtoExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotBlank(req.getAccNbr())) {
            criteria.andAccNbrEqualTo(req.getAccNbr());
        }
        if (StringUtil.isNotBlank(req.getRealName())) {
            criteria.andRealNameLike(req.getRealName());
        }
        if (StringUtil.isNotBlank(req.getNickName())) {
            criteria.andNickNameLike(req.getNickName());
        }
        if (StringUtil.isNotBlank(req.getEnName())) {
            criteria.andEnNameLike(req.getEnName());
        }
        if (req.getState() != null) {
            criteria.andStateEqualTo(req.getState());
        }
        if (req.getRegDateStart() != null) {
            criteria.andRegDateLessThanOrEqualTo(req.getRegDateStart());
        }
        if (req.getRegDateEnd() != null) {
            criteria.andRegDateGreaterThanOrEqualTo(req.getRegDateEnd());
        }
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        return userDtoMapper.selectByExample(req);
    }

}
