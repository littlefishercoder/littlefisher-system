package com.littlefisher.blog.dal.dao;

import com.littlefisher.blog.dal.model.CommentaryDto;
import com.littlefisher.blog.dal.param.SelectCommentary4PageByCondParam;
import com.littlefisher.core.mybatis.dao.IBaseDao;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;

/**
 *
 * @author jinyn22648
 * @version $$Id: ICommentaryDtoDao.java, v 0.1 2018/3/27 上午10:15 jinyn22648 Exp $$
 */
public interface ICommentaryDtoDao extends IBaseDao<CommentaryDto> {

    /**
     * 根据参数分页查询评价
     * 
     * @param param 条件
     * @param pageParam 分页条件
     * @return 评价
     */
    PageInfo<CommentaryDto> selectCommentary4PageByCond(SelectCommentary4PageByCondParam param, PageParam pageParam);
}
