package com.iot.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.tracker.core.exception.BizEnum;
import com.iot.tracker.core.exception.BizException;
import com.iot.tracker.core.manage.UserInfoManage;
import com.iot.tracker.core.vo.UserInfo;

@Service
public class CheckService {
	@Autowired
	private UserInfoManage userInfoManage;
	
	public void checkPhoneNoIsRegister(String phoneNo){
		UserInfo userInfo = userInfoManage.findUserInfoByPhoneNo(phoneNo);
		if(userInfo != null){
			throw new BizException(BizEnum.USER_PHONE_REGITERED);
		}
	}
	
}
