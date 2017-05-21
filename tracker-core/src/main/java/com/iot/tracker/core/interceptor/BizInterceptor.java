package com.iot.tracker.core.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.iot.tracker.core.exception.BizEnum;
import com.iot.tracker.core.exception.BizException;
import com.iot.tracker.core.util.WebJsonResult;

@Component
public class BizInterceptor implements MethodInterceptor{
	private static final Logger logger = LoggerFactory.getLogger(BizInterceptor.class);
//    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if(methodInvocation.getMethod().getAnnotation(ValidBiz.class)==null){
            return  methodInvocation.proceed();
        }
        Object result = null;
        if(!methodInvocation.getMethod().getReturnType().equals(WebJsonResult.class)) {
            logger.error("Entry BizInterceptor error,error method interceptor,class:{},method:{}",
                    methodInvocation.getMethod().getDeclaringClass().getName(),methodInvocation.getMethod().getName());
            return  methodInvocation.proceed();
        }
        try{
            result = methodInvocation.proceed();
            if(result == null || !WebJsonResult.SUCCESS.equals(((WebJsonResult<?>)result).getCode())) {
                logger.error("Entry BizException_1:arguments:{},result:{},mehtodName:{},className:{}",
                        JSON.toJSONString(methodInvocation.getArguments()),JSON.toJSONString(result),
                        JSON.toJSONString(methodInvocation.getMethod().getName()),JSON.toJSONString(methodInvocation.getMethod().getDeclaringClass().getName()));
            }
        }catch (BizException e) {
            logger.error("Entry BizException_2:arguments:{"+ JSON.toJSONString(methodInvocation.getArguments()) +"},result:{"+
                    JSON.toJSONString(result)+"},mehtodName:{"+ JSON.toJSONString(methodInvocation.getMethod().getName()) +
                    "},className:{" +JSON.toJSONString(methodInvocation.getMethod().getDeclaringClass().getName()) +"}",e);
            return  new WebJsonResult(e.getCode(),null,e.getMsg());
        }catch (Exception e) {
            logger.error("Entry Exception:arguments InterException:{"+ JSON.toJSONString(methodInvocation.getArguments()) +"},result:{"+
                    JSON.toJSONString(result)+"},mehtodName:{"+ JSON.toJSONString(methodInvocation.getMethod().getName()) +
                    "},className:{" +JSON.toJSONString(methodInvocation.getMethod().getDeclaringClass().getName()) +"}",e);
            return new WebJsonResult(BizEnum.E_SYS_ERROR.getCode(),null,BizEnum.E_SYS_ERROR.getMsg());
        }
        return result;
    }
}
