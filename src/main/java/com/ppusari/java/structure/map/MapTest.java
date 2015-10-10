package com.ppusari.java.structure.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
	
	public static void main(String[] args) {
		
		base();
	}
	
	public static void base(){
		
		Map<String, String> map = new HashMap<String, String>();
        
		map.put("키1", "값1");
		map.put("키2", "값2");
		map.put("키3", "값3");
		map.put("키4", "값4");
		map.put("키5", "값5");
		map.put("키6", "값6");
        
		// 방법1
		System.out.println("방법1");
		Iterator<String> keys = map.keySet().iterator();
		while( keys.hasNext() ){
			String key = keys.next();
			System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );
		}
        
		// 방법2
		System.out.println("방법2");
		for( Map.Entry<String, String> elem : map.entrySet() ){
           System.out.println( String.format("키 : %s, 값 : %s", elem.getKey(), elem.getValue()) );
		}
        
		// 방법3
		System.out.println("방법3");
		for( String key : map.keySet() ){
			System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );
		}
	}

}
