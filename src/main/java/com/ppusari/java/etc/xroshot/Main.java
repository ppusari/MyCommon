package com.ppusari.java.etc.xroshot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ppusari.java.etc.xroshot.xroshot.Xcroshot;
 

public class Main {
	public static void main(String[] args) {
			
		Xcroshot xcroshot = new Xcroshot();
		
		ArrayList<String> receivers = new ArrayList<String>();
		receivers.add("01026270559");		
		xcroshot.send("01026270559", receivers, "sms테스트 합니다.");
		
		try {		
			String line = null;
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			while ((line = keyboard.readLine()) != null) {
				
				if (line.equals("login") || line.equals("l")){
					xcroshot.logIn();					
				}
				else if (line.equals("send") || line.equals("s")){
					xcroshot.send("01026270559", receivers, "sms테스트");
				} 
				else if (line.equals("logout") || line.equals("o")){
					xcroshot.logOut();
				}
				else if (line.equals("exit") || line.equals("x")){
					xcroshot.logOut();
					break;				
				}					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("exit");
	}

}
