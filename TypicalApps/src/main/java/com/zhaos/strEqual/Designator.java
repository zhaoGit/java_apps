package com.zhaos.strEqual;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Designator {
	private String airline;
	private String number;
	private String suffix;
	
	public Designator(){
		//Do nothing for now
	}
	
	public Designator(String flightCode){
//		RctAssert.notEmpty(flightCode, "The flight designator string is empty");
		
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airline == null) ? 0 : airline.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass() != getClass()){
			return false;
		}
		
		Designator designator = (Designator) obj;
		
		return new EqualsBuilder()
		.append(airline, designator.airline)
		.append(number, designator.number)
		.append(suffix, designator.suffix)
		.isEquals();
	}	
}
