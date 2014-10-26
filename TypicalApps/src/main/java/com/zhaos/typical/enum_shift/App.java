package com.zhaos.typical.enum_shift;

public class App {

	public static void main(String[] args) {
		ActionDirector actionDirector = new ActionDirector();
		String result = actionDirector.processString("a BF df",
				OutFeature.AllLower, OutFeature.RemoveWhiteSpace,
				OutFeature.EndWithDot);
		System.out.println(result);
	}
}
