package com.littlefisher.core.datasource.db.cmd;

import java.util.Date;

import com.littlefisher.core.common.stereotype.annotations.Command;
import com.littlefisher.core.datasource.db.dal.mapper.DbMapper;
import com.littlefisher.core.datasource.interceptor.AbstractCommand;

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
@Command
public class QryDbDateTimeCmd extends AbstractCommand<Date> {

    @Override
    public Date execute() {
        DbMapper dbMapper = this.getMapper(DbMapper.class);
        return dbMapper.getDBDateTime();
    }

}
