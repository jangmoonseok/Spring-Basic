package com.example.demo.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.AppConfig;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemberServiceImpl;
import com.example.demo.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

	@Test
	void configurationSingletonTest() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
		
		System.out.println("memberService -> memberRepository : " + memberService.getMemberRepository());
		System.out.println("orderService -> memberRepository : " + orderService.getMemberRepository());
		System.out.println("memberRepository : " + memberRepository);
		
		Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
		Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
	}
	
	@Test
	void configurationDeep() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		AppConfig bean = ac.getBean(AppConfig.class);
		
		System.out.println("bean : " + bean.getClass());
	}
	
}
