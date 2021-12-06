package com.mnt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class UserService implements IUserService{

	@Autowired
	RestTemplate restTemplate;
	
	Logger logger=LoggerFactory.getLogger(UserService.class);
	
	@Override
	@HystrixCommand(fallbackMethod = "fallbackMethodForhHystrix")
	public String getUser(String id) {
		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	  ResponseEntity<String> user=	restTemplate.getForEntity("/one/"+id,String.class);
		return user.getBody();
	}
	
	public String fallbackMethodForhHystrix(String id,Throwable t)
	{
		logger.error("the  server has errors");
		return "error in the usermanagement provider project";
	}

}
