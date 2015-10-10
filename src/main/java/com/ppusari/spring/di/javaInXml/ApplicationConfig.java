package com.ppusari.spring.di.javaInXml;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ppusari.spring.di.student.Student;

@Configuration
public class ApplicationConfig {

	@Bean
	public Student student1(){
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("장기");
		hobbys.add("고양이와 놀기");
		
		Student student = new Student("조병국", 35, hobbys);
		student.setHeight(174);
		student.setWeight(72);
		
		return student;		
	}
	
	@Bean
	public Student student2(){
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("걷기");
		hobbys.add("물고기 잡기");
		
		Student student = new Student("고양이", 3, hobbys);
		student.setHeight(14);
		student.setWeight(3);
				
		return student;	
		
	}
}
