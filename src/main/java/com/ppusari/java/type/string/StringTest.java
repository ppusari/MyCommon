package com.ppusari.java.type.string;

public class StringTest {

	public static void main(String[] args) {
		
		base();
	}
	
	public static void base(){
		
		boolean b = false;
		
		String str = "Chobyoungkug";

		// 문자열 찾기
		b = str.startsWith("Cho");	// Cho로 시작하는가?
		b = str.endsWith("kug");	// kug로 끝나는가?
		 
		
	}
	
	
	public static void subString(){
		
		String str = "010-1234-5678";
		String ret = "";
		
		if (str.length() == 13){
			ret = str.substring(0,6) + "**-*" + str.substring(10,13);	
		}
		else if (str.length() == 12){
			ret = str.substring(0,6) + "*-*" + str.substring(9,12);
		}
		else{
			ret = "error";
		}
		
		System.out.println(ret);	 
	}
	
	public static void sFormat(){
		
		String str;
		
		for (int i=0; i<10; i++){
			str = String.format("%04d", i); 		
			System.out.println("/photos/promotion/gift" + str + ".jpg");	
		}			
	}
	
	
}
