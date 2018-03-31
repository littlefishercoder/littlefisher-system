package com.littlefisher.blog.biz.cmd.archive;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.converter.ArchiveDtoConverter;
import com.littlefisher.blog.biz.model.ArchiveBizDto;
import com.littlefisher.blog.common.enums.EnumArchiveState;
import com.littlefisher.blog.dal.dao.IArchiveDtoDao;
import com.littlefisher.blog.dal.model.ArchiveDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;

/**
 * Description: GetArchiveByNameCmd.java
 *
 * Created on 2018年01月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class GetArchiveByNameCmd extends AbstractCommand<ArchiveBizDto> {

    /** 博文归类名 */
    private String name;

    public GetArchiveByNameCmd setName(String name) {
        this.name = name;
        return this;
    }

    @Autowired
    private IArchiveDtoDao archiveDtoDao;

    @Override
    public ArchiveBizDto execute() {
        ArchiveDto archive = archiveDtoDao
            .selectOneByRecord(ArchiveDto.Builder.getInstance().addName(name).addState(EnumArchiveState.VALID).build());
        return ArchiveDtoConverter.convert2ArchiveBizDto(archive);
    }
}
