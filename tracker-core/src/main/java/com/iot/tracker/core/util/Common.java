package com.iot.tracker.core.util;

import org.apache.commons.lang3.StringUtils;

import com.iot.tracker.core.exception.BizEnum;
import com.iot.tracker.core.exception.BizException;



public abstract class Common {

	
	/**
	 * 校验手机号
	 * @param mobile
	 * @return
	 */
	public static void  checkPhoneNo(String phoneNo){
		//验证手机号是否为空
		if (StringUtils.isEmpty(phoneNo)) {
			throw new BizException(BizEnum.L_PHONL_NO_NULL);
		}
		//验证手机号格式
		if (!Regx.checkMobile(phoneNo)) {
			throw new BizException(BizEnum.E_PHONE_NO_FORMAT_ERROR);
		}
	}
	
	/**
	 * 校验手机短信码
	 * @param verifyCode
	 * @return
	 */
	public static void checkPhoneNoVerifyCode(String verifyCode){
		//验证手机短信码是否为空
		if (StringUtils.isEmpty(verifyCode)) {
			throw new BizException(BizEnum.L_SMS_CODE_NULL);
		}
		//验证手机短信码格式
		if (!Regx.checkMobileVerifyCode(verifyCode)) {
			throw new BizException(BizEnum.L_SMS_CODE_FORMAT_ERROR);
		}
	}
	
	public static void  checkPhoneNoAndVerifyCode(String phoneNo,String verifyCode){
         checkPhoneNo(phoneNo);
         checkPhoneNoVerifyCode(verifyCode);
	}
	
	/**
	 * 校验用户编号
	 * @param usercode
	 * @return
	 */
	public static void  checkUsercode(String usercode){
		//验证手机号是否为空
		if (StringUtils.isEmpty(usercode)) {
			throw new BizException(BizEnum.L_PHONL_NO_NULL);
		}
	}
	
	
}
