package com.littlefisher.blog.dal.dao.impl;

import org.springframework.stereotype.Repository;

import com.littlefisher.blog.dal.dao.ICountStatistic4BlogDtoDao;
import com.littlefisher.blog.dal.mapper.CountStatistic4BlogDtoMapper;
import com.littlefisher.blog.dal.model.CountStatistic4BlogDto;
import com.littlefisher.core.mybatis.dao.AbstractBaseDaoImpl;

/**
 * Description: CountStatistic4BlogDtoDaoImpl
 *
 * Created on 2018年03月28日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Repository
public class CountStatistic4BlogDtoDaoImpl extends AbstractBaseDaoImpl<CountStatistic4BlogDto, CountStatistic4BlogDtoMapper> implements
        ICountStatistic4BlogDtoDao {

}
