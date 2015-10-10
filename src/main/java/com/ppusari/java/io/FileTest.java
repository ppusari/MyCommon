package com.ppusari.java.io;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileTest {
	public static void main(String[] args ) {
		
	//	File file = new File("test.txt"); // 파일을 생성하는게 아니고 파일을 접근하는 인스던트만 생성시킴. (
		File file = new File(".");
		
		if (file.exists()) {
			System.out.println("파일이 존재합니다.");
		}
		else {
			System.out.println("파일이 존재 하지 않습니다.");			
		}
		
		if (file.isDirectory()) {
			System.out.println("디렉토리 입니다..");
		}
		else {
			System.out.println("디렉토리 가 아닙니다.");
		}
		
		// 절대적인 경로얻기.
		System.out.println(file.getAbsolutePath());
		
		// 파일리스트 불러오기.
		File[] files = file.listFiles();		
		for (File obj : files) {
			String fileName = obj.getName();
			SimpleDateFormat dataForamt = new SimpleDateFormat("yyyy-MM-dd HH:mma");
						
			String attribute = "";
			String size = "";
			if (!obj.isDirectory())
			{
				size = String.valueOf(obj.length());
				attribute = file.canRead() ? "R" : "";
				attribute += file.canWrite() ? "W" : "";
				attribute += file.isHidden() ? "H" : "";
			}
			
			System.out.println( (obj.isDirectory() ? "[" + fileName + "]" : fileName));						
			
		}
		
		
			
		
		
		
	}

}
