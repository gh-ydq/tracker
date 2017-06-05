package com.iot.tracker.controller.upstream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iot.tracker.dto.upstream.pg.PGPacketDto;

@RequestMapping(value = "/upstream")
@RestController
public class PGController {
	private Logger logger = LoggerFactory.getLogger(PGController.class);
	
	@RequestMapping(value = "/pg")
	@ResponseBody
	public void savePGMsg(@RequestBody PGPacketDto pgPacketDto){
		logger.info("PG包请求参数{}",pgPacketDto.toString());
	}
	
}
