package com.littlefisher.blog.cmd.user;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.littlefisher.blog.dao.user.UserDtoMapper;
import com.littlefisher.blog.model.user.UserDto;
import com.littlefisher.blog.model.user.UserDtoExample;
import com.littlefisher.blog.request.user.GetUserList4PagerByCondRequest;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * Description:
 *
 * Created on 2017年5月24日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class GetUserListByCondCmd extends AbstractCommand<List<UserDto>> {

    /**
     * req
     */
    private GetUserList4PagerByCondRequest req;

    /**
     * Description: 构造函数
     *
     * @param req req
     */
    public GetUserListByCondCmd(GetUserList4PagerByCondRequest req) {
        super();
        this.req = req;
    }

    @Override
    public List<UserDto> execute() {
        UserDtoMapper userDtoMapper = this.getMapper(UserDtoMapper.class);
        UserDtoExample example = new UserDtoExample();
        example.createCriteria().andAccNbrEqualTo(req.getAccNbr()).andEmailLike(req.getEmail())
                .andRealNameLike(req.getRealName()).andNickNameLike(req.getNickName()).andEnNameLike(req.getEnName())
                .andQqLike(req.getQq()).andPhoneNbrLike(req.getPhoneNbr()).andStateEqualTo(req.getState())
                .andRegDateGreaterThanOrEqualTo(req.getRegDateStart()).andRegDateLessThanOrEqualTo(req.getRegDateEnd());
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        return userDtoMapper.selectByExample(example);
    }

}
