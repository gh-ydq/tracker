package com.iot.tracker.interceptor;
//package com.tracker.core.interceptor;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import net.sf.json.JSONObject;
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import com.ts.credit.common.WebJsonResult;
//import com.ts.credit.common.type.BizEnum;
//import com.ts88.appcredit.entry.dto.sign.SignKeyData;
//
//public class VerifySignInterceptor extends HandlerInterceptorAdapter {
//	private static final Logger logger = LoggerFactory.getLogger(VerifySignInterceptor.class);
//
//	
//	@Autowired
//	private SignKeyData signKeyData;
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		String token = request.getHeader("X-Token");
//		String timestamp = request.getHeader("X-Timestamp");
//		String signInfo = request.getHeader("X-SignInfo");
//		
//		String orgiStr = signKeyData.getSecurityKey() + "|" + signKeyData.getApiKey() + "|" + timestamp + "|" + signKeyData.getSecurityKey();
//        logger.debug("token:"+token+"timestamp:"+timestamp+"signInfo:"+signInfo+"signKeyData.securityKey:"
//		+ signKeyData.getSecurityKey() + "signKeyData.apiKey:" + signKeyData.getApiKey());
//		if (!DigestUtils.md5Hex(orgiStr).equalsIgnoreCase(signInfo)) {
//			sendError(response, BizEnum.E_VERIFY_SIGN_FAIL);
//			return false;
//		}
//		
//		return super.preHandle(request, response, handler);
//	}
//
//	private void sendError(HttpServletResponse response, BizEnum bizEnum) throws IOException {
//		WebJsonResult webJsonResult = WebJsonResult.buildErrorResult(bizEnum);
//		try {
//			response.setCharacterEncoding("UTF-8");
//			response.setContentType("application/json; charset=utf-8");
//			PrintWriter pw = response.getWriter();
//			pw.write(JSONObject.fromObject(webJsonResult).toString());
//			pw.flush();
//			pw.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//	}
//}
