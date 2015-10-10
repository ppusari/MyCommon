package com.ppusari.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	public static void main(String[] args) {
		
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("reader_writer_test.txt");
			try {
				fileOutputStream.write('A');
				fileOutputStream.write('B');
				fileOutputStream.write('C');
				fileOutputStream.close();				
			} catch (IOException e) {
				e.printStackTrace();
			}

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			FileWriter fielWriter = new FileWriter("reader_writer_text2.txt", true);
			fielWriter.write('a');
			fielWriter.write('b');
			fielWriter.write('b');
			fielWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try
		{
			FileInputStream fileInputStrem = new FileInputStream("reader_writer_text2.txt");
			 
			int data = 0;		
			while ((data = fileInputStrem.read()) != -1) {
				System.out.print((char)data);				
			}
			fileInputStrem.close();			
		}
		catch (Exception e) {}
		
		
		try
		{
			FileReader fileReader = new FileReader("reader_writer_text2.txt");
			
			int data = 0;		
			while ((data = fileReader.read()) != -1) {
				System.out.print((char)data);				
			}
			fileReader.close();	
		}
		catch (Exception e) {}
		

	
		
	}

}
