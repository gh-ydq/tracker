package com.iot.tracker.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.tracker.core.exception.BizEnum;
import com.iot.tracker.core.exception.BizException;
import com.iot.tracker.core.interceptor.ValidBiz;
import com.iot.tracker.core.manage.UserInfoManage;
import com.iot.tracker.core.util.Common;
import com.iot.tracker.core.util.WebJsonResult;
import com.iot.tracker.core.vo.UserInfo;
import com.iot.tracker.dto.req.login.LoginReqParamDto;
import com.iot.tracker.dto.req.register.RegisterReqParamDto;
import com.iot.tracker.dto.resp.login.LonginResultDto;
import com.iot.tracker.dto.resp.register.RegisterResultDto;

@Service
public class UserInfoControllerService {
	private Logger logger = LoggerFactory.getLogger(UserInfoControllerService.class);
	private final static String VERIFY_CODE = "8888";
	@Autowired
	private UserInfoManage userInfoManage;
	
	@ValidBiz
	public WebJsonResult<RegisterResultDto> register(RegisterReqParamDto registerParamDto){
		logger.info("注册时参数 param{}",registerParamDto.toString());
		checkVerifyCode(registerParamDto.getPasword(), registerParamDto.getVerifyCode());
		RegisterResultDto registerRespParamDto = new RegisterResultDto();
		registerRespParamDto.setTocken("1234567");
		String userCode = "123456";
		userInfoManage.saveUserInfo(userCode, registerParamDto.getPhoneNo(), registerParamDto.getPasword());;
		return WebJsonResult.buildSuccessResult(registerRespParamDto);
	}
	
	@ValidBiz
	public WebJsonResult<LonginResultDto> login(LoginReqParamDto loginReqParamDto){
		logger.info("登录时参数{}",loginReqParamDto.toString());
		UserInfo userInfo = userInfoManage.findUserInfoByPhoneNo(loginReqParamDto.getPhoneNo());
		if(userInfo == null){
			throw new BizException(BizEnum.USER_NO_EXIST);
		}else if(!userInfo.getPassword().equals(loginReqParamDto.getPassword())){
			throw new BizException(BizEnum.USER_PASSWORD_ERROR);
		}
		LonginResultDto LonginResultDto = new LonginResultDto();
		LonginResultDto.setTocken("1234567");
		return WebJsonResult.buildSuccessResult(LonginResultDto);
	}
	
	private void checkVerifyCode(String phoneNo,String verifyCode){
		Common.checkPhoneNoAndVerifyCode(phoneNo, verifyCode);
		if(!VERIFY_CODE.equals(verifyCode)){
			throw new BizException(BizEnum.SMS_VERIFY_CODE_FAIL);
		}
	}
}
