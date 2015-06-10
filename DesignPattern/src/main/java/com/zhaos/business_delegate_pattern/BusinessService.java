package com.zhaos.business_delegate_pattern;

/**
 * Business Service interface. Concrete classes implement this business service 
 * to provide actual business implementation logic
 * 
 * @author zhaosheng
 *
 */
public interface BusinessService {
	public void doProcessing();
}