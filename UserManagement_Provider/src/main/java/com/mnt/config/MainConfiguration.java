package com.mnt.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class MainConfiguration 
{
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder)
	{
		UriTemplateHandler uriHandler=new RootUriTemplateHandler("http://localhost:8080");
		return builder.uriTemplateHandler(uriHandler).setReadTimeout(Duration.ofMillis(1000)).build();
	}
	
	@Bean
	public Docket getDocket()
	{
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mnt.controller"))
				.build();
	}
	
	

}
