package com.iot.tracker.core.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iot.tracker.core.exception.BizEnum;
import com.iot.tracker.core.exception.BizException;
import com.iot.tracker.core.service.UserInfoService;
import com.iot.tracker.core.vo.UserInfo;

@Component
public class UserInfoManage {
	@Autowired
	private UserInfoService userInfoService;
	
	public void saveUserInfo(String userCode,String phoneNo,String password){
		UserInfo userInfo = findUserInfo(userCode);
		if(userInfo != null){
			throw new BizException(BizEnum.USER_EXIST);
		}
		userInfoService.saveUserInfo(userCode, phoneNo, password);
	}
	
	private UserInfo findUserInfo(String userCode){
		return userInfoService.findUserInfo(userCode);
	}
	
	public UserInfo findUserInfoByPhoneNo(String phoneNo){
		return userInfoService.findUserInfoByPhoneNo(phoneNo);
	}
	
}
