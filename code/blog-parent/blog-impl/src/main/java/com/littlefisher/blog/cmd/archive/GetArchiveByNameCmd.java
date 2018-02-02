package com.littlefisher.blog.cmd.archive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.ArchiveDtoMapper;
import com.littlefisher.blog.enums.EnumArchiveState;
import com.littlefisher.blog.example.ArchiveDtoExample;
import com.littlefisher.blog.model.ArchiveDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.core.utils.CollectionUtil;

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
public class GetArchiveByNameCmd extends AbstractCommand<ArchiveDto> {

    /** 博文归类名 */
    private String name;

    public GetArchiveByNameCmd setName(String name) {
        this.name = name;
        return this;
    }

    @Autowired
    private ArchiveDtoMapper archiveDtoMapper;

    @Override
    public ArchiveDto execute() {
        ArchiveDtoExample archiveDtoExample = new ArchiveDtoExample();
        archiveDtoExample.createCriteria().andNameEqualTo(name).andStateEqualTo(EnumArchiveState.VALID);
        List<ArchiveDto> archiveList = archiveDtoMapper.selectByExample(archiveDtoExample);
        return CollectionUtil.isEmpty(archiveList) ? null : archiveList.get(0);
    }
}
