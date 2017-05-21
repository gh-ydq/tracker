package com.iot.tracker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iot.tracker.constants.TestConstants;
import com.iot.tracker.core.util.WebJsonResult;
import com.iot.tracker.dto.req.device.DeviceReqParamDto;
import com.iot.tracker.dto.resp.device.DeviceResultDto;
import com.iot.tracker.service.DeviceInfoControllerService;

@RequestMapping(value = "/device")
@RestController
public class DeviceController {
	private Logger logger = LoggerFactory.getLogger(DeviceController.class);
	
	@Autowired
	private DeviceInfoControllerService deviceInfoControllerService;
	
	@RequestMapping("/add")
	@ResponseBody
	public <T> WebJsonResult<T> addDeviceInfo(@RequestBody DeviceReqParamDto deviceReqParamDto){
		logger.info("添加设备请求参数{}",deviceReqParamDto.toString());
		return deviceInfoControllerService.addDeviceInfo(deviceReqParamDto);
	}
	
	@RequestMapping("/find")
	@ResponseBody
	public WebJsonResult<List<DeviceResultDto>> findDeviceInfo(){
		return deviceInfoControllerService.findDeviceInfo(TestConstants.userCode);
	}
}
