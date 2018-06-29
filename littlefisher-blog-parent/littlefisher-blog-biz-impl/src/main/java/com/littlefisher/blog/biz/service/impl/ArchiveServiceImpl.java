package com.littlefisher.blog.biz.service.impl;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.biz.cmd.archive.AddArchiveCmd;
import com.littlefisher.blog.biz.cmd.archive.GetArchiveByNameCmd;
import com.littlefisher.blog.biz.model.ArchiveBizDto;
import com.littlefisher.blog.biz.service.IArchiveService;
import com.littlefisher.core.datasource.interceptor.service.ServiceImpl;

/**
 * Description: ArchiveServiceImpl.java
 *
 * Created on 2018年01月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class ArchiveServiceImpl extends ServiceImpl implements IArchiveService {

    @Override
    public ArchiveBizDto getValidArchiveByName(String name) {
        return execute(getCommand(GetArchiveByNameCmd.class).setName(name));
    }

    @Override
    public ArchiveBizDto addArchive(String name) {
        return execute(getCommand(AddArchiveCmd.class).setName(name));
    }
}
