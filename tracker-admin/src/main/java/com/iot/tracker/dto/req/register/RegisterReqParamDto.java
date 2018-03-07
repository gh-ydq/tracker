package com.iot.tracker.dto.req.register;


public class RegisterReqParamDto{

	private String phoneNo;
	private String verifyCode;
	private String password;
	private String confirmPwd;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	
	@Override
	public String toString() {
		return "RegisterReqParamDto [phoneNo=" + phoneNo + ", verifyCode=" + verifyCode + ", password=" + password
				+ ", confirmPwd=" + confirmPwd + "]";
	}
	
	
	
	
	
}
