package com.iot.tracker.dto.req.device;

import java.io.Serializable;

public class DeviceReqParamDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9065395470155203574L;
	
	private String deviceCode;

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	
	
	
}
