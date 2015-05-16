package com.zhaos.refactor.ifelse4;

public class GeneratorController {
	private Availability availability;
	private SegmentFilter segmentFilter;
	
	public GeneratorController(Availability availability, SegmentFilter segmentFilter) {
		// TODO Auto-generated constructor stub
		this.availability = availability;
		this.segmentFilter = segmentFilter;
	}
	public void generate(){
		availability.acquire();
		segmentFilter.filter();
	}
}