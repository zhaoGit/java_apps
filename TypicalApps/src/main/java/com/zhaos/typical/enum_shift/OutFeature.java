package com.zhaos.typical.enum_shift;

public enum OutFeature {
	AllLower,//全部小写 (000001)
	LFCF,//回车(000010)
	EndWithDot,//以点号结尾(000100)
	BeginWithWhiteSpace,//以空格开始(0010000)
	RemoveWhiteSpace,//(0100000)
	RemoveNumber;//(100000)
	
	private final int mask;
	private OutFeature(){
		mask = 1 << ordinal();
	}
	
	public int getMask(){
		return mask;
	}
	
	public static int config(int features , OutFeature feature, boolean state){
		if(state){
			features |= feature.getMask();
		} else {
			features &= ~feature.getMask();
		}
		
		return features;
	}
	
	public static boolean isEnable(int features, OutFeature feature){
		return (features & feature.getMask())!= 0;
	}
}
