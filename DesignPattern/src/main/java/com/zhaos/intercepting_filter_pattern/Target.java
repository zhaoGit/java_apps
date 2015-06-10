package com.zhaos.intercepting_filter_pattern;

/**
 * Target object is the request handler
 * @author zhaosheng
 *
 */
public class Target {
	public void execute(String request) {
		System.out.println("Executing request: " + request);
	}
}