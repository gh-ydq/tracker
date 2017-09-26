package com.iot.tracker.dto.downstream;

import java.io.Serializable;

public class DeviceSwitchReqDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8914278873142354042L;
	
	private String cmdType;
	private long imei;
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
	
	
	

}
