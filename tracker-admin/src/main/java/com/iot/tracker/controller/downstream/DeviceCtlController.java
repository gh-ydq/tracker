package com.iot.tracker.controller.downstream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iot.tracker.controller.cmd.CmdController;
import com.iot.tracker.core.constants.PowerSwitchEnum;
import com.iot.tracker.core.exception.BizEnum;
import com.iot.tracker.core.exception.BizException;
import com.qdigo.iotsdk.DeviceCtl;

@RequestMapping(value = "/downstream")
@RestController
public class DeviceCtlController {
	private Logger logger = LoggerFactory.getLogger(DeviceCtlController.class);
	@RequestMapping(value="/powerSwitch")
	public void powerSwitch(@RequestParam("switchCmd") String switchCmd,@RequestParam("imei") long imei){
		logger.info("发送下行命令switchCmd={},imei={}",switchCmd,imei);
		DeviceCtl deviceCtl = new DeviceCtl();
		if(PowerSwitchEnum.POWERS_WITCH_START.getClass().equals(switchCmd)){
			deviceCtl.deviceStart(imei);
		}else if(PowerSwitchEnum.POWERS_WITCH_STOP.getClass().equals(switchCmd)){
			deviceCtl.deviceFlameout(imei);
		}else{
			throw new BizException(BizEnum.DEVICE_CMD_NOT_EXIST);
		}
	}
}
