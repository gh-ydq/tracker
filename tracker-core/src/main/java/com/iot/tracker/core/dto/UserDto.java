package com.iot.tracker.core.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 7711494659867363078L;

	private String userCode;

    private String phoneNo;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
    
    
}
