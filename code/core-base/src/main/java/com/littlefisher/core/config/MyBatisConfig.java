package com.littlefisher.core.config;

import java.util.Set;

import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.google.common.collect.Sets;
import com.littlefisher.core.mybatis.EnumTypeHandler;
import com.littlefisher.core.mybatis.IEnum;
import com.littlefisher.core.utils.StringUtil;

/**
 * Description: MyBatisConfig.java
 *
 * Created on 2017年12月04日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
public class MyBatisConfig implements ConfigurationCustomizer {

    private String typeEnumsPackage = "com.littlefisher.blog.enums";

    @Override
    public void customize(org.apache.ibatis.session.Configuration configuration) {
        if (StringUtil.isNotBlank(typeEnumsPackage)) {
            Set<Class> classes;
            String[] typeEnumsPackageArray = StringUtils.tokenizeToStringArray(this.typeEnumsPackage,
                    ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);
            classes = Sets.newHashSet();
            ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<>();
            for (String typePackage : typeEnumsPackageArray) {
                resolverUtil.find(new ResolverUtil.IsA(IEnum.class), typePackage);
                Set<Class<? extends Class<?>>> handlerSet = resolverUtil.getClasses();
                classes.addAll(handlerSet);
            }
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
                e.printStackTrace();
            }
        }
    }
}
