package com.cpcnet.component.common;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

/**
 *
 * @author Ebon Zheng
 *
 */
public class AbstractObject {
    
    /**
     * 浅度克隆
     *
     * @param target target
     * @return 处理结果
     * @throws BeansException bean拷贝异常
     */
    public <T> T clone(T target) throws Exception {
        BeanUtils.copyProperties(this, target);
        return target;
    }
    
    /**
     * 浅度克隆
     *
     * @param clazz target class
     * @return Target
     * @throws BeansException bean拷贝异常
     */
    public <T> T clone(Class<T> clazz) throws Exception {
        T target = clazz.newInstance();
        BeanUtils.copyProperties(this, target);
        return target;
    }
}