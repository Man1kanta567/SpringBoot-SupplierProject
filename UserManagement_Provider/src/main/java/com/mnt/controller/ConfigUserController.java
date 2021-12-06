package com.mnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mnt.model.ConfigUser;

@RestController
public class ConfigUserController 
{
	
	@Autowired
	ConfigUser user;
	
	@GetMapping("/user")
	public String getUserDetailsFromConfig()
	{
		return user.toString();
	}

}
