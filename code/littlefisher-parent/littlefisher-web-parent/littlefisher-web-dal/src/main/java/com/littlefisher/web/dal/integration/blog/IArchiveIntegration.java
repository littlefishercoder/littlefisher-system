package com.littlefisher.web.dal.integration.blog;

import com.littlefisher.blog.biz.model.ArchiveBizDto;

/**
 * Description: IArchiveIntegration.java
 *
 * Created on 2018年03月31日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IArchiveIntegration {

    /**
     * 根据name查询博文归类
     * @param name 归类名
     * @return 博文归类
     */
    ArchiveBizDto getValidArchiveByName(String name);

    /**
     * 新增博文归类
     * @param name 归类名
     * @return 博文归类
     */
    ArchiveBizDto addArchive(String name);
}
