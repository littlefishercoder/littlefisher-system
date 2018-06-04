package com.littlefisher.core.datasource.db.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.littlefisher.core.common.db.service.IDbService;
import com.littlefisher.core.datasource.db.cmd.QryDbDateTimeCmd;
import com.littlefisher.core.datasource.interceptor.service.ServiceImpl;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月17日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Service
public class DbServiceImpl extends ServiceImpl implements IDbService {

    @Override
    public Date getDBDateTime() {
        return this.execute(new QryDbDateTimeCmd());

    }
}
