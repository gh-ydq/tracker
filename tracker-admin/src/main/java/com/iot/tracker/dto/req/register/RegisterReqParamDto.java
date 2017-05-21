package com.iot.tracker.dto.req.register;


public class RegisterReqParamDto{

	private String phoneNo;
	private String verifyCode;
	private String pasword;
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	@Override
	public String toString() {
		return "RegisterReqParamDto [phoneNo=" + phoneNo + ", verifyCode=" + verifyCode + ", pasword=" + pasword + "]";
	}
	
	
}
