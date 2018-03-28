package com.littlefisher.core.biz.framework.dal.dao;

import java.util.List;

import com.littlefisher.core.biz.framework.dal.model.UserContactStation4EmailDto;
import com.littlefisher.core.mybatis.dao.IBaseDao;

/**
 * Description: IUserContactStation4EmailDtoDao
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface IUserContactStation4EmailDtoDao extends IBaseDao<UserContactStation4EmailDto> {

    /**
     * 根据联系点id列表查询邮件联系点
     * 
     * @param stationIdList 联系点id列表
     * @return 邮件联系点
     */
    List<UserContactStation4EmailDto> selectUserContactStation4EmailByStationIdList(List<Long> stationIdList);
}
