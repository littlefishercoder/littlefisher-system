package com.littlefisher.user.dal.dao;

import java.util.List;

import com.littlefisher.core.mybatis.dao.IBaseDao;
import com.littlefisher.user.dal.model.UserContactStation4SocialDto;

/**
 * Description: IUserContactStation4SocialDtoDao
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IUserContactStation4SocialDtoDao extends IBaseDao<UserContactStation4SocialDto> {

    /**
     * 根据联系点id列表查询社交联系点
     *
     * @param stationIdList 联系点id列表
     * @return 社交联系点
     */
    List<UserContactStation4SocialDto> selectUserContactStation4SocialByStationIdList(List<Long> stationIdList);
}
