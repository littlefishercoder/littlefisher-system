package com.littlefisher.blog.user.cmd;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.littlefisher.blog.user.dao.UserDtoMapper;
import com.littlefisher.blog.user.model.UserDto;
import com.littlefisher.blog.user.model.request.GetUserList4PagerByCondRequest;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;

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
public class GetUserListByCondCmd extends AbstractCommand<List<UserDto>> {
    
    /**
     * req
     */
    private GetUserList4PagerByCondRequest req;

    /** 
     * Description: 构造函数
     *
     * @author jinyanan
     *
     * @param req req 
     */ 
    public GetUserListByCondCmd(GetUserList4PagerByCondRequest req) {
        super();
        this.req = req;
    }

    @Override
    public List<UserDto> execute() throws BaseAppException {
        UserDtoMapper userDtoMapper = this.getMapper(UserDtoMapper.class);
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        return userDtoMapper.selectByCond(req);
    }

}
