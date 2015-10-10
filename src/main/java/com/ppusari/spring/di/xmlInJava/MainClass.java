package com.ppusari.spring.di.xmlInJava;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ppusari.spring.di.student.Student;

public class MainClass {

	public static void main(String[] args) {
		
		// xml이 아닌 java로 만든 bean 객체를 로드하는 방법
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("이름: " + student1.getName());
		System.out.println("나이: " + student1.getAge());
		System.out.println("취미: " + student1.getHobbys());
		System.out.println("신장: " + student1.getHeight());
		System.out.println("몸무게: " + student1.getWeight());
		
		Student student3 = ctx.getBean("student4", Student.class);
		System.out.println("이름: " + student3.getName());
		System.out.println("나이: " + student3.getAge());
		System.out.println("취미: " + student3.getHobbys());
		System.out.println("신장: " + student3.getHeight());
		System.out.println("몸무게: " + student3.getWeight());
		
		ctx.close();
	}
}
