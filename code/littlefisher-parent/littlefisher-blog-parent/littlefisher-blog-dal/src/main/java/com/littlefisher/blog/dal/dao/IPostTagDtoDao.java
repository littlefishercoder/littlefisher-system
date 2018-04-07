package com.littlefisher.blog.dal.dao;

import java.util.List;

import com.littlefisher.blog.dal.model.PostTagDto;
import com.littlefisher.core.mybatis.dao.IBaseDao;

/**
 *
 * @author jinyn22648
 * @version $$Id: IPostTagDtoDao.java, v 0.1 2018/3/27 下午8:45 jinyn22648 Exp $$
 */
public interface IPostTagDtoDao extends IBaseDao<PostTagDto> {

    /**
     * 根据文章id列表查询关联关系
     * @param postIdList 文章id列表
     * @return 关联关系
     */
    List<PostTagDto> selectByPostIdList(List<Long> postIdList);
}
