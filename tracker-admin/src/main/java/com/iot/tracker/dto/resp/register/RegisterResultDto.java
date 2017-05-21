package com.iot.tracker.dto.resp.register;

import java.io.Serializable;

public class RegisterResultDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6995958006922615157L;
	private String tocken;
	public String getTocken() {
		return tocken;
	}
	public void setTocken(String tocken) {
		this.tocken = tocken;
	}
	
	
}
