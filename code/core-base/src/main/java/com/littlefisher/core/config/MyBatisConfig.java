package com.littlefisher.core.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StringUtils;

import com.google.common.collect.Sets;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.mybatis.EnumTypeHandler;
import com.littlefisher.core.mybatis.IEnum;
import com.littlefisher.core.utils.PackageUtil;
import com.littlefisher.core.utils.StringUtil;
import com.littlefisher.spring.boot.autoconfigure.LittleFisherProperties;

/**
 * Description: MyBatisConfig.java
 * 配置Mybatis的枚举转换
 *
 * Created on 2017年12月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
@EnableConfigurationProperties(LittleFisherProperties.class)
public class MyBatisConfig implements ConfigurationCustomizer {

    @Autowired
    private LittleFisherProperties littleFisherProperties;

    @Override
    public void customize(org.apache.ibatis.session.Configuration configuration) {
        String typeEnumsPackage = littleFisherProperties.getMybatis().getTypeEnumsPackage();
        final Set<Class> classes = Sets.newHashSet();
        if (StringUtil.isNotBlank(typeEnumsPackage)) {
            String[] typeEnumsPackageArray = StringUtils
                    .tokenizeToStringArray(typeEnumsPackage, ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);
            Arrays.stream(typeEnumsPackageArray)
                    .forEach(typeEnumsPackageStr -> classes.addAll(PackageUtil.scanTypePackage(typeEnumsPackage)));

            // 取得类型转换注册器
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            try {
                for (Class cls : classes) {
                    if (cls.isEnum()) {
                        if (IEnum.class.isAssignableFrom(cls)) {
                            typeHandlerRegistry.register(cls.getName(), EnumTypeHandler.class.getName());
                        } else {
                            // 使用原生 EnumOrdinalTypeHandler
                            typeHandlerRegistry.register(cls.getName(), EnumOrdinalTypeHandler.class.getName());
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                throw new BaseAppException("CORE-000007", null, e);
            }
        }
    }
}
