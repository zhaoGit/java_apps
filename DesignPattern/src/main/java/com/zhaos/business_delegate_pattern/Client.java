package com.zhaos.business_delegate_pattern;

/**
 * Presentation tier code may be JSP, servlet or UI java code
 * 
 * @author zhaosheng
 *
 */
public class Client {

	BusinessDelegate businessService;

	public Client(BusinessDelegate businessService) {
		this.businessService = businessService;
	}

	public void doTask() {
		businessService.doTask();
	}
}