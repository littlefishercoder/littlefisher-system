package com.littlefisher.blog.commentary.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.littlefisher.blog.user.model.UserDto;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


/**
 *
 * Description: commentary 实体
 *
 * Created on 2017年05月22日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "commentary")
@ApiModel(value = "commentary实体")
public class CommentaryDto implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父评价主键
     */
    @ApiModelProperty(value = "父评价主键")
    @Column(name = "parent_commentary_id")
    private Long parentCommentaryId;

    /**
     * 评价人主键和昵称二选一，评价人主键为空说明是匿名评价，则必须有昵称来展示
     */
    @ApiModelProperty(value = "评价人主键和昵称二选一，评价人主键为空说明是匿名评价，则必须有昵称来展示")
    @Column(name = "user_id")
    private Long userId;

    /**
     * 评价人主键和昵称二选一，评价人主键为空说明是匿名评价，则必须有昵称来展示
     */
    @ApiModelProperty(value = "评价人主键和昵称二选一，评价人主键为空说明是匿名评价，则必须有昵称来展示")
    @Column(name = "nick_name")
    private String nickName;

    /**
     * ip地址
     */
    @ApiModelProperty(value = "ip地址")
    @Column(name = "commentary_ip")
    private String commentaryIp;

    /**
     * 评价时间
     */
    @ApiModelProperty(value = "评价时间")
    @Column(name = "created_date")
    private Date createdDate;

    /**
     * 博文主键
     */
    @ApiModelProperty(value = "博文主键")
    @Column(name = "post_id")
    private Long postId;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String state;

    /**
     * 状态变更时间
     */
    @ApiModelProperty(value = "状态变更时间")
    @Column(name = "state_date")
    private Date stateDate;

    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    private String content;
    
    /**
     * author 作者
     */
    @ApiModelProperty(value = "作者")
    @Transient
    private UserDto author;
    
    /**
     * commentaryState 评价状态
     */
    @ApiModelProperty(value = "评价状态")
    @Transient
    private CommentaryStateDto commentaryState;

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentCommentaryId() {
        return parentCommentaryId;
    }

    public void setParentCommentaryId(Long parentCommentaryId) {
        this.parentCommentaryId = parentCommentaryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCommentaryIp() {
        return commentaryIp;
    }

    public void setCommentaryIp(String commentaryIp) {
        this.commentaryIp = commentaryIp;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }

    public CommentaryStateDto getCommentaryState() {
        return commentaryState;
    }

    public void setCommentaryState(CommentaryStateDto commentaryState) {
        this.commentaryState = commentaryState;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CommentaryDto [id=");
        builder.append(id);
        builder.append(", parentCommentaryId=");
        builder.append(parentCommentaryId);
        builder.append(", userId=");
        builder.append(userId);
        builder.append(", nickName=");
        builder.append(nickName);
        builder.append(", commentaryIp=");
        builder.append(commentaryIp);
        builder.append(", createdDate=");
        builder.append(createdDate);
        builder.append(", postId=");
        builder.append(postId);
        builder.append(", state=");
        builder.append(state);
        builder.append(", stateDate=");
        builder.append(stateDate);
        builder.append(", content=");
        builder.append(content);
        builder.append(", author=");
        builder.append(author);
        builder.append(", commentaryState=");
        builder.append(commentaryState);
        builder.append("]");
        return builder.toString();
    }
}