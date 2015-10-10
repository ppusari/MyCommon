package com.ppusari.spring.di.bmiCalculator;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
	
		// 
		String configLocation = "classpath:com/ppusari/spring/di/bmiCalculator/applicationCTX.xml";  // 스프링 컨테이너 생성
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation); // 스프링 컨테이너에서 컴포넌트 가져옴
		
		// xml에서 생성된 객체를 가져온다.
		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);
		myInfo.getInfo();

		MyInfo myInfo2 = ctx.getBean("myInfo2", MyInfo.class);
		myInfo2.getInfo();
				
		ctx.close();		
	}
}
