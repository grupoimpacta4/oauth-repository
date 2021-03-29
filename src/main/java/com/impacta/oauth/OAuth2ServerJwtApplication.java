package com.impacta.oauth;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.impacta.oauth.jwt.controller.*;
import com.impacta.oauth.model.UserDto;


@EnableAutoConfiguration
@ComponentScan({"com.impacta","com.impacta.oauth","com.impacta.oauth.service","com.impacta.oauth.repository","com.impacta.oauth.controller","com.impacta.oauth.model","com.impacta.oauth.config.security"})
@SpringBootApplication
public class OAuth2ServerJwtApplication {

	public static void main(String... args) {
		SpringApplication.run(OAuth2ServerJwtApplication.class, args);
	}
	
	   
	@Bean
	void registerUserFirstToken() throws Exception {
		 UserDto user = new UserDto();
		 user.setUsername("user");
		 user.setPassword("pass");
		 user.setEnabled(1);
		 TokenController controle = new TokenController();
		 controle.saveUser(user);
		 
	}

}
