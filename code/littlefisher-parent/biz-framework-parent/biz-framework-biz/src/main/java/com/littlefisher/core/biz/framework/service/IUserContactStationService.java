package com.littlefisher.core.biz.framework.service;

import java.util.List;

import com.littlefisher.core.biz.framework.model.UserContactStation4EmailBizDto;
import com.littlefisher.core.biz.framework.model.UserContactStation4PhoneBizDto;
import com.littlefisher.core.biz.framework.model.UserContactStation4SocialBizDto;
import com.littlefisher.core.biz.framework.model.UserContactStation4WebsiteBizDto;

/**
 * Description: IUserContactStationService
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IUserContactStationService {

    /**
     * 根据用户id查询email联系点
     * 
     * @param userId 用户id
     * @return email联系点
     */
    List<UserContactStation4EmailBizDto> getUserContactStation4EmailByUserId(Long userId);

    /**
     * 根据用户id查询电话联系点
     * 
     * @param userId 用户id
     * @return 电话联系点
     */
    List<UserContactStation4PhoneBizDto> getUserContactStation4PhoneByUserId(Long userId);

    /**
     * 根据用户id查询社交联系点
     * 
     * @param userId 用户id
     * @return 社交联系点
     */
    List<UserContactStation4SocialBizDto> getUserContactStation4SocialByUserId(Long userId);

    /**
     * 根据用户id查询网站联系点
     * 
     * @param userId 用户id
     * @return 网站联系点
     */
    List<UserContactStation4WebsiteBizDto> getUserContactStation4WebsiteByUserId(Long userId);
}
