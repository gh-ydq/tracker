package com.iot.tracker.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iot.tracker.core.dao.UserInfoMapper;
import com.iot.tracker.core.vo.UserInfo;
import com.iot.tracker.core.vo.UserInfoExample;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoMapper userInfoMapper;
   
	@Transactional
   public void saveUserInfo(String userCode,String phoneNo,String password){
		
		UserInfo userInfo = buildUserInfo(userCode, phoneNo, password);
		userInfoMapper.insertSelective(userInfo);
	}
   
   public UserInfo findUserInfo(String userCode){
	   UserInfoExample example = new UserInfoExample();
	   example.createCriteria().andUserCodeEqualTo(userCode);
	   List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
	   return userInfos.size()<1?null:userInfos.get(0);
	}
   
   public UserInfo findUserInfoByPhoneNo(String phoneNo){
	   UserInfoExample example = new UserInfoExample();
	   example.createCriteria().andPhoneNoEqualTo(phoneNo);
	   List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
	   return userInfos.size()<1?null:userInfos.get(0);
	}
   
	
	private UserInfo buildUserInfo(String userCode,String phoneNo,String password){
		UserInfo userInfo = new UserInfo();
		userInfo.setUserCode(userCode);
		userInfo.setPhoneNo(phoneNo);
		userInfo.setPassword(password);
		userInfo.setCreateTime(new Date());
		userInfo.setUpdatedTime(new Date());
		return userInfo;
	}
}
