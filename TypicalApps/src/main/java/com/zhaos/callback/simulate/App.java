package com.zhaos.callback.simulate;

public class App {
	public static void main(String[] args)
	{
		Local local = new Local(new Remote(),"Hello");		
		local.sendMessage();
	}
}
