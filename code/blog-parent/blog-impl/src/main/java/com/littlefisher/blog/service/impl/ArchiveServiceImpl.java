package com.littlefisher.blog.service.impl;

import org.springframework.stereotype.Service;

import com.littlefisher.blog.cmd.archive.AddArchiveCmd;
import com.littlefisher.blog.cmd.archive.GetArchiveByNameCmd;
import com.littlefisher.blog.model.ArchiveDto;
import com.littlefisher.blog.service.IArchiveService;
import com.littlefisher.core.interceptor.service.ServiceImpl;

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
    public ArchiveDto getArchiveByName(String name) {
        return execute(getCommand(GetArchiveByNameCmd.class).setName(name));
    }

    @Override
    public ArchiveDto addArchive(String name) {
        return execute(getCommand(AddArchiveCmd.class).setName(name));
    }
}
