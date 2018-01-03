package com.littlefisher.blog.model.ext;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import com.littlefisher.blog.model.ArchiveDto;
import com.littlefisher.blog.model.AuthorDto;
import com.littlefisher.blog.model.TagDto;
import com.littlefisher.core.biz.framework.model.UserContactStation4WebsiteDto;
import com.littlefisher.core.biz.framework.model.UserDto;

/**
 * Description: AuthorExtDto.java
 *
 * Created on 2017年12月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("首页作者详情")
public class AuthorExtDto extends AuthorDto {

    /** serialVersionUID */
    private static final long serialVersionUID = 4754273307488816077L;

    /** 用户详情 */
    @ApiModelProperty("用户详情")
    private UserDto user;

    /** 文章归类列表 */
    @ApiModelProperty("文章归类列表")
    private ArchiveDto archive;

    /** 标签列表 */
    @ApiModelProperty("标签列表")
    private List<TagDto> tagList;

    /** 网站联系点 */
    @ApiModelProperty("网站联系点")
    private List<UserContactStation4WebsiteDto> userContactStation4WebsiteList;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public ArchiveDto getArchive() {
        return archive;
    }

    public void setArchive(ArchiveDto archive) {
        this.archive = archive;
    }

    public List<TagDto> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagDto> tagList) {
        this.tagList = tagList;
    }

    public List<UserContactStation4WebsiteDto> getUserContactStation4WebsiteList() {
        return userContactStation4WebsiteList;
    }

    public void setUserContactStation4WebsiteList(List<UserContactStation4WebsiteDto> userContactStation4WebsiteList) {
        this.userContactStation4WebsiteList = userContactStation4WebsiteList;
    }

    @Override
    public String toString() {
        return "AuthorExtDto{" + "user=" + user + ", archive=" + archive + ", tagList=" + tagList +
                ", userContactStation4WebsiteList=" + userContactStation4WebsiteList + "} " + super.toString();
    }
}
