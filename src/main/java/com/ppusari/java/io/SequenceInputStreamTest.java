package com.ppusari.java.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

public class SequenceInputStreamTest {
	public static void main(String[] args) {
		byte[] array1 = {0,1,2,3,4 };
		byte[] array2 = {5,6,7,8,9 };
		byte[] array3 = {10,11,12,13,14,15,16,17,18,19 };
		byte[] outputSource = null;
		
		Vector vector = new Vector();
		vector.add(new ByteArrayInputStream(array1));
		vector.add(new ByteArrayInputStream(array2));
		vector.add(new ByteArrayInputStream(array3));
		
		SequenceInputStream inputStream = new SequenceInputStream(vector.elements());
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		int data = 0;		
		try {
			while ((data = inputStream.read()) != -1 ) {
				outputStream.write(data);
			}
		}
		catch (Exception e) {}
		 
		outputSource = outputStream.toByteArray();
		System.out.println("Array1:" + Arrays.toString(array1));
		System.out.println("Array2:" + Arrays.toString(array2));
		System.out.println("Array3:" + Arrays.toString(array3));
		System.out.println("Ouput Source: " + Arrays.toString(outputSource));
		
	}
}
