package com.mnt;

import java.net.URI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mnt.config.MainConfiguration;
import com.mnt.model.User;

@SpringBootApplication
@Import(MainConfiguration.class)
@EnableHystrix
@EnableHystrixDashboard
public class UserManagementProviderApplication {

	static RestTemplate restTemplate=new RestTemplate();
	
	public static void main(String[] args) {
		SpringApplication.run(UserManagementProviderApplication.class, args);
		 //String url="http://localhost:8080/save";
		 /* 
		 * getUserById(url,restTemplate); 
		 */
		 //addUser(url,restTemplate);
	}

	private static void addUser(String url, RestTemplate restTemplate2) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("content-type","application/json ");
		User user=new User();
        user.setId(6);
        user.setAddress("delhi");
        user.setUsername("sindhu");
        HttpEntity<Object> httpRequest=new HttpEntity<Object>(user,headers);
        
		/*
		 * restTemplate.postForEntity(url, user, String.class);
		 * restTemplate.delete(null); restTemplate.put(url, httpRequest, String.class);
		 * 
		 * restTemplate.postForObject(url, httpRequest, String.class);
		 * restTemplate.getForObject(null, null); restTemplate.patchForObject(null,
		 * httpRequest, null);
		 */
        
     URI uri=( restTemplate.postForLocation(url, httpRequest, String.class));
       System.out.println(uri.getPath());    
		/*
		 * ResponseEntity<String> response=
		 * restTemplate.getForEntity(url+"getOne/1",String.class);
		 * System.out.println(response.getBody());
		 */
	}

	private static void getUserById(String url, RestTemplate restTemplate2) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("content-type","application/json ");
		HttpEntity<Object> httpRequest=new HttpEntity<Object>(headers);		
		ResponseEntity<String> responseEntity=restTemplate.exchange(url+"getOne/1",HttpMethod.GET, httpRequest,String.class);
		String body=responseEntity.getBody();
		String status=responseEntity.getStatusCode().toString();
		System.out.println(body);
		System.out.println(status);
		
	}

}
