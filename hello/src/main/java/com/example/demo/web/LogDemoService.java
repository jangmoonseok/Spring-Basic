package com.example.demo.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import com.example.demo.common.MyLogger;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {
	private final ObjectProvider<MyLogger> myLoggerProvider;
//	private final MyLogger myLogger;
	
	public void logic(String id) {
		MyLogger myLogger = myLoggerProvider.getObject();
		myLogger.log("service id = " + id);
	}

}
