package com.littlefisher.blog.cmd.commentary;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.dao.CommentaryDtoMapper;
import com.littlefisher.blog.enums.EnumCommentaryState;
import com.littlefisher.blog.model.CommentaryDto;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.core.utils.DateUtil;

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
public class AddCommentaryCmd extends AbstractCommand<CommentaryDto> {

    /**
     * commentaryDto
     */
    @Valid
    private CommentaryDto commentaryDto;

    @Autowired
    private CommentaryDtoMapper commentaryDtoMapper;

    public AddCommentaryCmd setCommentaryDto(CommentaryDto commentaryDto) {
        this.commentaryDto = commentaryDto;
        return this;
    }

    @Override
    public CommentaryDto execute() {
        commentaryDto.setCreatedDate(DateUtil.getDBDateTime());
        commentaryDto.setState(EnumCommentaryState.PUBLISHED);
        commentaryDto.setStateDate(DateUtil.getDBDateTime());
        commentaryDtoMapper.insert(commentaryDto);
        return commentaryDto;
    }

}
