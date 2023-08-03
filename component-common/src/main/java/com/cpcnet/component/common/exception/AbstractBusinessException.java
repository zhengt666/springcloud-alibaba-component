package com.cpcnet.component.common.exception;


import com.cpcnet.component.common.resp.ResponseCode;

/**
 * @author Ebon Zheng
 */
public abstract class AbstractBusinessException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private Integer responseCode = null;
    
    private Object data;
    
    public AbstractBusinessException() {
        super();
    }
    
    public AbstractBusinessException(String msg) {
        super(msg);
    }
    
    public AbstractBusinessException(String msg, Integer responseCode) {
        super(msg);
        this.responseCode = responseCode;
    }
    
    public AbstractBusinessException(String msg, Integer responseCode, Object o) {
        super(msg);
        this.responseCode = responseCode;
        this.data = o;
    }
    
    public AbstractBusinessException(String msgTemplate, Object[] objs) {
        super(String.format(msgTemplate, objs));
    }
    
    public AbstractBusinessException(Exception e) {
        super(e);
    }
    
    public AbstractBusinessException(String msg, Exception e) {
        super(msg, e);
    }
    
    
    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }
    
    /**
     * 子类覆盖此方法返回不同的业务异常代码
     */
    public int getResponseCode() {
        if (null == responseCode) {
            responseCode = ResponseCode.BUSINESS_EXCEPTION.getCode();
        }
        return responseCode;
    }
    
    /**
     * 子类覆盖此方法返回不同的业务数据
     */
    public Object getData() {
        return data;
    }
}