package com.zhaos.singleton;
/*       饿汉式
 * class Singleton{
 * 		private static final Singleton singleton = new Singleton();
 *  	private Singleton(){}
 *  
 * 		public static Singleton getInstance(){
 *  		return singleton;
 * 		}
 * }
 */

public class Singleton {

	private static Singleton singleton = null;
	private Singleton(){}
	
	public static Singleton getInstance(){

		if(singleton == null){
			synchronized(Singleton.class){
				if(singleton == null){
					return new Singleton();
				}
			}
		}
		
		return singleton;
	}
}
