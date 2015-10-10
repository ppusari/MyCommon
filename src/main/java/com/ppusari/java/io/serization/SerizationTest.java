
// 이거 뭔가 코드 에러로 실행 안됨.

package com.ppusari.java.io.serization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//ArrayList 에 모두 넣어놓고 ArrayList 만 시리얼라이제이션 하면 된다.

public class SerizationTest {
	
	public static void main(String[] args)
	{	
		try { // write
			FileOutputStream fileOutputStream = new FileOutputStream("data/userInfo.ser");
			BufferedOutputStream bufferdInputStream = new BufferedOutputStream(fileOutputStream);
			ObjectOutputStream outputStream = new ObjectOutputStream(bufferdInputStream);
			
			UserInfo userInfo1 = new UserInfo("홍길동", "1234", 30);
			UserInfo userInfo2 = new UserInfo("hHong gil dong", "4321", 25);
			
			// Vactor 보다 ArrayList를 쓰는게 졶다.
			ArrayList arrayList = new ArrayList();
			arrayList.add(userInfo1);
			arrayList.add(userInfo2); 
			
			 outputStream.writeObject(userInfo1);
			 outputStream.writeObject(userInfo2);
			 outputStream.writeObject(arrayList);
			 outputStream.close(); // 가장 최하위 객체를 close 하면 상위를 모두 닫게 함.
			 
		}catch(Exception e) {}
		
		try {
			FileInputStream fileInputStream = new FileInputStream("data/userInfo.ser");
			BufferedInputStream bufferdInputStream = new BufferedInputStream(fileInputStream);
			ObjectInputStream inputStream = new ObjectInputStream(bufferdInputStream);
			
			UserInfo userInfo1 = (UserInfo)inputStream.readObject();
			UserInfo userInfo2 = (UserInfo)inputStream.readObject();
			ArrayList arrayList = (ArrayList)inputStream.readObject();
			
			System.out.println("userinfo: " + userInfo1);
			System.out.println("userinfo: " + userInfo2);
			System.out.println("userinfo: " + arrayList);
			inputStream.close();			
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}  
	}
}


