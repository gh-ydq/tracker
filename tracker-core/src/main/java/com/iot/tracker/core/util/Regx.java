package com.iot.tracker.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regx {

	
	//手机号校验
	public static boolean checkMobile(String mobile){
		String rex = "^1[3\\|4\\|5\\|7\\|8]\\d{9}$";
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile(rex); // 验证手机号
		m = p.matcher(mobile);
		b = m.matches();
		return b; 
	}

	// 短信验证码校验
	public static boolean checkMobileVerifyCode(String verifyCode) {
		String rex = "^\\d{6}$";
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile(rex);
		m = p.matcher(verifyCode);
		b = m.matches();
		return b;
	}

	// 姓名
	public static boolean checkName(String verifyCode) {
		String rex = "^[a-zA-Z0-9\u4e00-\u9fa5 ]{1,30}$";
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile(rex);
		m = p.matcher(verifyCode);
		b = m.matches();
		return b;
	}
			
	
	public static void main(String[] args) {
		
//		System.out.println(checkMobile(""));
		
		System.out.println(checkMobileVerifyCode("908899"));
	}
}
