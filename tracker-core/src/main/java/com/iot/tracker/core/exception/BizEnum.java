package com.iot.tracker.core.exception;

public enum BizEnum {
	// 系统类错误,以E_SYS_开头区间[19900-19999]
	E_SYS_ERROR("9999", "系统繁忙，请稍后再试"),
	E_SYS_PARAM_ERROR("9901","参数格式错误,请确认后重试"),
	E_SYS_NOT_LOGIN("9902","token超时,请重新登录账户"),
	E_SYS_NO_TOKEN("9903","请先登录账户"),
	E_VERIFY_SIGN_FAIL("9904","验签不通过,请求不合法"),
	E_SYS_HANLER_ERROR("9905","系统处理异常，请稍后再试"),

	//用户相关code 1000-1999
	USER_EXIST("1000","用户已经存在"),
	USER_NO_EXIST("1002","用户不存在，请注册"),
	USER_PHONE_REGITERED("1004","该手机号已注册"),
	
	USER_PASSWORD_ERROR("1003","密码错误"),
	SMS_VERIFY_CODE_FAIL("1001","短信验证码错误,请重新获取"),


	/* --------下面是信息类的,以L_PHONE,L_SMS_或者L_JMS_开头,区间[23000-23999]-------- */
	L_PHONL_NO_NULL("23000","请输入11位有效手机号码"),
	L_PHONE_NO_FORMAT_ERROR("23001","请输入11位有效手机号码"),


	L_SMS_CODE_NULL("23002","手机短信码为空!"),
	L_SMS_CODE_FORMAT_ERROR("23003","手机短信码格式错误"),
	L_SMS_CODE_SEND_FAIL("23004","手机短信码发送失败"),
	L_SMS_CODE_VALID_FAIL("23005","手机短信码校验失败"),
	L_SMS_CODE_INVALID("23006","手机短信码错误或已失效"),


	E_PHONE_NO_NULL("13000","手机号码为空"),
	E_PHONE_NO_FORMAT_ERROR("13001","请输入11位有效手机号码"),

	E_SMS_CODE_NULL("13002","手机短信码为空!"),
	E_SMS_CODE_FORMAT_ERROR("13003","手机短信码格式错误"),
	E_SMS_CODE_SEND_FAIL("13004","手机短信码发送失败"),
	E_SMS_CODE_VALID_FAIL("13005","手机短信码校验失败"),
	E_SMS_CODE_INVALID("13006","手机短信码错误或已失效"),

	;

	private String code;
	private String msg;

	BizEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
