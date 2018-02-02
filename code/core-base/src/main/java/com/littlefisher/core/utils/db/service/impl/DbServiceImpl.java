package com.littlefisher.core.utils.db.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.littlefisher.core.interceptor.service.ServiceImpl;
import com.littlefisher.core.utils.db.cmd.QryDbDateTimeCmd;
import com.littlefisher.core.utils.db.service.IDbService;

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
