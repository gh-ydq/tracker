package com.iot.tracker.dto.req.login;

import java.io.Serializable;

public class LoginReqParamDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4237068759010720238L;
	private String phoneNo;
	private String password;
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "RegisterReqParamDto [phoneNo=" + phoneNo + ", password=" + password + "]";
	}
	
	
}
