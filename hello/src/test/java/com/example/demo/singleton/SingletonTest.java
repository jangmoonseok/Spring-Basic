package com.example.demo.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.AppConfig;
import com.example.demo.member.MemberService;

public class SingletonTest {
	@Test
	@DisplayName("스프링이 없는 순수한 DI컨테이너")
	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		// 조회 : 호출할 때 마다 객체를 생성
		MemberService memberService1 = appConfig.memberService();
		MemberService memberService2 = appConfig.memberService();
		
		// 참조값이 다른 것을 확인
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);
		
		// memberService1과 memberService2가 다르면 테스트 통과
		assertThat(memberService1).isNotSameAs(memberService2);
	}
	
	@Test
	@DisplayName("싱글톤 패턴을 적용한 객체 사용")
	void singletonServiceTest() {
//		new SingtonService(); // 생성자를 private으로 막아놨기 때문에 컴파일에러 발생
		SingletonService singletonService1 = SingletonService.getInstance();
		SingletonService singletonService2 = SingletonService.getInstance();
		
		// 참조값이 다른 것을 확인
		System.out.println("singletonService1 = " + singletonService1);
		System.out.println("singletonService2 = " + singletonService2);
				
		// singletonService1과 singletonService2가 같으면 테스트 통과
		assertThat(singletonService1).isSameAs(singletonService2);
	}
	
	@Test
	@DisplayName("스프링 컨테이너와 싱글톤")
	void springContainer() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		// 조회 : 호출할 때 마다 객체를 생성
		MemberService memberService1 = ac.getBean("memberService", MemberService.class);
		MemberService memberService2 = ac.getBean("memberService", MemberService.class);
		
		// 참조값이 다른 것을 확인
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);
		
		// memberService1과 memberService2가 다르면 테스트 통과
		assertThat(memberService1).isSameAs(memberService2);
	}
}
