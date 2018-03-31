package com.littlefisher.user.dal.dao;

import java.util.List;

import com.littlefisher.core.mybatis.dao.IBaseDao;
import com.littlefisher.user.dal.model.UserContactStation4WebsiteDto;

/**
 * Description: IUserContactStation4WebsiteDtoDao
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IUserContactStation4WebsiteDtoDao extends IBaseDao<UserContactStation4WebsiteDto> {
    /**
     * 根据联系点id列表查询网站联系点
     *
     * @param stationIdList 联系点id列表
     * @return 网站联系点
     */
    List<UserContactStation4WebsiteDto> selectUserContactStation4WebsiteByStationIdList(List<Long> stationIdList);
}
