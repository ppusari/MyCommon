package com.ppusari.java.structure.vector;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		
		base();
	}
	
	public static void base(){
		
		Vector<Object> v = new Vector<Object>();
		
		// 삽입
		v.add(5);
		v.add("조병국");
		v.add(6);
		
		// 개수
		int n = v.size();
		int c = v.capacity();
		
		// 중간 삽입
		v.add(2, "고양이");
		//v.add(8, "최아연"); // v.size() 보다 큰 곳에 삽입 불가능 
		
		// 얻기
		Object obj = v.get(0);				
		Integer.parseInt(v.get(0).toString()); //int val = (int)obj; 버전에 따라 이렇게 하면 에러난다.
		
		Object obj2 = v.lastElement(); // 마지막 객체 가져오기
		
		// 삭제
		v.remove(2);
		//v.remove(7); // 7번째에 객체가 없으므로 오류
		v.removeAllElements(); //  모두 삭제
		
		
		
		
		
	}
}
