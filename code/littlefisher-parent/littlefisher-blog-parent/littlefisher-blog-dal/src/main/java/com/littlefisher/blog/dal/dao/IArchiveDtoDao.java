package com.littlefisher.blog.dal.dao;

import java.util.List;

import com.littlefisher.blog.dal.model.ArchiveDto;
import com.littlefisher.core.mybatis.dao.IBaseDao;

/**
 *
 * @author jinyn22648
 * @version $$Id: IArchiveDtoDao.java, v 0.1 2018/3/23 下午12:30 jinyn22648 Exp $$
 */
public interface IArchiveDtoDao extends IBaseDao<ArchiveDto> {

    /**
     * 根据文章归类id列表查询文章归类
     * 
     * @param archiveIdList id列表
     * @return 文章归类列表
     */
    List<ArchiveDto> selectArchiveByIdList(List<Long> archiveIdList);
}
