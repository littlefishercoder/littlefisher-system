package com.littlefisher.blog.dal.dao;

import com.littlefisher.blog.dal.model.PostDto;
import com.littlefisher.blog.dal.param.SelectPost4PageByCondParam;
import com.littlefisher.core.mybatis.dao.IBaseWithBlobDao;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;

/**
 *
 * @author jinyn22648
 * @version $$Id: IPostDtoDao.java, v 0.1 2018/3/27 下午7:20 jinyn22648 Exp $$
 */
public interface IPostDtoDao extends IBaseWithBlobDao<PostDto> {

    /**
     * 根据条件分页查询博文
     * 
     * @param param 条件
     * @param pageParam 分页条件
     * @return 博文列表
     */
    PageInfo<PostDto> selectPost4PageByCond(SelectPost4PageByCondParam param, PageParam pageParam);
}
