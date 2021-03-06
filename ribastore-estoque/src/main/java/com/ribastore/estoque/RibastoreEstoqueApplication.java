package com.ribastore.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableResourceServer
@EnableWebSecurity
@EnableSwagger2
public class RibastoreEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibastoreEstoqueApplication.class, args);
	}

}
