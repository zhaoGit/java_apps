package com.zhaos.business_delegate_pattern;

/**
 * Lookup service object is responsible to get relative business implementation 
 * and provide business object access to business delegate object.
 * @author zhaosheng
 *
 */
public class BusinessLookUp {
	public BusinessService getBusinessService(String serviceType) {

		if (serviceType.equalsIgnoreCase("EJB")) {
			return new EJBService();
		} else {
			return new JMSService();
		}
	}
}