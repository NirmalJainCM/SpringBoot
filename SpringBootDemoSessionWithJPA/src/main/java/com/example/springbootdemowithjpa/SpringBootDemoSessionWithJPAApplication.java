package com.example.springbootdemowithjpa;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EntityScan(basePackages = { "com.example.springbootdemowithjpa" })
public class SpringBootDemoSessionWithJPAApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoSessionWithJPAApplication.class, args);
	}

	@Bean
	Docket configSwagger() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/menu/**"))
				.apis(RequestHandlerSelectors.basePackage("com.example.springbootdemowithjpa")).build()
				.apiInfo(
						new ApiInfo(
								"Menu Rest API",
								"The menu list for a particular restuarant",
								"1.0.11", 
								"Menu is really interesting",
								new Contact("Nirmal Jain C M", "www.nirmaljaincm.com", "nirmaljaincm@gmail.com"),
								"Standard Api License",
								"www.nirmaljaincm.com", 
								Collections.emptyList()
								)
						);
	}
}
