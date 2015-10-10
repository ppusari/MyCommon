package com.ppusari.java.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class DataStreamTest {
	public static void main(String[] args ) {
		
		FileOutputStream fileOutputStream = null;
		DataOutputStream dataOutputStream = null;
		
		try {
			fileOutputStream = new FileOutputStream("data_test.dat");			
			dataOutputStream = new DataOutputStream(fileOutputStream);
			
			try {
				dataOutputStream.writeInt(30);
				dataOutputStream.writeBoolean(true);
				dataOutputStream.writeDouble(123.45);
				dataOutputStream.writeUTF("This is a test");
				dataOutputStream.writeLong(7777888);				
								
			} catch (IOException e) {
				e.printStackTrace();
			}			
			finally{
				try {
					dataOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			 
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		
		try {
			
			FileInputStream fileInputStream = new FileInputStream("data_test.dat");
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);

			int intValue = dataInputStream.readInt();
			boolean booleanValue = dataInputStream.readBoolean();
			double doubleValue = dataInputStream.readDouble();
			String stringValue = dataInputStream.readUTF();
			long longValue = dataInputStream.readLong();
			
			System.out.printf("int: %d boolean: %b double: %f string: %s long: %d", intValue, booleanValue, doubleValue, stringValue, longValue);
			 		
			
		} catch (Exception e) {} 
	}

}
