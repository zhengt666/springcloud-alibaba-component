package com.cpcnet.component.common.exception;


/**
 * @author Ebon Zheng
 */
public class DefaultBusinessException extends AbstractBusinessException {
    
    private static final long serialVersionUID = 1L;
    
    public DefaultBusinessException(String msg) {
        super(msg);
    }
    
    public DefaultBusinessException(String msg, Integer responseCode) {
        super(msg, responseCode);
    }
    
    public DefaultBusinessException(String msg, Integer responseCode, Object o) {
        super(msg, responseCode, o);
    }
    
    public DefaultBusinessException(String msg, Exception e) {
        super(msg, e);
    }
    
    public DefaultBusinessException(String msg, Object... objs) {
        super(msg, objs);
    }
    
    /**
     * 子类覆盖此方法返回不同的业务异常代码
     */
    @Override
    public int getResponseCode() {
        return super.getResponseCode();
    }
    
    /**
     * 子类覆盖此方法返回不同的业务数据
     */
    @Override
    public Object getData() {
        return super.getData();
    }
}