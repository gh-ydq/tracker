package com.iot.tracker.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iot.tracker.core.dao.UserDeviceInfoMapper;
import com.iot.tracker.core.vo.UserDeviceInfo;
import com.iot.tracker.core.vo.UserDeviceInfoExample;

@Service
public class UserDeviceInfoService {
	@Autowired
	private UserDeviceInfoMapper userDeviceInfoMapper;
	
	@Transactional
	public void saveUserDeviceInfo(String userCode,String deviceCode){
		UserDeviceInfo userDeviceInfo = buildUserDeviceInfo(userCode, deviceCode);
		userDeviceInfoMapper.insertSelective(userDeviceInfo);
		
	}
	
	public List<UserDeviceInfo> findUserDeviceInfos(String userCode){
		UserDeviceInfoExample example = new UserDeviceInfoExample();
		example.createCriteria().andUserCodeEqualTo(userCode);
		return userDeviceInfoMapper.selectByExample(example);
	}
	
	private UserDeviceInfo buildUserDeviceInfo(String userCode,String deviceCode){
		UserDeviceInfo record = new UserDeviceInfo();
		record.setUserCode(userCode);
		record.setDeviceCode(deviceCode);
		return record;
	}
}
