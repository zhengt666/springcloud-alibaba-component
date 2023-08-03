package com.cpcnet.component.componentrpc.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;

import java.util.List;

/**
 * @author Ebon Zheng
 */
public class RequestResponseBodyMethodProcessor extends org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor {

    public RequestResponseBodyMethodProcessor(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }

    public RequestResponseBodyMethodProcessor(List<HttpMessageConverter<?>> converters,
                                              List<Object> requestResponseBodyAdvice) {
        super(converters, requestResponseBodyAdvice);
    }

    public RequestResponseBodyMethodProcessor(List<HttpMessageConverter<?>> converters,
                                              ContentNegotiationManager manager, List<Object> requestResponseBodyAdvice) {
        super(converters, manager, requestResponseBodyAdvice);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (AnnotatedElementUtils.hasAnnotation(parameter.getContainingClass(), FeignClient.class)
                && isCustomizedType(parameter.getParameterType())) {
            return true;
        }
        return super.supportsParameter(parameter);
    }

    private boolean isCustomizedType(Class<?> cls) {
        return cls.getName().startsWith("com.iflytek");
    }

}
