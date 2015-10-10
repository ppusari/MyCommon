package com.ppusari.spring.di.javaInXml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ppusari.spring.di.student.Student;

public class MainClass {

	public static void main(String[] args) {
		
		// xml울 가져오는데 그 xml안에  java로 만든 bean 객체가 포함되어있다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/ppusari/spring/di/javaInXml/applicationCTX.xml");
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("이름: " + student1.getName());
		System.out.println("나이: " + student1.getAge());
		System.out.println("취미: " + student1.getHobbys());
		System.out.println("신장: " + student1.getHeight());
		System.out.println("몸무게: " + student1.getWeight());
		
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println("이름: " + student3.getName());
		System.out.println("나이: " + student3.getAge());
		System.out.println("취미: " + student3.getHobbys());
		System.out.println("신장: " + student3.getHeight());
		System.out.println("몸무게: " + student3.getWeight());
		
		ctx.close();
	}
} 