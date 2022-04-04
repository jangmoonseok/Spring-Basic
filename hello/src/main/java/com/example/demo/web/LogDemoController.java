package com.example.demo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.MyLogger;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
	private final ObjectProvider<MyLogger> myLoggerProvider;
//	private final MyLogger myLogger;	
	private final LogDemoService logDemoService;
	
	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		MyLogger myLogger = myLoggerProvider.getObject();
		String requestURL = request.getRequestURL().toString();
		myLogger.setRequestURL(requestURL);
		
		myLogger.log("controller test");
		logDemoService.logic("testId");
		return "OK";
	}
}
