package com.littlefisher.blog.dal.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.blog.dal.dao.IArchiveDtoDao;
import com.littlefisher.blog.dal.example.ArchiveDtoExample;
import com.littlefisher.blog.dal.mapper.ArchiveDtoMapper;
import com.littlefisher.blog.dal.model.ArchiveDto;
import com.littlefisher.core.mybatis.dao.AbstractBaseDaoImpl;

/**
 *
 * @author jinyn22648
 * @version $$Id: ArchiveDtoDaoImpl.java, v 0.1 2018/3/23 下午12:31 jinyn22648 Exp $$
 */
@Repository
public class ArchiveDtoDaoImpl extends AbstractBaseDaoImpl<ArchiveDto, ArchiveDtoMapper> implements IArchiveDtoDao {

    @Autowired
    private ArchiveDtoMapper archiveDtoMapper;

    @Override
    public List<ArchiveDto> selectArchiveByIdList(List<Long> archiveIdList) {
        ArchiveDtoExample example = new ArchiveDtoExample();
        example.createCriteria().andIdIn(archiveIdList);
        return archiveDtoMapper.selectByExample(example);
    }
}
