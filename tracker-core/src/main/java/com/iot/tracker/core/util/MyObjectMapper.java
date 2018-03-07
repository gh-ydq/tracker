package com.iot.tracker.core.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * TODO
 *
 * @author yudengqiu
 * @time  2017-5-19
 */
public class MyObjectMapper extends ObjectMapper {  
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5866186447464813128L;

	public MyObjectMapper(){  
        //目标类中找不到json字符串中属性时直接忽略  
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  
    }  

}


