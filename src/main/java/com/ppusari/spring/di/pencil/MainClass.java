package com.ppusari.spring.di.pencil;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] agrs){
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("com/ppusari/spring/di/pencil/applicationCTX.xml");
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
		pencil.use();
		ctx.close();
	}
}
