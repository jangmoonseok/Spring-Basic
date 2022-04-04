package com.example.demo.common;

import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("request")
@Component
public class MyLogger {
	private String requestURL;
	private String uuid;
	
	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}
	
	
	public void log(String message) {
		System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
	} 
	
	
	@PostConstruct
	public void init() {
		uuid = UUID.randomUUID().toString();
		System.out.println("[" + uuid + "] request scope bean create " + this );
	}
	
	@PreDestroy
	public void detroy() {
		System.out.println("[" + uuid + "] request scope bean close " + this );		
	}
}
