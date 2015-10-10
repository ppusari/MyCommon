package com.ppusari.java.io.serization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
class UserInfo extends SuperUserinfo implements Serializable { // Serializable 을 선언한 곳 부터 직렬화가 됨.
	String name;
	String password;
	int age;
	transient Object object = new Object(); // 직렬화 안한다고 명시하는 것  transient.
	Object object2 = new String("ABC");	 // Object 는 직렬화가 안되지만 String은 직렬화가 됨.
	
	public UserInfo(String name, String password, int age) {
		super(1); // 이놈은 직렬화가 안되고 있는 놈이다 그래서 아래 writeObject(), readObject() 을 사용해서 해결가능하다.
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	public UserInfo(){  this("Unknow", "1111", 0); }
	public String toString() { return "name:" + name + "password:" + password + "age:" + age; };
	
	private void writeObject(ObjectOutputStream outputStream) {
		try {
			outputStream.writeInt(id);  // 직렬화가 안된 놈을 되게 해주는 것.
			outputStream.defaultWriteObject();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	private void readObject(ObjectInputStream inputStream) {
		
		try {
			id = inputStream.readInt();
			try {
				inputStream.defaultReadObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}