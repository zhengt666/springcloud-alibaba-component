package com.cpcnet.component.common.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring上下文工具类
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {
    
    private static ApplicationContext context;
    
    public static ApplicationContext getContext() {
        return context;
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
