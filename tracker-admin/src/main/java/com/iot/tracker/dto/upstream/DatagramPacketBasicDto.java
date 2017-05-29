package com.iot.tracker.dto.upstream;

import java.io.Serializable;

/**
 * socket
 * @author yudengqiu
 *
 */
public class DatagramPacketBasicDto  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7869686439958718471L;
	private char header0;
	private char header1;
	// IMEI 号
	private int imei;
	public char getHeader0() {
		return header0;
	}
	public void setHeader0(char header0) {
		this.header0 = header0;
	}
	public char getHeader1() {
		return header1;
	}
	public void setHeader1(char header1) {
		this.header1 = header1;
	}
	public int getImei() {
		return imei;
	}
	public void setImei(int imei) {
		this.imei = imei;
	}
	
}
