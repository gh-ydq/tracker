package com.iot.tracker.dto.resp.device;

import java.io.Serializable;

public class DeviceResultDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8886120247454407272L;
	private String deviceCode;
	private double lat;
	private double lgt;
	public String getDeviceCode() {
		return deviceCode;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLgt() {
		return lgt;
	}
	public void setLgt(double lgt) {
		this.lgt = lgt;
	}
	
	
	
}
