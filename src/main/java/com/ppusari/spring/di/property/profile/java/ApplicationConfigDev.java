package com.ppusari.spring.di.property.profile.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ppusari.spring.di.property.profile.xml.ServerInfo;
 
@Configuration
@Profile("dev")
public class ApplicationConfigDev {
	
	
	@Bean
	public ServerInfo serverInfo(){
		ServerInfo info = new ServerInfo();
		info.setIpNum("localhost");
		info.setPortNum("8181");
		return info;
	}
}
