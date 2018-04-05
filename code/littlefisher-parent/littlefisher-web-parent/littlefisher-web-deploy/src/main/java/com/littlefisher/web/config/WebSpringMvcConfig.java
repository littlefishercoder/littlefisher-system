package com.littlefisher.web.config;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.littlefisher.core.common.utils.DateUtil;
import com.littlefisher.core.mvc.DateConverter;

/**
 * Description: WebSpringMVCConfig
 *
 * Created on 2017年4月19日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
public class WebSpringMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

        // 所有swagger目录的访问，直接访问location指定的目录
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * Description:
     *
     * @return CommonsMultipartResolver
     */
    @Bean
    public CommonsMultipartResolver commonsMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();

        // 默认编码格式 默认ISO-8859-1
        commonsMultipartResolver.setDefaultEncoding(Charsets.UTF_8.displayName());

        // 设置允许上传的最大文件大小，以字节为单位计算。当设为-1时表示无限制，默认是-1
        commonsMultipartResolver.setMaxUploadSize(10485760);

        // 设置在文件上传时允许写到内存中的最大值，以字节为单位计算，默认是10240
        commonsMultipartResolver.setMaxInMemorySize(4096);

        return commonsMultipartResolver;
    }

    /**
     * Description: 设置springdispatch默认名字为default
     *
     * @param configurer configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        // 类似于使用<mvc:default-servlet-handler />
        configurer.enable();
    }

    /**
     * Description: 消息转换器配置
     *
     * @param converters converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper om = jacksonConverter.getObjectMapper();

        om.setDateFormat(new SimpleDateFormat(DateUtil.DATETIME_FORMAT_1));
        om.setLocale(Locale.CHINA);
        om.setTimeZone(TimeZone.getTimeZone("GMT+8"));

        List<MediaType> mediaTypeList = Lists.newArrayList();

        mediaTypeList.add(new MediaType(MediaType.APPLICATION_JSON, Charsets.UTF_8));
        mediaTypeList.add(new MediaType(MediaType.TEXT_HTML, Charsets.UTF_8));
        jacksonConverter.setSupportedMediaTypes(mediaTypeList);

        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(Charsets.UTF_8);

        stringConverter.setWriteAcceptCharset(false);

        // 保持以下顺序
        // "application/json" "application/*+json"
        converters.add(jacksonConverter);

        // "application/xml" "text/xml" "application/*+xml"
        converters.add(new Jaxb2RootElementHttpMessageConverter());

        // "application/xml" "text/xml" "application/*+xml"
        converters.add(new SourceHttpMessageConverter<>());

        // "application/x-www-form-urlencoded" "multipart/form-data"
        converters.add(new AllEncompassingFormHttpMessageConverter());

        // "application/octet-stream" "*/*"
        converters.add(new ByteArrayHttpMessageConverter());

        // "text/plain" "*/*"
        converters.add(stringConverter);

        // "*/*"
        converters.add(new ResourceHttpMessageConverter());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());

    }

}