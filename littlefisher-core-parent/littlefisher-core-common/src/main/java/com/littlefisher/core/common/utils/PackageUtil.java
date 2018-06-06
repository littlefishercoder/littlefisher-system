package com.littlefisher.core.common.utils;

import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import com.google.common.collect.Sets;
import com.littlefisher.core.common.exception.BaseAppException;

/**
 * Description: PackageUtil.java
 *
 * Created on 2017年12月05日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class PackageUtil {

    /**
     * 私有构造函数
     */
    private PackageUtil() {
    }

    /**
     * 扫描获取指定包路径所有类
     *
     * @param typePackage 扫描类包路径
     * @return Class的集合
     */
    public static Set<Class> scanTypePackage(String typePackage) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);
        String pkg = ClassUtils.convertClassNameToResourcePath(typePackage) + ".class";
        /*
         * 将加载多个绝对匹配的所有Resource
         * 将首先通过ClassLoader.getResource("META-INF")加载非模式路径部分，然后进行遍历模式匹配，排除重复包路径
         */
        try {
            Set<Class> set = Sets.newHashSet();
            Resource[] resources = resolver.getResources(pkg);
            if (ArrayUtils.isNotEmpty(resources)) {
                MetadataReader metadataReader;
                for (Resource resource : resources) {
                    if (resource.isReadable()) {
                        metadataReader = metadataReaderFactory.getMetadataReader(resource);
                        set.add(Class.forName(metadataReader.getClassMetadata().getClassName()));
                    }
                }
            }
            return set;
        } catch (Exception e) {
            throw new BaseAppException("CORE-000007", null, e);
        }
    }
}
