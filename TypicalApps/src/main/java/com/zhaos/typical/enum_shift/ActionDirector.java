package com.zhaos.typical.enum_shift;

public final class ActionDirector {

	public String processString(String str, OutFeature...features){
		Action action1 = new EndAction();
		Action action2 = new WhiteSpaceAction();
		Action action3 = new LowerAction();
		String retString = action1.processString(str, features);
		retString = action2.processString(retString, features);
		return action3.processString(retString, features);
	}
}
