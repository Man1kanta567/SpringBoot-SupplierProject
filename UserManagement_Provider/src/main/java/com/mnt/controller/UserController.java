package com.mnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mnt.model.User;
import com.mnt.service.IFeignUserService;
import com.mnt.service.UserService;

@RestController
public class UserController 
{
	
	@Autowired
	UserService service;
	
	
	
	
	@GetMapping("/one/{id}")
	public String getOneUserDetails(@PathVariable("id") String id)
	{
		return service.getUser(id);
	}
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User user)
	{
		
		return null;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteOne(@PathVariable("id") String id)
	{
		return null;
	}

}
