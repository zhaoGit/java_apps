package com.zhaos.typical.enum_shift;

public class LowerAction extends AbstractAction{

	@Override
	public String processString(String str) {
		return str;
	}

	@Override
	public String processString(String str, OutFeature... features) {
		for(OutFeature feature : features){
			config(feature, true);
		}
		if(OutFeature.isEnable(super.features, OutFeature.AllLower)){
			return str.toLowerCase();
		}
		return str;
	}

}
