package com.zhaos.intercepting_filter_pattern;

/**
 * ilter which will performs certain task prior or after execution of request 
 * by request handler.
 * 
 * @author zhaosheng
 *
 */
public interface Filter {
	public void execute(String request);
}