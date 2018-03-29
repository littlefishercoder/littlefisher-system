package com.littlefisher.core.mybatis.generator.jdbc;

/**
 * Description: JdbcConnectionPasswordResolver
 *
 * Created on 2018年03月29日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface JdbcConnectionPasswordResolver {

    String decrypt(String password);
}
