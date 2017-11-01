package com.littlefisher.core.spring.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Log4j2Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;

/**
 * Description: 数据源配置 
 * 
 * Created on 2017年4月18日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
public class DataSourceConfig {

    /**
     * url
     */
    @Value("${jdbc_url}")
    private String url;

    /**
     * userName
     */
    @Value("${jdbc_username}")
    private String userName;

    /**
     * password
     */
    @Value("${jdbc_password}")
    private String password;

    /**
     * validationQuerySQL
     */
    @Value("${validationQuery}")
    private String validationQuerySQL;

    /**
     * 初始化大小
     */
    private int initialSize = 0;

    /**
     * 配置初始化最大值
     */
    private int maxActive = 20;

    /**
     * 最小连接池数量
     */
    private int minIdle = 0;

    /**
     * 获取连接等待超时的时间
     */
    private Long maxWait = 60000L;

    /**
     * 申请连接时执行validationQuery检测连接是否有效
     */
    private boolean testOnBorrow = false;

    /**
     * 归还连接时执行validationQuery检测连接是否有效
     */
    private boolean testOnReturn = false;

    /**
     * 建议配置为true，不影响性能，并且保证安全性 
     * 申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis 执行validationQuery检测连接是否有效
     */
    private boolean testWhileIdle = true;

    /**
     * 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
     */
    private Long timeBetweenEvictionRunsMillis = 60000L;

    /**
     * 配置一个连接在池中最小生存的时间，单位是毫秒
     */
    private Long minEvictableIdleTimeMillis = 25200000L;

    /**
     * 对于长时间不使用的连接强制关闭
     */
    private boolean removeAbandoned = true;

    /**
     * 超过30分钟开始关闭空闲连接
     */
    private int removeAbandonedTimeout = 1800;

    /**
     * 将当前关闭动作记录到日志
     */
    private boolean logAbandoned = true;

    /**
     * druid filters的别名保存在下面的地址中 
     * druid-xxx.jar!/META-INF/druid-filter.properties
     */
    private String filters = "mergeStat";

    /**
     * Description:
     * 
     * @author jinyanan
     * @return DataSource
     * @throws SQLException <br>
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        // 基本属性 url、user、password
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        // 配置初始化大小、最小、最大
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        // 最小连接池数量
        dataSource.setMinIdle(minIdle);
        // 配置获取连接等待超时的时间
        dataSource.setMaxWait(maxWait);
        // 用来检测连接是否有效的sql，要求是一个查询语句。
        // 如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会其作用。
        dataSource.setValidationQuery(validationQuerySQL);
        // 申请连接时执行validationQuery检测连接是否有效
        // 做了这个配置会降低性能
        dataSource.setTestOnBorrow(testOnBorrow);
        // 归还连接时执行validationQuery检测连接是否有效
        // 做了这个配置会降低性能
        dataSource.setTestOnReturn(testOnReturn);
        // 建议配置为true，不影响性能，并且保证安全性
        // 申请连接的时候检测，如果空闲时间大于
        // timeBetweenEvictionRunsMillis
        // 执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(testWhileIdle);
        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        // 配置一个连接在池中最小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        // 对于长时间不使用的连接强制关闭
        dataSource.setRemoveAbandoned(removeAbandoned);
        // 超过30分钟开始关闭空闲连接
        dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        // 将当前关闭动作记录到日志
        dataSource.setLogAbandoned(logAbandoned);
        // druid filters的别名保存在下面的地址中
        // druid-xxx.jar!/META-INF/druid-filter.properties
        dataSource.setFilters(filters);
        // 配置log相关的信息
        dataSource.setProxyFilters(Lists.newArrayList(
                log4j2Filter()
        ));
        return dataSource;
    }

    /**
     * Description: 配置log相关的信息
     *
     * @author jinyanan
     * @return Filter
     */
    @Bean
    public Filter log4j2Filter() {
        Log4j2Filter filter = new Log4j2Filter();
        // 打印可执行sql
        filter.setStatementExecutableSqlLogEnable(true);
        return filter;
    }

}
