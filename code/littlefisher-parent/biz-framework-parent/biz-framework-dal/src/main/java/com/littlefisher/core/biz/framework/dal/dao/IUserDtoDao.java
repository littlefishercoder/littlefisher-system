package com.littlefisher.core.biz.framework.dal.dao;

import java.util.List;

import com.littlefisher.core.biz.framework.dal.model.UserDto;
import com.littlefisher.core.biz.framework.dal.param.SelectUser4PageByCondParam;
import com.littlefisher.core.mybatis.dao.IBaseDao;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;

/**
 *
 * @author jinyn22648
 * @version $$Id: IUserDtoDao.java, v 0.1 2018/3/26 下午7:21 jinyn22648 Exp $$
 */
public interface IUserDtoDao extends IBaseDao<UserDto> {

    /**
     * 根据用户id列表查询用户
     * 
     * @param userIdList 用户id列表
     * @return 用户列表
     */
    List<UserDto> selectByIds(List<Long> userIdList);

    /**
     * 根据条件分页查询用户
     * 
     * @param param 条件
     * @param pageParam 分页参数
     * @return 用户
     */
    PageInfo<UserDto> selectUser4PageByCondParam(SelectUser4PageByCondParam param, PageParam pageParam);
}
