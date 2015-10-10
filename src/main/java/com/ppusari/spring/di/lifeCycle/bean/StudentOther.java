package com.ppusari.spring.di.lifeCycle.bean;

import javax.annotation.*;

public class StudentOther {

	private String name;
	private int age;
	
	public StudentOther(String name, int age) {
		super();
		this.name = name;
		this.age = age;	
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	
	@PostConstruct // 이부분이 적용이 안되고 있다.
	public void initMethod(){
		System.out.println("initMethod()");		// 출력안됨
	}
	
	@PreDestroy // 이부분이 적용이 안되고 있다.
	public void destroyMethod(){
		System.out.println("destoryMethod()"); // 출력안됨
	}
	
}
