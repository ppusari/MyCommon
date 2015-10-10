package com.ppusari.spring.di.lifeCycle.bean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ctx.load("classpath:com/ppusari/spring/di/lifeCycle/bean/applicationCTX.xml");
		ctx.refresh();
		
		ctx.close();
	}
}
