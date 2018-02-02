package com.littlefisher.blog.cmd.archive;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.ArchiveDtoMapper;
import com.littlefisher.blog.enums.EnumArchiveState;
import com.littlefisher.blog.model.ArchiveDto;
import com.littlefisher.blog.service.IArchiveService;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.core.utils.DateUtil;

/**
 * Description: AddArchiveCmd.java
 *
 * Created on 2018年01月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class AddArchiveCmd extends AbstractCommand<ArchiveDto> {

    /** 博文归类名 */
    private String name;

    @Autowired
    private ArchiveDtoMapper archiveDtoMapper;

    @Autowired
    private IArchiveService archiveService;

    public AddArchiveCmd setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ArchiveDto execute() {
        ArchiveDto archiveDto = archiveService.getArchiveByName(name);
        if (archiveDto == null) {
            archiveDto = new ArchiveDto();
            archiveDto.setName(name);
            archiveDto.setState(EnumArchiveState.VALID);
            archiveDto.setUpdateDate(DateUtil.getDBDateTime());
            archiveDtoMapper.insert(archiveDto);
            return archiveDto;
        } else {
            return archiveDto;
        }

    }
}
