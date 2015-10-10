package com.ppusari.spring.di.property.profile.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ppusari.spring.di.property.profile.xml.ServerInfo;

 
 @Configuration
@Profile("run")
public class ApplicationConfigRun {
	
	@Bean
	public ServerInfo serverInfo(){
		ServerInfo info = new ServerInfo();
		info.setIpNum("192.168.0.2");
		info.setPortNum("80");
		return info;
	}
}
