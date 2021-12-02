package com.mnt.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mnt.model.User;

@FeignClient(name = "feignUserService",url = "http://localhost:8080/")
public interface IFeignUserService 
{
	@GetMapping("getOne/{id}")
	public User getOne(@PathVariable("id") String id);
	
	@PostMapping("save")
	public String saveUser(@RequestBody HttpEntity httpEntity);
}
