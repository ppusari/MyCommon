package com.ppusari.java.io;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedStreamTest {
	public static void main(String[] args){
		
		FileOutputStream fileOutputStream = null;
		try {
			
			// 기반 스트림
			fileOutputStream = new FileOutputStream("buffer_test.txt");
			
			// 보조 스트림 ( 반드시 기반 스트림이 존재해야함 )
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 5);
			
			for (int i=0 ; i< 9; i++) {
				bufferedOutputStream.write('1' + i);
			}
			
			// 기반 스트림으로 닫으려면 
			bufferedOutputStream.flush();  // 플러쉬 안하면 데이터가 저장이 모두 안된다.
			fileOutputStream.close();
			
			//bufferedOutputStream.close();
			
			
		}
		catch (Exception e) {}
		
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("buffer_test.txt");
			
			int data = 0;
			
			while((data = fileInputStream.read()) != -1)
			{
				System.out.print((char)data);			
			}
			System.out.println();
			fileInputStream.close();
			
		}catch (Exception e){}
		
		
	}

}
