package com.iot.tracker.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.tracker.core.constants.AppCreditConstants;
import com.iot.tracker.core.constants.CacheKey;
import com.iot.tracker.core.dto.UserDto;
import com.iot.tracker.core.exception.BizEnum;
import com.iot.tracker.core.exception.BizException;
import com.iot.tracker.core.manage.UserInfoManage;
import com.iot.tracker.core.util.BizUtil;
import com.iot.tracker.core.util.Common;
import com.iot.tracker.core.util.MD5Util;
import com.iot.tracker.core.util.RedisUtil;
import com.iot.tracker.core.util.WebJsonResult;
import com.iot.tracker.core.vo.UserInfo;
import com.iot.tracker.dto.req.login.LoginReqParamDto;
import com.iot.tracker.dto.req.register.RegisterReqParamDto;
import com.iot.tracker.dto.resp.login.LonginResultDto;
import com.iot.tracker.dto.resp.register.RegisterResultDto;
import com.iot.tracker.interceptor.ValidBiz;

@Service
public class UserInfoControllerService {
	private Logger logger = LoggerFactory.getLogger(UserInfoControllerService.class);
	private final static String VERIFY_CODE = "888888";
	@Autowired
	private UserInfoManage userInfoManage;
	@Autowired
	private CheckService checkService;
	@ValidBiz
	public WebJsonResult<RegisterResultDto> register(RegisterReqParamDto registerParamDto){
		logger.info("注册时参数 param{}",registerParamDto.toString());
		checkService.checkPhoneNoIsRegister(registerParamDto.getPhoneNo());
		checkVerifyCode(registerParamDto.getPhoneNo(), registerParamDto.getVerifyCode());
		RegisterResultDto registerRespParamDto = new RegisterResultDto();
		String userCode = BizUtil.generateUserCode();
		UserDto userDto = buildUserDto(userCode, registerParamDto.getPhoneNo());
		String tocken = buildLoginToken(userDto);
		registerRespParamDto.setTocken(tocken);
		userInfoManage.saveUserInfo(userCode, registerParamDto.getPhoneNo(), registerParamDto.getPassword());;
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
		LonginResultDto longinResultDto = new LonginResultDto();
		
		UserDto userDto = buildUserDto(userInfo.getUserCode(), loginReqParamDto.getPhoneNo());
		String tocken = buildLoginToken(userDto);
		longinResultDto.setTocken(tocken);
		return WebJsonResult.buildSuccessResult(longinResultDto);
	}
	
	 private UserDto buildUserDto(String userCode,String phoneNo){
			UserDto userDto = new UserDto();
			userDto.setUserCode(userCode);
			userDto.setPhoneNo(phoneNo);
			return userDto;
			
		}
		
		private String buildLoginToken(UserDto userDto) {
			String token = MD5Util.md5Hex(System.currentTimeMillis() + userDto.getPhoneNo());
			try {
				RedisUtil.putObjByJson( CacheKey.TOKEN_CACHE_USER + token, userDto, AppCreditConstants.APP_CREDIT_REDIS_EXPIRE_TIME );
			} catch (Exception e) {
	            logger.error("构建token失败token.error ",e);
			} 
	       return token;
		}
		
	private void checkVerifyCode(String phoneNo,String verifyCode){
		Common.checkPhoneNoAndVerifyCode(phoneNo, verifyCode);
		if(!VERIFY_CODE.equals(verifyCode)){
			throw new BizException(BizEnum.SMS_VERIFY_CODE_FAIL);
		}
	}
}
