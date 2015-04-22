package com.zhaos.communication;

/*
 * 多个线程共享的数据--资源类
 */
class Resource {
	private String name;
	private String gender;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}

/*
 * ���̸߳���д����
 */
class Input implements Runnable {

	private Resource resource;//������Դ������ã����ڶ���Դ���в�����

	public Input(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		int flag = 0;
		while (true) {
			synchronized (Input.class) {
				if (flag == 0) {
					resource.setGender("male");
					resource.setName("John");
				} else {
					resource.setGender("ŮŮŮŮŮŮ");
					resource.setName("����");
				}
				
				flag = (flag + 1) % 2;//����д����
			}
		}
	}

}

/*
 * ���̸߳��������
 */
class Output implements Runnable{

	private Resource resource;
	
	public Output(Resource resource) {
		super();
		this.resource = resource;
	}

	@Override
	public void run() {
		while(true){
			synchronized (Input.class) {
				System.out.println(resource.getName() + "....." + resource.getGender());
				
			}
		}
	}
	
}

public class ThreadCommunications {

	public static void main(String[] args){
		Resource resource = new Resource();
		Thread thread1 = new Thread(new Input(resource ));
		Thread thread2 = new Thread(new Output(resource ));
		
		thread1.start();
		thread2.start();
	}
}
