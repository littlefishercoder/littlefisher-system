package com.littlefisher.blog.biz.model;

import java.io.Serializable;
import java.util.Date;

import com.littlefisher.blog.common.enums.EnumFriendLinkState;

/**
 *
 * @author jinyn22648
 * @version $$Id: FriendLinkBizDto.java, v 0.1 2018/3/23 下午12:36 jinyn22648 Exp $$
 */
public class FriendLinkBizDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 3398660722243540268L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 作者主键
     */
    private Long authorId;

    /**
     * 好友真名
     */
    private String friendRealName;

    /**
     * 好友昵称
     */
    private String friendNickName;

    /**
     * 好友链接
     */
    private String friendUrlLink;

    /**
     * 状态
     */
    private EnumFriendLinkState state;

    /**
     * 修改时间
     */
    private Date updateDate;

    public static class Builder {

        private FriendLinkBizDto instance = new FriendLinkBizDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
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

        public FriendLinkBizDto build() {
            return this.instance;
        }
    }

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
        return "FriendLinkBizDto{" + "id=" + id + ", authorId=" + authorId + ", friendRealName='" + friendRealName
            + '\'' + ", friendNickName='" + friendNickName + '\'' + ", friendUrlLink='" + friendUrlLink + '\''
            + ", state=" + state + ", updateDate=" + updateDate + '}';
    }
}
