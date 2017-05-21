package com.iot.tracker.core.util;

import java.io.Serializable;

import com.iot.tracker.core.exception.BizEnum;


/**
 * 返回客户端json对象
 * @author cxl
 *
 */
public class WebJsonResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6168989699552155762L;
	public static final String SUCCESS = "1";
	public static final String FAIL = "-1";
	
	
	/**
	 * 返回码值
	 */
	private String retCode;
	/**
	 * 返回数据对象
	 */
	private T data;
	/**
	 * 返回消息
	 */
	private String retMsg;
	public WebJsonResult(String code, T data, String message) {
		super();
		this.retCode = code;
		this.data = data;
		this.retMsg = message;
	}
	public WebJsonResult(String code, String message) {
		super();
		this.retCode = code;
		this.retMsg = message;
	}
	public String getCode() {
		return retCode;
	}
	public void setCode(String code) {
		this.retCode = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return retMsg;
	}
	public void setMessage(String message) {
		this.retMsg = message;
	}
	@Override
	public String toString() {
		return "WebJsonResult [code=" + retCode + ", data=" + data + ", message=" + retMsg + "]";
	}
	
	
	public static <T> WebJsonResult<T> buildSuccessResult(T t) {
		return new WebJsonResult<T>(SUCCESS, t, null);
	}
	public static <T> WebJsonResult<T> buildErrorResult(String message,T object){
		return new WebJsonResult<T>(FAIL,object,message);
	}
	
	public static <T> WebJsonResult<T> buildErrorMessageResult(String message){
		return new WebJsonResult<T>(FAIL,message);
	}

	public static <T> WebJsonResult<T> buildErrorResult(BizEnum bizEnum) {
		return new WebJsonResult<T>(bizEnum.getCode(),bizEnum.getMsg());
	}
}
