package com.ppusari.spring.di.property.fromExternFile;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:com/ppusari/spring/di/property/fromExternFile/admin.properties"));			
			System.out.println(env.getProperty("admin.id"));
			System.out.println(env.getProperty("admin.pw"));			
			
		} catch (IOException e) {
			e.printStackTrace();
		}	

		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		gCtx.load("com/ppusari/spring/di/property/fromExternFile/applicationCTX.xml");
		gCtx.refresh();
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID: " + adminConnection.getAdminId());
		System.out.println("admin PW: " + adminConnection.getAdminPw());
		
		gCtx.close();
		ctx.close();		
	}
}