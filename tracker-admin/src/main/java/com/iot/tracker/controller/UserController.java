package com.iot.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.tracker.core.util.WebJsonResult;
import com.iot.tracker.dto.req.login.LoginReqParamDto;
import com.iot.tracker.dto.req.register.RegisterReqParamDto;
import com.iot.tracker.dto.resp.login.LonginResultDto;
import com.iot.tracker.dto.resp.register.RegisterResultDto;
import com.iot.tracker.service.UserInfoControllerService;

@Controller  
@RequestMapping("/user")  
public class UserController {  
	@Autowired
	private UserInfoControllerService userInfoService;
	
	@RequestMapping(value = "/register")
	@ResponseBody
	public WebJsonResult<RegisterResultDto> register(@RequestBody RegisterReqParamDto registerParamDto){
		return userInfoService.register(registerParamDto);
	}
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public WebJsonResult<LonginResultDto> login(@RequestBody LoginReqParamDto loginReqParamDto){
		return userInfoService.login(loginReqParamDto);
	}
    
}