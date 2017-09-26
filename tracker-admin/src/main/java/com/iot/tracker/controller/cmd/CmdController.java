package com.iot.tracker.controller.cmd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qdigo.iotsdk.DeviceCtl;

@RequestMapping(value="/cmd")
@RestController
public class CmdController {
	private Logger logger = LoggerFactory.getLogger(CmdController.class);
	@RequestMapping(value="/deviceSwitch")
	public void deviceSwitch(@RequestParam("cmdType") String cmdType,@RequestParam("imei") long imei){
		logger.info("发送下行命令cmdType={},imei={}",cmdType,imei);
		DeviceCtl deviceCtl = new DeviceCtl();
		deviceCtl.deviceStart(imei);
	}
}
