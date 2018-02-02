package com.littlefisher.core.utils.db.cmd;

import java.util.Date;

import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.stereotype.annotations.Command;
import com.littlefisher.core.utils.db.dao.DbMapper;

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
    public Date execute() throws BaseAppException {
        DbMapper dbMapper = this.getMapper(DbMapper.class);
        return dbMapper.getDBDateTime();
    }

}
