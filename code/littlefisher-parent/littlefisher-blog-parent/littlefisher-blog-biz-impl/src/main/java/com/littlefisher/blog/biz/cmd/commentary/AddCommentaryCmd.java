package com.littlefisher.blog.biz.cmd.commentary;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.littlefisher.blog.biz.converter.CommentaryDtoConverter;
import com.littlefisher.blog.biz.model.CommentaryBizDto;
import com.littlefisher.blog.common.enums.EnumCommentaryState;
import com.littlefisher.blog.dal.dao.ICommentaryDtoDao;
import com.littlefisher.blog.dal.model.CommentaryDto;
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
public class AddCommentaryCmd extends AbstractCommand<CommentaryBizDto> {

    /**
     * commentaryDto
     */
    @Valid
    private CommentaryBizDto commentaryBizDto;

    @Autowired
    private ICommentaryDtoDao commentaryDtoDao;

    public AddCommentaryCmd setCommentaryDto(CommentaryBizDto commentaryBizDto) {
        this.commentaryBizDto = commentaryBizDto;
        return this;
    }

    @Override
    public CommentaryBizDto execute() {
        commentaryBizDto.setCreatedDate(DateUtil.getDBDateTime());
        commentaryBizDto.setState(EnumCommentaryState.PUBLISHED);
        commentaryBizDto.setStateDate(DateUtil.getDBDateTime());
        CommentaryDto commentaryDto
            = commentaryDtoDao.insert(CommentaryDtoConverter.convert2CommentaryDto(commentaryBizDto));
        return CommentaryDtoConverter.convert2CommentaryBizDto(commentaryDto);
    }

}
