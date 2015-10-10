package com.ppusari.spring.di.lifeCycle.container;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ppusari.spring.di.student.Student;

public class MainClass {

	public static void main(String[] args) {
		
		// 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		// 설정
		ctx.load("classpath:com/ppusari/spring/di/lifeCycle/container/applicationCTX.xml");
		ctx.refresh(); // load() 함수를 이용할 때는 refresh() 를 꼭 호출해야 한다.
		
		// 사용
		Student student = ctx.getBean("student1", Student.class);
		System.out.println("이름: " + student.getName());
		System.out.println("나이: " + student.getAge());
		
		// 소멸
		ctx.close();		
	}
}
