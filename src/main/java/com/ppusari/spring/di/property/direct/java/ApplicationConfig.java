package com.ppusari.spring.di.property.direct.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.ppusari.spring.di.property.direct.xml.AdminConnection;

 
@Configuration
public class ApplicationConfig {
	
	// value 에노테이션을 사용하면 set을 한 의미가 되니 adminConfig에서 바로 사용할 수 있다.
	@Value("${admin.id}")
	private String adminId;
	
	@Value("${admin.pw}")
	private String adminPw;
	
	@Value("${sub_admin.id}")
	private String sub_adminId;
	
	@Value("${sub_admin.pw}")
	private String sub_adminPw;
	
	
	// XML 로 치면 <context:property-placeholder location="classpath:admin.properties, classpath:sub_admin.properties" /> 을 의미함
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties(){
		
		PropertySourcesPlaceholderConfigurer configurer =new PropertySourcesPlaceholderConfigurer();
		
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("com/ppusari/spring/di/property/direct/java/admin.properties");
		locations[1] = new ClassPathResource("com/ppusari/spring/di/property/direct/java/sub_admin.properties");
		configurer.setLocations(locations);
		
		return configurer;
	}
	
	@Bean
	public AdminConnection adminConfig(){
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSub_adminId(sub_adminId);
		adminConnection.setSub_adminPw(sub_adminPw);
		return adminConnection;		
	}
}
