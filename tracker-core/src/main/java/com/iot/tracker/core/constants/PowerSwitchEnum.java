package com.iot.tracker.core.constants;

public enum PowerSwitchEnum {
	POWERS_WITCH_START("1","设备点火"),
	POWERS_WITCH_STOP("0","设备熄火"),
	;
	private String cmd;
	private String dec;
	
	private PowerSwitchEnum(String cmd,String dec){
		this.cmd = cmd;
		this.dec = dec;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}
	
	
}
