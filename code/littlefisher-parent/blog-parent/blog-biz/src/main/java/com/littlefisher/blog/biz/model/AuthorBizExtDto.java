package com.littlefisher.blog.biz.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import com.littlefisher.core.biz.framework.model.UserBizDto;
import com.littlefisher.core.biz.framework.model.UserContactStation4WebsiteBizDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: AuthorBizExtDto.java, v 0.1 2018/3/23 下午12:34 jinyn22648 Exp $$
 */
public class AuthorBizExtDto implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 7790413267598944383L;

    /** 作者信息 */
    @ApiModelProperty("作者信息")
    private AuthorBizDto author;

    /** 用户详情 */
    @ApiModelProperty("用户详情")
    private UserBizDto user;

    /** 文章归类列表 */
    @ApiModelProperty("文章归类列表")
    private List<ArchiveBizDto> archiveList;

    /** 标签列表 */
    @ApiModelProperty("标签列表")
    private List<TagBizDto> tagList;

    /** 网站联系点 */
    @ApiModelProperty("网站联系点")
    private List<UserContactStation4WebsiteBizDto> userContactStation4WebsiteList;

    public static class Builder {

        private AuthorBizExtDto instance = new AuthorBizExtDto();

        private Builder() {}

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder addAuthor(AuthorBizDto author) {
            this.instance.setAuthor(author);
            return this;
        }

        public Builder addUser(UserBizDto user) {
            this.instance.setUser(user);
            return this;
        }

        public Builder addArchiveList(List<ArchiveBizDto> archiveList) {
            this.instance.setArchiveList(archiveList);
            return this;
        }

        public Builder addTagList(List<TagBizDto> tagList) {
            this.instance.setTagList(tagList);
            return this;
        }

        public Builder
            addUserContactStation4WebsiteList(List<UserContactStation4WebsiteBizDto> userContactStation4WebsiteList) {
            this.instance.setUserContactStation4WebsiteList(userContactStation4WebsiteList);
            return this;
        }

        public AuthorBizExtDto build() {
            return this.instance;
        }
    }

    public AuthorBizDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBizDto author) {
        this.author = author;
    }

    public UserBizDto getUser() {
        return user;
    }

    public void setUser(UserBizDto user) {
        this.user = user;
    }

    public List<ArchiveBizDto> getArchiveList() {
        return archiveList;
    }

    public void setArchiveList(List<ArchiveBizDto> archiveList) {
        this.archiveList = archiveList;
    }

    public List<TagBizDto> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagBizDto> tagList) {
        this.tagList = tagList;
    }

    public List<UserContactStation4WebsiteBizDto> getUserContactStation4WebsiteList() {
        return userContactStation4WebsiteList;
    }

    public void
        setUserContactStation4WebsiteList(List<UserContactStation4WebsiteBizDto> userContactStation4WebsiteList) {
        this.userContactStation4WebsiteList = userContactStation4WebsiteList;
    }

    @Override
    public String toString() {
        return "AuthorBizExtDto{" + "author=" + author + ", user=" + user + ", archiveList=" + archiveList
            + ", tagList=" + tagList + ", userContactStation4WebsiteList=" + userContactStation4WebsiteList + '}';
    }
}
