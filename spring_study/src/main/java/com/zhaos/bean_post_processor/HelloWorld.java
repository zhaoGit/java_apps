package com.zhaos.bean_post_processor;

public class HelloWorld {
	private String message;

	public HelloWorld() {
		System.out.println("Bean is going through : constructor");
	}
	
	public void setMessage(String message) {
		System.out.println("Bean is going through : setter");
		this.message = message;
	}

	public void getMessage() {
		System.out.println("Your Message : " + message);
	}

	public void init() {
		System.out.println("Bean is going through init.");
	}

	public void destroy() {
		System.out.println("Bean will destroy now.");
	}
}