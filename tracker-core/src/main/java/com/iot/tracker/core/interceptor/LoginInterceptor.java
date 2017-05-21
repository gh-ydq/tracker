package com.iot.tracker.core.interceptor;
//package com.tracker.core.interceptor;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import com.alibaba.fastjson.JSONObject;
//import com.tracker.core.exception.BizEnum;
//
//
//@Component
//public class LoginInterceptor extends HandlerInterceptorAdapter {
//
//	private static Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
//
//	@Autowired
//	private UserService userService;
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		log.debug("{} ? {}", request.getRequestURI(), request.getQueryString());
//		/* 处理登陆拦截 */
//		String principal = request.getHeader(CacheKey.HEADER_TOKEN);
//		if (StringUtils.isBlank(principal)) {
//			sendError(response, BizEnum.E_SYS_NO_TOKEN);
//			return false;
//		}
//		if (StringUtils.isNotBlank(principal)) {
//			if (StringUtils.isNotBlank(RedisUtil.get(principal))) {
//				RedisUtil.expire(principal, AppCreditConstants.APP_CREDIT_REDIS_EXPIRE_TIME);
//            }
//			UserDto userDto = userService.getUserCachingByToken(principal);
//			if (userDto != null) {
//				UserContainer.setUser(userDto);
//				return true;
//			}
//		}
//		sendError(response, BizEnum.E_SYS_NOT_LOGIN);
//		return false;
//	}
//
//	private void sendError(HttpServletResponse response, BizEnum bizEnum) throws IOException {
//		WebJsonResult webJsonResult = WebJsonResult.buildErrorResult(BizEnum.E_SYS_NOT_LOGIN);
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("application/json; charset=utf-8");
//		PrintWriter pw = response.getWriter();
//		try {
//			pw.write(JSONObject.toJSONString(webJsonResult));
//		} catch (Exception e) {
//			pw.flush();
//		}
//	}
//
//}