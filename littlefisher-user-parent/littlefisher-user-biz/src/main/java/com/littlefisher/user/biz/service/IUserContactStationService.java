package com.littlefisher.user.biz.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.littlefisher.user.biz.model.UserContactStation4EmailBizDto;
import com.littlefisher.user.biz.model.UserContactStation4PhoneBizDto;
import com.littlefisher.user.biz.model.UserContactStation4SocialBizDto;
import com.littlefisher.user.biz.model.UserContactStation4WebsiteBizDto;

/**
 * Description: IUserContactStationService
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@FeignClient(value = "user-contact-station-service", path = "/userContactStations")
public interface IUserContactStationService {

    /**
     * 根据用户id查询email联系点
     * 
     * @param userId 用户id
     * @return email联系点
     */
    @GetMapping("/emails/{userId}")
    List<UserContactStation4EmailBizDto> getUserContactStation4EmailByUserId(@PathVariable("userId") Long userId);

    /**
     * 根据用户id查询电话联系点
     * 
     * @param userId 用户id
     * @return 电话联系点
     */
    @GetMapping("/phones/{userId}")
    List<UserContactStation4PhoneBizDto> getUserContactStation4PhoneByUserId(@PathVariable("userId") Long userId);

    /**
     * 根据用户id查询社交联系点
     * 
     * @param userId 用户id
     * @return 社交联系点
     */
    @GetMapping("/socials/{userId}")
    List<UserContactStation4SocialBizDto> getUserContactStation4SocialByUserId(@PathVariable("userId") Long userId);

    /**
     * 根据用户id查询网站联系点
     * 
     * @param userId 用户id
     * @return 网站联系点
     */
    @GetMapping("/websites/{userId}")
    List<UserContactStation4WebsiteBizDto> getUserContactStation4WebsiteByUserId(@PathVariable("userId") Long userId);
}
