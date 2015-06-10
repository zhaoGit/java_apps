package com.zhaos.business_delegate_pattern;
/**
 * A single entry point class for client entities to provide access to Business 
 * Service methods.
 * @author zhaosheng
 *
 */
public class BusinessDelegate {
	private BusinessLookUp lookupService = new BusinessLookUp();
	private BusinessService businessService;
	private String serviceType;

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void doTask() {
		businessService = lookupService.getBusinessService(serviceType);
		businessService.doProcessing();
	}
}