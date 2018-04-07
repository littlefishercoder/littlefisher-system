package com.littlefisher.blog.biz.cmd.commentary;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dal.dao.ICommentaryDtoDao;
import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;

/**
 * 
 * Description:
 * 
 * Created on 2017年5月24日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Command
public class DeleteCommentaryCmd extends AbstractCommand<Integer> {

    /**
     * commentaryId
     */
    private Long commentaryId;

    @Autowired
    private ICommentaryDtoDao commentaryDtoDao;

    public DeleteCommentaryCmd setCommentaryId(Long commentaryId) {
        this.commentaryId = commentaryId;
        return this;
    }

    @Override
    public Integer execute() {
        return commentaryDtoDao.deleteByPrimaryKey(commentaryId);
    }

}
