package com.zhaos.intercepting_filter_pattern;

/**
 * Filter Manager manages the filters and Filter Chain.
 * 
 * @author zhaosheng
 *
 */
public class FilterManager {
	FilterChain filterChain;

	public FilterManager(Target target) {
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}

	public void setFilter(Filter filter) {
		filterChain.addFilter(filter);
	}

	public void filterRequest(String request) {
		filterChain.execute(request);
	}
}