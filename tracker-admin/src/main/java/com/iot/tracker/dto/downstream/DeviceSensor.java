package com.iot.tracker.dto.downstream;

import java.io.Serializable;

public class DeviceSensor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5425370280312638057L;
	
	private String cmdType;
	private long imei;
	private String param;
	
	public String getCmdType() {
		return cmdType;
	}
	public void setCmdType(String cmdType) {
		this.cmdType = cmdType;
	}
	public long getImei() {
		return imei;
	}
	public void setImei(long imei) {
		this.imei = imei;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
	
	
	

}
