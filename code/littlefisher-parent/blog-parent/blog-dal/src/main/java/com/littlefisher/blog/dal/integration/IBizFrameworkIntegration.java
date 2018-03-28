package com.littlefisher.blog.dal.integration;

import java.util.List;

import com.littlefisher.core.biz.framework.model.UserBizDto;
import com.littlefisher.core.biz.framework.model.UserContactStation4WebsiteBizDto;

/**
 *
 * @author jinyn22648
 * @version $$Id: IBizFrameworkIntegration.java, v 0.1 2018/3/27 下午4:21 jinyn22648 Exp $$
 */
public interface IBizFrameworkIntegration {

    /**
     * 根据用户id列表查询用户
     * 
     * @param userIdList 用户id列表
     * @return 用户
     */
    List<UserBizDto> getUserByIdList(List<Long> userIdList);

    /**
     * 根据用户id查询用户
     * 
     * @param userId 用户id
     * @return 用户
     */
    UserBizDto getUserById(Long userId);

    /**
     * 根据用户id查询网站联系点
     * 
     * @param userId 用户id
     * @return 网站联系点
     */
    List<UserContactStation4WebsiteBizDto> getUserContactStation4WebsiteByUserId(Long userId);
}
