package com.littlefisher.blog.dao.ext;

import java.util.List;

import com.littlefisher.blog.dao.ArchiveDtoMapper;
import com.littlefisher.blog.model.ArchiveDto;
import com.littlefisher.core.mybatis.mapper.common.CommonMapper;

/**
 * Description: archive Mapper 接口
 *
 * Created on 2017年12月28日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ArchiveDtoExtMapper extends ArchiveDtoMapper, CommonMapper<ArchiveDto> {

    /**
     * 根据作者id查询其下所有的文章归类
     * @param authorId 作者id
     * @return 文章归类
     */
    List<ArchiveDto> selectByAuthorId(Long authorId);
}