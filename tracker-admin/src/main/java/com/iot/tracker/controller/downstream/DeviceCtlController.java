package com.iot.tracker.controller.downstream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iot.tracker.core.constants.PowerSwitchEnum;
import com.iot.tracker.core.exception.BizEnum;
import com.iot.tracker.core.exception.BizException;
import com.iot.tracker.core.util.WebJsonResult;
import com.iot.tracker.dto.downstream.DeviceSensor;
import com.iot.tracker.dto.downstream.DeviceSwitchReqDto;
import com.qdigo.iotsdk.DeviceCtl;
import com.qdigo.iotsdk.constant.CmdEnum;

@RequestMapping(value = "/downstream")
@RestController
public class DeviceCtlController {
	private Logger logger = LoggerFactory.getLogger(DeviceCtlController.class);
	
	
	@RequestMapping(value="/deviceSwitch")
	@ResponseBody
	public WebJsonResult<String> powerSwitch(@RequestBody DeviceSwitchReqDto deviceSwitchReqDto){
		logger.info("发送下行命令cmdType={},imei={}",deviceSwitchReqDto.getCmdType(),deviceSwitchReqDto.getImei());
		String switchCmd = deviceSwitchReqDto.getCmdType();
		long imei = deviceSwitchReqDto.getImei();
		DeviceCtl deviceCtl = new DeviceCtl();
		if(PowerSwitchEnum.POWERS_WITCH_START.getCmd().equals(switchCmd)){
			deviceCtl.deviceStart(imei);
		}else if(PowerSwitchEnum.POWERS_WITCH_STOP.getCmd().equals(switchCmd)){
			deviceCtl.deviceFlameout(imei);
		}else{
			throw new BizException(BizEnum.DEVICE_CMD_NOT_EXIST);
		}
		return WebJsonResult.buildSuccessResult("cmd success");
	}
	
	
	@RequestMapping(value="/deviceSensor")
	@ResponseBody
	public WebJsonResult<String> deviceSensor(@RequestBody DeviceSensor deviceSensor){
		logger.info("发送下行命令cmdType={},imei={}",deviceSensor.getCmdType(),deviceSensor.getImei());
		String switchCmd = deviceSensor.getCmdType();
		long imei = deviceSensor.getImei();
		DeviceCtl deviceCtl = new DeviceCtl();
		if(PowerSwitchEnum.SENSOR_DEVICE.getCmd().equals(switchCmd)){
			deviceCtl.sensor(imei, CmdEnum.CMD_SENSOR, deviceSensor.getParam());
		}else{
			throw new BizException(BizEnum.DEVICE_SENSOR_CMD_NOT_EXIST);
		}
		return WebJsonResult.buildSuccessResult("sensor cmd success");
	}
}
