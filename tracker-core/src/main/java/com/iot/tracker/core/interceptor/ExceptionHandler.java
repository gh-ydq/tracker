package com.iot.tracker.core.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.JSON;
import com.iot.tracker.core.exception.BizEnum;
import com.iot.tracker.core.util.WebJsonResult;

public class ExceptionHandler extends SimpleMappingExceptionResolver {
	private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@Override
	protected void prepareResponse(Exception ex, HttpServletResponse response) {
		logger.error("ExceptionHandler catch_exception " + ex.getMessage(), ex);
		response.setContentType("application/json;charset=UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			String errorJson = buildErrorJSON(ex);
			writer.write(errorJson);
			writer.flush();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private String buildErrorJSON(Exception ex) {

		return JSON.toJSONString(WebJsonResult.buildErrorResult(BizEnum.E_SYS_HANLER_ERROR));
	}

}
