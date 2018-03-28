package com.littlefisher.blog.dal.dao;

import java.util.List;

import com.littlefisher.blog.dal.model.TagDto;
import com.littlefisher.blog.dal.param.SelectTag4PageByCondParam;
import com.littlefisher.core.mybatis.dao.IBaseDao;
import com.littlefisher.core.mybatis.pagehelper.PageInfo;
import com.littlefisher.core.mybatis.pagehelper.PageParam;

/**
 *
 * @author jinyn22648
 * @version $$Id: ITagDtoDao.java, v 0.1 2018/3/27 下午8:38 jinyn22648 Exp $$
 */
public interface ITagDtoDao extends IBaseDao<TagDto> {

    /**
     * 按照条件分页查询tag
     * 
     * @param param 查询条件
     * @param pageParam 分页条件
     * @return 返回数据
     */
    PageInfo<TagDto> selectTag4PageByCond(SelectTag4PageByCondParam param, PageParam pageParam);

    /**
     * 根据tagId列表查询tag
     * @param tagIdList id列表
     * @return tag集合
     */
    List<TagDto> selectByTagIdList(List<Long> tagIdList);
}
