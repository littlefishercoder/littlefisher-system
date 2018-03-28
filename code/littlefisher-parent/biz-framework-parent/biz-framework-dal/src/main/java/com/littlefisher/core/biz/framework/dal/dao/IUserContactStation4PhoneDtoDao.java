package com.littlefisher.core.biz.framework.dal.dao;

import java.util.List;

import com.littlefisher.core.biz.framework.dal.model.UserContactStation4PhoneDto;
import com.littlefisher.core.mybatis.dao.IBaseDao;

/**
 * Description: IUserContactStation4PhoneDtoDao
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IUserContactStation4PhoneDtoDao extends IBaseDao<UserContactStation4PhoneDto> {
    /**
     * 根据联系点id列表查询电话联系点
     *
     * @param stationIdList 联系点id列表
     * @return 电话联系点
     */
    List<UserContactStation4PhoneDto> selectUserContactStation4PhoneByStationIdList(List<Long> stationIdList);
}
