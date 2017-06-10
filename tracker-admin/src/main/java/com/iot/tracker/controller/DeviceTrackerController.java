package com.iot.tracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iot.tracker.core.manage.DataPackageLogManage;
import com.iot.tracker.core.util.WebJsonResult;
import com.iot.tracker.core.vo.DataPackageLog;
import com.iot.tracker.dto.resp.device.DeviceResultDto;
import com.iot.tracker.session.UserContainer;

@RestController
@RequestMapping(value="deviceTracker")
public class DeviceTrackerController {
	@Autowired
	private DataPackageLogManage dataPackageLogManage;
	
	@RequestMapping(value="find")
	public WebJsonResult<List<DeviceResultDto>> findDeviceTracker(String deviceCode){
		List<DataPackageLog> dataPackageLogs = dataPackageLogManage.queryDataPackageLog(UserContainer.getUserCode(), deviceCode);
		List<DeviceResultDto> deviceResultDtos = buildDeviceResultDtos(dataPackageLogs);
		return WebJsonResult.buildSuccessResult(deviceResultDtos);
	}
	
	private List<DeviceResultDto> buildDeviceResultDtos(List<DataPackageLog> dataPackageLogs){
		List<DeviceResultDto> deviceResultDtos = new ArrayList<DeviceResultDto>();
		int size = dataPackageLogs.size();
		int i =0;
		while(Math.pow(2, i)<size){
			deviceResultDtos.add(buildDeviceResultDto(dataPackageLogs.get(Double.valueOf(Math.pow(2, i)).intValue())));
			++i;
		}
		deviceResultDtos.add(buildDeviceResultDto(dataPackageLogs.get(size-1)));
		return deviceResultDtos;
	}
	
	private DeviceResultDto buildDeviceResultDto(DataPackageLog dataPackageLog){
		DeviceResultDto deviceResultDto = new DeviceResultDto();
		deviceResultDto.setDeviceCode(dataPackageLog.getDeviceCode());
		deviceResultDto.setLat(dataPackageLog.getLat());
		deviceResultDto.setLgt(dataPackageLog.getLgt());
		return deviceResultDto;
	}
}
