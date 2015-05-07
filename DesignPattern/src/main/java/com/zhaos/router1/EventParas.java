package com.zhaos.router1;

public class EventParas {
	private String datePattern ;
	
	public EventParas(String datePattern) {
		this.setDatePattern(datePattern);
	}
	public String getDatePattern() {
		return datePattern;
	}
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
}
