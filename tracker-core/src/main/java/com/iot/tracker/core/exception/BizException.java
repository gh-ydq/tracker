package com.iot.tracker.core.exception;


/**
 * Created by zy on 2016/9/28.
 */
public class BizException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8063310538120099926L;
	private String code;
    private String msg;

    public BizException() {
    	super("");
    }


    public BizException(BizEnum bizEnum) {
    	super(bizEnum.toString());
        this.code = bizEnum.getCode();
        this.msg = bizEnum.getMsg();
    }

    public BizException(String code, String msg) {
    	super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


	@Override
	public String toString() {
		return "BizException [code=" + code + ", msg=" + msg + "]";
	}
    
    
}
