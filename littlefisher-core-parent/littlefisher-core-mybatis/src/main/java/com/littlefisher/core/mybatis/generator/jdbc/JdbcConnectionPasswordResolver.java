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

    /**
     * 对密码进行解密
     *
     * @param password 加密的密码
     * @return 解密的密码
     */
    String decrypt(String password);
}
