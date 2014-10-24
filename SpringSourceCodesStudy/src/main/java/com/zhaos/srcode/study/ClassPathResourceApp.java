package com.zhaos.srcode.study;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

/*
 *getResourceAsStream ()返回的是inputstream

getResource()返回:URL

Class.getResource("")     返回的是classpath的位置

Class.getResource("/")返回的是当前Class这个类所在包的路径

getClassLoader().getResource("")  返回的是classpath的位置

getClassLoader().getResource("/")  错误的!!
 
 * 
 */
class FileTest{
	public void print(){
		//  返回的是当前Class这个类所在包的路径
//		1file:/D:/java_apps/SpringSourceCodesStudy/target/classes/
        System.out.println("1"+Thread.currentThread().getContextClassLoader().getResource(""));	
		//  返回的是当前Class这个类所在包的路径
//		2file:/D:/java_apps/SpringSourceCodesStudy/target/classes/
        System.out.println("2" + FileTest.class.getClassLoader().getResource(""));
		//  返回的是当前Class这个类所在包的路径
//   	3file:/D:/java_apps/SpringSourceCodesStudy/target/classes/
        System.out.println("3" + ClassLoader.getSystemResource(""));
//     4file:/D:/java_apps/SpringSourceCodesStudy/target/classes/com/zhaos/srcode/study/
        System.out.println("4" + FileTest.class.getResource(""));// Class文件所在路径
		//  返回的是当前Class这个类所在包的路径
//		4file:/D:/java_apps/SpringSourceCodesStudy/target/classes/com/zhaos/srcode/study/SSM CNL多航节航班取消.XML
        System.out.println("4" + FileTest.class.getResource("SSM.XML"));// Class文件所在路径
		//  返回的是当前Class这个类所在包的路径
//		5file:/D:/java_apps/SpringSourceCodesStudy/target/classes/
        System.out.println("5" + FileTest.class.getResource("/")); 
//		6D:\
        System.out.println("6" + new File("/").getAbsolutePath());
//		7D:\java_apps\SpringSourceCodesStudy
        System.out.println("7" + System.getProperty("user.dir"));
        System.out.println(FileTest.class.getResource("SSM.XML").getPath());
        System.out.println(new File(FileTest.class.getResource("SSM.XML").getPath()).exists());
	}
}
public class ClassPathResourceApp {

	
	public static void main(String[] args){
		String path = "com/zhaos/srcode/study/SSM CNL多航节航班取消.XML";
		ClassPathResource classPathResource = new ClassPathResource(path);
		String string = null;
		try {
//			string = FileUtils.readFileToString(classPathResource.getFile());
			new FileTest().print();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(string);
	}
}
