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
public class GetCommentaryByIdCmd extends AbstractCommand<CommentaryBizDto> {
    
    /**
     * commentaryId
     */
    private Long commentaryId;

    @Autowired
    private ICommentaryDtoDao commentaryDtoDao;

    public GetCommentaryByIdCmd setCommentaryId(Long commentaryId) {
        this.commentaryId = commentaryId;
        return this;
    }

    @Override
    public CommentaryBizDto execute() {
        CommentaryDto commentaryDto = commentaryDtoDao.selectByPrimaryKey(commentaryId);
        return CommentaryDtoConverter.convert2CommentaryBizDto(commentaryDto);
    }

}
