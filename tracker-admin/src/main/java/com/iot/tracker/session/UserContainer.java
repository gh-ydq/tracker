package com.iot.tracker.session;

import com.iot.tracker.core.dto.UserDto;

/**
 * Created by panxing on 2016/9/28.
 */
public class UserContainer {

    private static final ThreadLocal<UserDto> container = new ThreadLocal<UserDto>();


    public static void setUser(UserDto userDto) {
        container.set(userDto);
    }

    public static UserDto getUser() {
        return container.get();
    }
    
    
    public static String getUserPhoneNo() {
    	if(container.get()==null){
    		return null;
    	}else{
    		 return container.get().getPhoneNo();
    	}
    }

    public static String getUserCode() {
        return container.get().getUserCode();
    }

}
