package com.ppusari.spring.di.student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
	
		// 두 가지 xml파일을 한번에 로딩하기
		String configLocation1 = "classpath:com/ppusari/spring/di/student/applicationCTX.xml";
		String configLocation2 = "classpath:com/ppusari/spring/di/student/applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation1, configLocation2);
	 		
		// 객체1번
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		
		// 객체2번
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		System.out.println(student2.getName());
		System.out.println(student2.getHobbys());
		
		// 객체비교
		if (student1.equals(student2)){
			System.out.println("student1 == student2");
		}
		
		// 객체 3번
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println(student3.getName());
		System.out.println(student2.getHobbys());
		
		// 객체 비교
		if(student1.equals(student3)){
			System.out.println("student1 == student3");			
		} else {
			System.out.println("student1 != student3");
		}
		
		// 객체 4번
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
 
		ctx.close();
	}
}
