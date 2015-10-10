package com.ppusari.java.structure.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 

public class ListTest {
	
	public static void main(String[] args) {
		
		base(); 
		sort();			// list 속 데이터 정렬
		objectUsing(); 	// 리스트에 객체 넣어서 사용하기
	}
	
	public static void base(){
		
		// 오브젝트로 선언했기 때문에 숫자, 문자, 객체 아무거나 받을 수 있다.
		List<Object> arrayList = new ArrayList<Object>();
		arrayList.add(123);
		arrayList.add(3.141592);
		arrayList.add("조병국");
		
		for (Object object : arrayList) {
			System.out.println(object.toString());
		}		
	}
	
	// 정렬
	public static void sort(){		

		// 정수만 받도록 제한 하는 방법 <Integer> 을 넣으면 됨.
		ArrayList<Integer> al = new ArrayList<Integer>();		
		al.add(new Integer(5));
		al.add(new Integer(3));
		al.add(new Integer(7));
		al.add(new Integer(1));
		//al.add(new String("aa")); 에러발생 Integer가 아니기 때문에.
		
		System.out.println("정렬 전: " + al.toString());
		 
		// 정렬하는 방법. ( 숫자만 들어있기 대문에 가능 )
		Collections.sort(al);

		System.out.println("정렬 후: " + al.toString());
		
	}

	// 리스트에 객체 넣기
	public static void objectUsing(){
		
		ArrayList<Item> arrayList = new ArrayList<Item>();		
		arrayList.add(new Item("조병국", 34));
		arrayList.add(new Item("최아연", 32));
		arrayList.add(new Item("고양이", 5));
				
		for (Item item : arrayList)
			System.out.println(item.toString());		
	}

	
	
	

}
