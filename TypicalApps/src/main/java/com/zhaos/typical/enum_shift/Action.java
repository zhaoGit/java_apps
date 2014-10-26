package com.zhaos.typical.enum_shift;

public interface Action {
	String processString(String str);
	String processString(String str, OutFeature...features);
}
