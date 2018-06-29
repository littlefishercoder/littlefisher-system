package com.littlefisher.web.dal.integration.blog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.littlefisher.blog.biz.model.ArchiveBizDto;
import com.littlefisher.blog.biz.service.IArchiveService;
import com.littlefisher.web.dal.integration.blog.IArchiveIntegration;

/**
 * Description: ArchiveIntegrationImpl.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class ArchiveIntegrationImpl implements IArchiveIntegration {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private IArchiveService archiveService;

    @Override
    public ArchiveBizDto getValidArchiveByName(String name) {
        return archiveService.getValidArchiveByName(name);
    }

    @Override
    public ArchiveBizDto addArchive(String name) {
        return archiveService.addArchive(name);
    }
}
