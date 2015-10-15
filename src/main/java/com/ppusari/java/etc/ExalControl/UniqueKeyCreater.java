package com.ppusari.java.etc.ExalControl;

import java.util.ArrayList;

public class UniqueKeyCreater {
	 
	private ArrayList<String> uniqueKeys;
	
	public UniqueKeyCreater(){
		uniqueKeys = new ArrayList<String>();
	}
 
	public void getUniqueKeys(int count){ 		
		for (int i=0; i<count; i++){
			String key = createUniqueKey();
			if (!isOverlap(key))
				uniqueKeys.add(key);
			else
				i--;			
		}		
		
		System.out.println(uniqueKeys.size());
	}
	


	// 난수코드 생성기
	private String createUniqueKey() {
		
		String[] worldList = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9"};
		int length = worldList.length;		
		String uniqueKey = "";
		
		for (int i=0; i<4; i++){
			int rand = (int)(Math.random() * length);
			uniqueKey += worldList[rand];			
		}		
		
		return uniqueKey;
	}
	
	// 난수코드 중복체크
	private boolean isOverlap(String str){
		
		for (int i=0; i<uniqueKeys.size(); i++){
			if (uniqueKeys.get(i).equals(str)){
				System.out.println("중복됨" + i);
				return true;
			}
		}
		
		return false;		
	}
	
	
	public ArrayList<String> getUniqueKeys() {
		return uniqueKeys;
	}
	
	public void print(){		
		for (int i=0; i<uniqueKeys.size(); i++){
			System.out.println(uniqueKeys.get(i));
		}		
	}
	
	
}
