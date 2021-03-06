package com.example.demo.singleton;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

	@Test
	void statefulServiceSingleton() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
	
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);
		
		// A사용자 10000원 주문
//		statefulService1.order("userA", 10000);
		// B사용자 20000원 주문
//		statefulService2.order("userB", 20000);
		
		// A사용자가 주문 금액 조회
		int priceA = statefulService1.order("userA", 10000);
		int priceB = statefulService2.order("userB", 20000);
		System.out.println("price : " + priceA);
		
//		assertThat(statefulService1.getPrice()).isEqualTo(20000);
	}
	
	static class TestConfig{
		
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}

}
