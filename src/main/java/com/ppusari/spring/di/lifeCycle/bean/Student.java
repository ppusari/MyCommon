package com.ppusari.spring.di.lifeCycle.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// Bean 초기화 및 소멸함수 InitializingBean, DisposableBean
public class Student implements InitializingBean, DisposableBean {

	private String name;
	private int age;
		
	public Student(String name, int age) {		
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override // for DisposableBean
	public void destroy() throws Exception {
		System.out.println("destroy()");		
	}

	@Override // for InitializingBean
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");		
	}
}
