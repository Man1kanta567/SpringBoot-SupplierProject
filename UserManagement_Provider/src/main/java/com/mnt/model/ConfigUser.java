package com.mnt.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "sample")
public class ConfigUser {

	private String id;
	private String name;
	private String address;
}
