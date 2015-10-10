package com.ppusari.java.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayTest {
	public static void main(String[] args)  { 

		test();
				
		try {
			test2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	static void test()
	{
		byte[] inputSource = {0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09};
		byte[] outputSource = null;
		
		ByteArrayInputStream inputStream = new ByteArrayInputStream(inputSource);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		int data = 0;
		while ((data = inputStream.read()) != -1) 		{
			outputStream.write(data);			
		}
		
		outputSource = outputStream.toByteArray();
		
		System.out.println("InputSource:" + Arrays.toString(inputSource));
		System.out.println("OutputSource:" + Arrays.toString(outputSource));
		
	}
	
	static void test2() throws Exception  // 여기서 throws 하면 이하 try를 묶지 않아도 된다.
	{
		byte[] inputSource = {0,1,2,3,4,5,6,7,8,9};
		byte[] outputSource = null;
		
		ByteArrayInputStream inputStream = new ByteArrayInputStream(inputSource);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("test.txt", true);
			int data = 0;
			while ((data = inputStream.read()) != -1) 	
			{
				outputStream.write(data);
				fileOutputStream.write(data);
			}				
		}catch (Exception e) {}
		finally {			
			if (fileOutputStream != null)
			{				
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		outputSource = outputStream.toByteArray();
		
		System.out.println("InputSource:" + Arrays.toString(inputSource));
		System.out.println("OutputSource:" + Arrays.toString(outputSource));
		
		////////////
		
		ByteArrayOutputStream output2Stream = new ByteArrayOutputStream(); 
 
		FileInputStream fileInputStream = new FileInputStream("test.txt");
		int data = 0;
		while ((data = fileInputStream.read()) != -1) 		{
			output2Stream.write(data);			
		}
		
		byte[] output2Source = output2Stream.toByteArray();
		System.out.println("Output2 Source:" + Arrays.toString(output2Source));
		
	}
	

}
