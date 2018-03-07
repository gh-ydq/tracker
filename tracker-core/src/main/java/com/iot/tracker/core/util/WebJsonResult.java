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
	public static final String SUCCESS = "0000";
	public static final String FAIL = "9999";
	
	
	/**
	 * 
	 */
	private boolean result;
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
	
	public WebJsonResult(boolean result ,String code, T data, String message) {
		super();
		this.result = result;
		this.retCode = code;
		this.data = data;
		this.retMsg = message;
	}
	public WebJsonResult(boolean result ,String code, String message) {
		super();
		this.result = result;
		this.retCode = code;
		this.retMsg = message;
	}
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	@Override
	public String toString() {
		return "WebJsonResult [retCode=" + retCode + ", data=" + data + ", retMsg=" + retMsg + "]";
	}
	
	
	public static <T> WebJsonResult<T> buildSuccessResult(T t) {
		return new WebJsonResult<T>(true,SUCCESS, t, null);
	}
	public static <T> WebJsonResult<T> buildErrorResult(String message,T object){
		return new WebJsonResult<T>(false,FAIL,object,message);
	}
	
	public static <T> WebJsonResult<T> buildErrorMessageResult(String message){
		return new WebJsonResult<T>(false,FAIL,message);
	}

	public static <T> WebJsonResult<T> buildErrorResult(BizEnum bizEnum) {
		return new WebJsonResult<T>(false,bizEnum.getCode(),bizEnum.getMsg());
	}
}
