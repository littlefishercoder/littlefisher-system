package com.littlefisher.blog.biz.cmd.commentary;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.converter.CommentaryDtoConverter;
import com.littlefisher.blog.biz.model.CommentaryBizDto;
import com.littlefisher.blog.dal.dao.ICommentaryDtoDao;
import com.littlefisher.blog.dal.model.CommentaryDto;
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
public class UpdateCommentaryCmd extends AbstractCommand<CommentaryBizDto> {

    /**
     * commentaryDto
     */
    private CommentaryBizDto commentaryBizDto;

    @Autowired
    private ICommentaryDtoDao commentaryDtoDao;

    public UpdateCommentaryCmd setCommentaryDto(CommentaryBizDto commentaryBizDto) {
        this.commentaryBizDto = commentaryBizDto;
        return this;
    }

    @Override
    public CommentaryBizDto execute() {
        CommentaryDto commentaryDto = CommentaryDtoConverter.convert2CommentaryDto(commentaryBizDto);
        commentaryDtoDao.updateByPrimaryKey(commentaryDto);
        return CommentaryDtoConverter.convert2CommentaryBizDto(commentaryDto);
    }

}
