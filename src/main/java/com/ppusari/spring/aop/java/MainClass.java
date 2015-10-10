package com.ppusari.spring.aop.java;
 
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		// error at ::0 can't find referenced 에러가 난다면 
		// aspectjweaver, aspectjrt 버전이 1.7.0 이상이여야함    
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/ppusari/spring/aop/java/applicationCTX.xml");
		
		Student student = ctx.getBean("student", Student.class);
		student.getStudentInfo();
		
		Worker worker = ctx.getBean("worker",Worker.class);
		worker.getWorkerInfo();
		
		ctx.close();
	}
}
