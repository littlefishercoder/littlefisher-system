package com.littlefisher.blog.biz.converter;

import com.littlefisher.blog.biz.model.ArchiveBizDto;
import com.littlefisher.blog.dal.model.ArchiveDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: ArchiveDtoConverter.java, v 0.1 2018/3/26 下午8:35 jinyn22648 Exp $$
 */
public final class ArchiveDtoConverter {

    /**
     * 私有构造函数
     */
    private ArchiveDtoConverter() {
    }

    /**
     * ArchiveBizDto转ArchiveDto
     * 
     * @param archiveBizDto ArchiveBizDto
     * @return ArchiveDto
     */
    public static ArchiveDto convert2ArchiveDto(ArchiveBizDto archiveBizDto) {
        return ArchiveDto.Builder.getInstance().addId(archiveBizDto.getId()).addName(archiveBizDto.getName())
            .addState(archiveBizDto.getState()).addUpdateDate(archiveBizDto.getUpdateDate()).build();
    }

    /**
     * ArchiveDto转ArchiveBizDto
     * 
     * @param archiveDto ArchiveDto
     * @return ArchiveBizDto
     */
    public static ArchiveBizDto convert2ArchiveBizDto(ArchiveDto archiveDto) {
        return ArchiveBizDto.Builder.getInstance().addId(archiveDto.getId()).addName(archiveDto.getName())
            .addState(archiveDto.getState()).addUpdateDate(archiveDto.getUpdateDate()).build();
    }
}
