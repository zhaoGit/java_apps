package com.zhaos.strEqual;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;

import com.zhaos.util.RctAssert;

public class Designator {
	private String airline;
	private String number;
	private String suffix;
	
	public Designator(){
		//Do nothing for now
	}
	
	public Designator(String designatorStr){
		//Assert for debug mode
		RctAssert.notEmpty(designatorStr, "The flight designator string is empty");
		String regexp = "[A-Z]{2}[0-9]{1,6}[A-Z]?";
		RctAssert.isTrue(designatorStr.matches(regexp), "The flight designator string is not valid format");
		
		airline = designatorStr.substring(0, 2);
		if(Character.isLetter(designatorStr.charAt(designatorStr.length() - 1))){
			number = designatorStr.substring(2, designatorStr.length() - 1);
			suffix = designatorStr.substring(designatorStr.length() - 1);
		} else {
			number = designatorStr.substring(2);
		}
	}
	
	public String getDesignatorStr(){
		StringBuilder sb = new StringBuilder();
		if(!StringUtils.isEmpty(airline)){
			sb.append(airline);
		}
		if(!StringUtils.isEmpty(number)){
			sb.append(number);
		}
		if(!StringUtils.isEmpty(suffix)){
			sb.append(suffix);
		}
		return sb.toString();
	}
	
	public Designator(String airline, String number, String suffix){
		this.airline = airline;
		this.number = number;
		this.suffix = suffix;
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
