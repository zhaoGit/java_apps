package com.zhaos.file.io.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileUtil{
	public static String readFromFile(String path){
		String retString = null;
		File file = new File(path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			return readFileToString(bufferedReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (null != fileReader) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != bufferedReader){
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return retString;
		
	}
	
	private static String readFileToString(BufferedReader bufferedReader) throws IOException{
		StringBuilder sb = new StringBuilder();
		do {
			String data = bufferedReader.readLine();
			if(data != null){
				sb.append(data);
			} else {
				break;
			}
		} while (true);
		return sb.toString();
	}
}

public class App {
	public static void main(String[] args){
		String path = "D:/java_apps/TypicalApps/src/main/java/com/zhaos/file/io/demo/test.txt";
		System.out.println(FileUtil.readFromFile(path));
	}
}
