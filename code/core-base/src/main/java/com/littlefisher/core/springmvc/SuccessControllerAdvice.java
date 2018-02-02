package com.littlefisher.core.springmvc;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.littlefisher.core.stereotype.constants.BaseConstants;
import com.littlefisher.core.stereotype.enums.EnumResult;
import com.littlefisher.core.utils.LittleFisherLogger;

/**
 * Description: SuccessControllerAdvice.java
 * 针对正常请求的Controller，增加结果封装
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ControllerAdvice
public class SuccessControllerAdvice implements ResponseBodyAdvice<Object> {

    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(SuccessControllerAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest httpRequest = (ServletServerHttpRequest) request;
            String servletPath = httpRequest.getServletRequest()
                    .getServletPath();
            if (servletPath.startsWith(BaseConstants.BASE_API_PREFIX)) {
                logger.debug("对{}开头的请求，返回信息进行封装", BaseConstants.BASE_API_PREFIX);
                if (!(body instanceof CommonResponse)) {
                    return new CommonResponse(EnumResult.SUCCESS, body);
                }
            }
        }
        return body;
    }
}
