package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // AppConfig appConfig = new AppConfig(); 과 동일
		
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // memberService = appConfig.memberService(); 과 동일
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("new member : " + member.getName());
		System.out.println("findMember : " + findMember.getName());
	}

}
