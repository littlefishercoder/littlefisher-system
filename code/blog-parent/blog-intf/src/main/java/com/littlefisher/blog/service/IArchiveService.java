package com.littlefisher.blog.service;

import com.littlefisher.blog.model.ArchiveDto;

/**
 * Description: IArchiveService.java
 *
 * Created on 2018年01月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IArchiveService {

    /**
     * 根据name查询博文归类
     * @param name 归类名
     * @return 博文归类
     */
    ArchiveDto getArchiveByName(String name);

    /**
     * 新增博文归类
     * @param name 归类名
     * @return 博文归类
     */
    ArchiveDto addArchive(String name);

}
