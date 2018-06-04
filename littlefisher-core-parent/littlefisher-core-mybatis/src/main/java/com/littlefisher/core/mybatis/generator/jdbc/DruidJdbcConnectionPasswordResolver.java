package com.littlefisher.core.mybatis.generator.jdbc;

import com.alibaba.druid.filter.config.ConfigTools;
import com.littlefisher.core.common.utils.LittleFisherLogger;

/**
 * Description: DruidJdbcConnectionPasswordResolver
 *
 * Created on 2018年03月29日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class DruidJdbcConnectionPasswordResolver implements JdbcConnectionPasswordResolver {

    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(DruidJdbcConnectionPasswordResolver.class);

    @Override
    public String decrypt(String password) {
        try {
            return ConfigTools.decrypt(password);
        } catch (Exception e) {
            logger.error("password is [{}]", password);
            throw new IllegalArgumentException("decrypt failed", e);
        }
    }
}
