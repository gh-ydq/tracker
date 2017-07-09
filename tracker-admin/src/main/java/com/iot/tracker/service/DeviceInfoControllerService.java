package com.iot.tracker.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.tracker.core.exception.BizEnum;
import com.iot.tracker.core.exception.BizException;
import com.iot.tracker.core.manage.UserDeviceInfoManage;
import com.iot.tracker.core.util.WebJsonResult;
import com.iot.tracker.core.vo.UserDeviceInfo;
import com.iot.tracker.dto.req.device.DeviceReqParamDto;
import com.iot.tracker.dto.resp.device.DeviceResultDto;
import com.iot.tracker.interceptor.ValidBiz;

@Service
public class DeviceInfoControllerService {
	private Logger logger = LoggerFactory.getLogger(DeviceInfoControllerService.class);
	@Autowired
	private UserDeviceInfoManage userdeviceInfoManage;
	
	@ValidBiz
	public <T> WebJsonResult<T> addDeviceInfo(String userCode,DeviceReqParamDto deviceReqParamDto){
		logger.info("用户 userCode={},添加设备 deviceCode={}",userCode,deviceReqParamDto.getDeviceCode());
		UserDeviceInfo userDeviceInfo = userdeviceInfoManage.findByUserCodeAndDeviceCode(userCode, deviceReqParamDto.getDeviceCode());
		if(userDeviceInfo != null){
			throw new BizException(BizEnum.DEVICE_EXIST);
		}
		userdeviceInfoManage.saveUserDeviceInfo(userCode, deviceReqParamDto.getDeviceCode());
		return WebJsonResult.buildSuccessResult(null);
	}
	
	
	@ValidBiz
	public WebJsonResult<List<DeviceResultDto>> findDeviceInfo(String userCode){
		List<UserDeviceInfo> userDeviceInfos = userdeviceInfoManage.findUserDeviceInfos(userCode);
		List<DeviceResultDto> deviceResultDtos =  buildDeviceResultDtos(userDeviceInfos);
		
		return WebJsonResult.buildSuccessResult(deviceResultDtos);
	}
	
	
	
	private List<DeviceResultDto> buildDeviceResultDtos(List<UserDeviceInfo> userDeviceInfos){
		
		List<DeviceResultDto> deviceResultDtos = new ArrayList<DeviceResultDto>();
		for(UserDeviceInfo userDeviceInfo : userDeviceInfos){
			DeviceResultDto deviceResultDto = new DeviceResultDto();
			deviceResultDto.setDeviceCode(userDeviceInfo.getDeviceCode());
			deviceResultDto.setLat(userDeviceInfo.getLat());
			deviceResultDto.setLgt(userDeviceInfo.getLgt());
			deviceResultDtos.add(deviceResultDto);
		}
		return deviceResultDtos;
	}
}
