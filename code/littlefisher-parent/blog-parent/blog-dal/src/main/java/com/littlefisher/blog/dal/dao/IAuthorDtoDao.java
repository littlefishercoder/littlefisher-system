package com.littlefisher.blog.dal.dao;

import java.util.List;

import com.littlefisher.blog.dal.model.AuthorDto;
import com.littlefisher.core.mybatis.dao.IBaseDao;

/**
 * Description: IAuthorDtoDao
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IAuthorDtoDao extends IBaseDao<AuthorDto> {

    /**
     * 根据作者id查询作者信息
     * @param authorIdList 作者id列表
     * @return 作者
     */
    List<AuthorDto> selectAuthorByAuthorIdList(List<Long> authorIdList);
}
