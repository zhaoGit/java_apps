package com.zhaos.typical.enum_shift;


public abstract class AbstractAction implements Action{
	protected final int defaultFeature = 0 | OutFeature.LFCF.getMask() ;
	protected int features = 0;
	protected  AbstractAction() {
		features = defaultFeature;
	}
	protected int config(OutFeature feature, boolean state) {
		if(state){
			features |= feature.getMask();
		} else {
			features &= ~feature.getMask();
		}
		return features;
	}
}
