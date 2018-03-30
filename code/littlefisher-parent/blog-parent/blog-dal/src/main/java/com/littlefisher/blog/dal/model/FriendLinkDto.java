package com.littlefisher.blog.dal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.littlefisher.blog.common.enums.EnumFriendLinkState;


/**
 *
 * Description: friend_link 实体
 *
 * Created on 2018年03月30日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "friend_link")
public class FriendLinkDto implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 作者主键
     */
    @Column(name = "author_id")
    private Long authorId;

    /**
     * 好友真名
     */
    @Column(name = "friend_real_name")
    private String friendRealName;

    /**
     * 好友昵称
     */
    @Column(name = "friend_nick_name")
    private String friendNickName;

    /**
     * 好友链接
     */
    @Column(name = "friend_url_link")
    private String friendUrlLink;

    /**
     * 状态
     */
    private EnumFriendLinkState state;

    /**
     * 修改时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getFriendRealName() {
        return friendRealName;
    }

    public void setFriendRealName(String friendRealName) {
        this.friendRealName = friendRealName;
    }

    public String getFriendNickName() {
        return friendNickName;
    }

    public void setFriendNickName(String friendNickName) {
        this.friendNickName = friendNickName;
    }

    public String getFriendUrlLink() {
        return friendUrlLink;
    }

    public void setFriendUrlLink(String friendUrlLink) {
        this.friendUrlLink = friendUrlLink;
    }

    public EnumFriendLinkState getState() {
        return state;
    }

    public void setState(EnumFriendLinkState state) {
        this.state = state;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", authorId=").append(authorId);
        sb.append(", friendRealName=").append(friendRealName);
        sb.append(", friendNickName=").append(friendNickName);
        sb.append(", friendUrlLink=").append(friendUrlLink);
        sb.append(", state=").append(state);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static class Builder {
        private FriendLinkDto instance;

        private Builder() {
            super();
        }

        public static Builder getInstance() {
            Builder builder = new Builder();
            builder.instance = new FriendLinkDto();
            return builder;
        }

        public static Builder getInstance(FriendLinkDto instance) {
            Builder builder = new Builder();
            builder.instance = instance;
            return builder;
        }

        public Builder addId(Long id) {
            this.instance.setId(id);
            return this;
        }

        public Builder addAuthorId(Long authorId) {
            this.instance.setAuthorId(authorId);
            return this;
        }

        public Builder addFriendRealName(String friendRealName) {
            this.instance.setFriendRealName(friendRealName);
            return this;
        }

        public Builder addFriendNickName(String friendNickName) {
            this.instance.setFriendNickName(friendNickName);
            return this;
        }

        public Builder addFriendUrlLink(String friendUrlLink) {
            this.instance.setFriendUrlLink(friendUrlLink);
            return this;
        }

        public Builder addState(EnumFriendLinkState state) {
            this.instance.setState(state);
            return this;
        }

        public Builder addUpdateDate(Date updateDate) {
            this.instance.setUpdateDate(updateDate);
            return this;
        }

        public FriendLinkDto build() {
            return this.instance;
        }
    }
}