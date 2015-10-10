package com.ppusari.spring.di.property.profile.xml;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		String config = null;
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		System.out.println("dev or run");
		
		if (str.equals("dev")){
			config = "dev";			
		}
		else if ( str.equals("run")) {
			config = "run";
		}
		
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("com/ppusari/spring/di/property/profile/xml/applicationCTX_dev.xml", "com/ppusari/spring/di/property/profile/xml/applicationCTX_run.xml");
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip: " + info.getIpNum());
		System.out.println("port: " + info.getPortNum());
		ctx.close();		
	}
}
