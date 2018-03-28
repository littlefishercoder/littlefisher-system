package com.littlefisher.blog.biz.cmd.archive;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.converter.ArchiveDtoConverter;
import com.littlefisher.blog.biz.model.ArchiveBizDto;
import com.littlefisher.blog.common.enums.EnumArchiveState;
import com.littlefisher.blog.dal.dao.IArchiveDtoDao;
import com.littlefisher.blog.dal.model.ArchiveDto;
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
public class AddArchiveCmd extends AbstractCommand<ArchiveBizDto> {

    /** 博文归类名 */
    private String name;

    @Autowired
    private IArchiveDtoDao archiveDtoDao;

    public AddArchiveCmd setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ArchiveBizDto execute() {
        ArchiveDto archiveDto = ArchiveDto.Builder.getInstance().addName(name).build();
        archiveDto = archiveDtoDao.selectOneByRecord(archiveDto);
        if (archiveDto == null) {
            archiveDto = ArchiveDto.Builder.getInstance().addName(name).addState(EnumArchiveState.VALID)
                .addUpdateDate(DateUtil.getDBDateTime()).build();
            archiveDtoDao.insert(archiveDto);
            return ArchiveDtoConverter.convert2ArchiveBizDto(archiveDto);
        } else if (EnumArchiveState.INVALID.equals(archiveDto.getState())) {
            // 如果存在一个失效的博文归类，则直接把失效状态转为生效即可
            archiveDto.setState(EnumArchiveState.VALID);
            archiveDto.setUpdateDate(DateUtil.getDBDateTime());
            archiveDtoDao.updateByPrimaryKeySelective(archiveDto);
            return ArchiveDtoConverter.convert2ArchiveBizDto(archiveDto);
        } else {
            return ArchiveDtoConverter.convert2ArchiveBizDto(archiveDto);
        }
    }
}
