package com.zhaos.intercepting_filter_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter Chain carries multiple filters and help to execute them 
 * in defined order on target.
 * 
 * @author zhaosheng
 *
 */
public class FilterChain {
	private List<Filter> filters = new ArrayList<Filter>();
	private Target target;

	public void addFilter(Filter filter) {
		filters.add(filter);
	}

	public void execute(String request) {
		for (Filter filter : filters) {
			filter.execute(request);
		}
		target.execute(request);
	}

	public void setTarget(Target target) {
		this.target = target;
	}
}