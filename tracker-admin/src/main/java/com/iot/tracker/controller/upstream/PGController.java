package com.iot.tracker.controller.upstream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot.tracker.dto.upstream.pg.PGPacketDto;
import com.iot.tracker.service.PGService;

@RequestMapping(value = "/upstream")
@RestController
public class PGController {
	private Logger logger = LoggerFactory.getLogger(PGController.class);
	
	@Autowired
	private PGService pgService;
	
	@RequestMapping(value = "/pg")
	@ResponseBody
	public void savePGMsg(@RequestBody PGPacketDto pgPacketDto){
		logger.info("PG包请求参数{}",pgPacketDto.toString());
		pgService.savePGMsg(pgPacketDto);
		pgService.updateUserDeviceLatLgt(pgPacketDto);
	}
	
	public static void main(String[] args) {
		PGPacketDto pg = new PGPacketDto();
		pg.setImei(234567);
		pg.setLat(12345678.67f);
		pg.setLng(45674567.7f);
		ObjectMapper obj = new ObjectMapper();
		String aa = "";
		try {
			aa = obj.writeValueAsString(pg);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------------"+aa);
		
	}
	
}
