package com.zhaos.business_delegate_pattern;

/**
 * Business Delegate Pattern is used to decouple presentation tier 
 * and business tier. It is basically use to reduce communication or 
 * remote lookup functionality to business tier code in presentation 
 * tier code. In business tier we have following entities.
 * @author zhaosheng
 *
 */
public class App {

	public static void main(String[] args) {

		BusinessDelegate businessDelegate = new BusinessDelegate();
		businessDelegate.setServiceType("EJB");

		Client client = new Client(businessDelegate);
		client.doTask();

		businessDelegate.setServiceType("JMS");
		client.doTask();
	}
}