package com.ppusari.spring.di.property.direct.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/ppusari/spring/di/property/direct/xml/applicationCTX.xml");
		
		AdminConnection connection = ctx.getBean("adminConnection", AdminConnection.class);
		System.out.println("adminID: " + connection.getAdminId());
		System.out.println("adminPW: " + connection.getAdminPw());
		System.out.println("sub_adminID: " + connection.getSub_adminId());
		System.out.println("sub_adminPW: " + connection.getSub_adminPw());
		
		ctx.close();
	}
}
