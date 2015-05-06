package com.zhaos.builder;
/**
 * 常用的Build
 */
import com.zhaos.strEqual.Designator;

public class DesignatorBuilder {
	private Designator data;
	
	public static DesignatorBuilder startBuilder(){
		return new DesignatorBuilder();
	}
	
	private DesignatorBuilder(){
		this.data = new Designator();
	}
	
	public DesignatorBuilder withAirline(String airline){
		this.data.setAirline(airline);
		return this;
	}
	
	public DesignatorBuilder withNumber(String number){
		this.data.setNumber(number);
		return this;
	}
	
	public DesignatorBuilder withSuffix(String suffix){
		this.data.setSuffix(suffix);
		return this;
	}
	
	public Designator build(){
		return this.data;
	}
}
