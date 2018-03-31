package com.littlefisher.user.dal.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.littlefisher.core.mybatis.dao.AbstractBaseDaoImpl;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;
import com.littlefisher.core.utils.StringUtil;
import com.littlefisher.user.dal.dao.IUserDtoDao;
import com.littlefisher.user.dal.example.UserDtoExample;
import com.littlefisher.user.dal.mapper.UserDtoMapper;
import com.littlefisher.user.dal.model.UserDto;
import com.littlefisher.user.dal.param.SelectUser4PageByCondParam;

/**
 *
 * @author jinyn22648
 * @version $$Id: UserDtoDaoImpl.java, v 0.1 2018/3/26 下午7:41 jinyn22648 Exp $$
 */
@Repository
public class UserDtoDaoImpl extends AbstractBaseDaoImpl<UserDto, UserDtoMapper> implements
        IUserDtoDao {

    @Autowired
    private UserDtoMapper userDtoMapper;

    @Override
    public List<UserDto> selectByIds(List<Long> userIdList) {
        UserDtoExample example = new UserDtoExample();
        example.createCriteria().andIdIn(userIdList);
        return userDtoMapper.selectByExample(example);
    }

    @Override
    public PageInfo<UserDto> selectUser4PageByCondParam(SelectUser4PageByCondParam param, PageParam pageParam) {
        UserDtoExample example = new UserDtoExample();
        UserDtoExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotBlank(param.getAccNbr())) {
            criteria.andAccNbrEqualTo(param.getAccNbr());
        }
        if (StringUtil.isNotBlank(param.getRealName())) {
            criteria.andRealNameLike(param.getRealName());
        }
        if (StringUtil.isNotBlank(param.getNickName())) {
            criteria.andNickNameLike(param.getNickName());
        }
        if (StringUtil.isNotBlank(param.getEnName())) {
            criteria.andEnNameLike(param.getEnName());
        }
        if (param.getState() != null) {
            criteria.andStateEqualTo(param.getState());
        }
        if (param.getRegDateStart() != null) {
            criteria.andRegDateLessThanOrEqualTo(param.getRegDateStart());
        }
        if (param.getRegDateEnd() != null) {
            criteria.andRegDateGreaterThanOrEqualTo(param.getRegDateEnd());
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        return new PageInfo<>(userDtoMapper.selectByExample(param));
    }
}
