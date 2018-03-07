package com.iot.tracker.core.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iot.tracker.core.service.UserDeviceInfoService;
import com.iot.tracker.core.vo.UserDeviceInfo;


@Component
public class UserDeviceInfoManage {
	@Autowired
	private UserDeviceInfoService userDeviceInfoService;
	
	public void saveUserDeviceInfo(String userCode,String deviceCode){
		userDeviceInfoService.saveUserDeviceInfo(userCode, deviceCode);	
	}
	
	public List<UserDeviceInfo> findUserDeviceInfos(String userCode){
		return userDeviceInfoService.findUserDeviceInfos(userCode);
	}
	
	public UserDeviceInfo findByDeviceCode(String deviceCode){
		return userDeviceInfoService.findByDeviceCode(deviceCode);
	}
	
	public UserDeviceInfo findByUserCodeAndDeviceCode(String userCode,String deviceCode){
		return userDeviceInfoService.findByUserCodeAndDeviceCode(userCode, deviceCode);
	}
	
	public void updateUserDeviceInfo(UserDeviceInfo userDeviceInfo,String userCode,String deviceCode){
		userDeviceInfoService.updateUserDeviceInfo(userDeviceInfo, userCode, deviceCode);
	}
}
