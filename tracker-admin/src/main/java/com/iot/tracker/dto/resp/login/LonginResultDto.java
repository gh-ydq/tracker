package com.iot.tracker.dto.resp.login;

import java.io.Serializable;

public class LonginResultDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2360923206430800580L;
	private String tocken;

	public String getTocken() {
		return tocken;
	}

	public void setTocken(String tocken) {
		this.tocken = tocken;
	}
	
}
