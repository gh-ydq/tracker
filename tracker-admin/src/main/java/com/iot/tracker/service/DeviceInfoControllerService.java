package com.iot.tracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iot.tracker.constants.TestConstants;
import com.iot.tracker.core.interceptor.ValidBiz;
import com.iot.tracker.core.manage.UserDeviceInfoManage;
import com.iot.tracker.core.util.WebJsonResult;
import com.iot.tracker.core.vo.UserDeviceInfo;
import com.iot.tracker.dto.req.device.DeviceReqParamDto;
import com.iot.tracker.dto.resp.device.DeviceResultDto;

@Service
public class DeviceInfoControllerService {
	
	@Autowired
	private UserDeviceInfoManage userdeviceInfoManage;
	
	@ValidBiz
	public <T> WebJsonResult<T> addDeviceInfo(DeviceReqParamDto deviceReqParamDto){
		userdeviceInfoManage.saveUserDeviceInfo(TestConstants.userCode, deviceReqParamDto.getDeviceCode());
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
		DeviceResultDto deviceResultDto = new DeviceResultDto();
		for(UserDeviceInfo userDeviceInfo : userDeviceInfos){
			deviceResultDto.setDeviceCode(userDeviceInfo.getDeviceCode());
			deviceResultDtos.add(deviceResultDto);
		}
		return deviceResultDtos;
	}
}
