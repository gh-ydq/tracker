
package com.iot.tracker.service;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.tracker.core.constants.CacheKey;
import com.iot.tracker.core.dto.UserDto;
import com.iot.tracker.core.util.RedisUtil;
import com.iot.tracker.interceptor.ValidBiz;


@Service
public class UserService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private RedisUtil redisUtil;

	@ValidBiz
	public UserDto getUserCachingByToken(String token) {
		UserDto userDto = new UserDto();
		try {
			userDto = redisUtil.getObjByJsonValue( CacheKey.TOKEN_CACHE_USER + token,UserDto.class);
			if (userDto != null) {
				return (UserDto) userDto;
			}
		} catch (Exception e) {
			log.error("登录获取token异常:", e);
		} 
		return null;

	}
	

	public String getUserCachingByToken(HttpServletRequest request) {
		String principal = request.getHeader(CacheKey.HEADER_TOKEN);
		if (principal != null && !principal.isEmpty()) {
			UserDto userDto = getUserCachingByToken(principal);
			return userDto.getUserCode();
		}
		return null;
	}

	
}
