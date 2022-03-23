package com.example.demo.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import com.example.demo.scope.PrototypeTest.PrototypeBean;
import com.example.demo.scope.SingletonTest.SingletonBean;

public class PrototypeTest {

	@Test
	void prototypeBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
		
		System.out.println("find prototypeBean1");
		PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
		System.out.println("find prototypeBean2");
		PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
		
		System.out.println("prototypeBean1 = " + prototypeBean1);
		System.out.println("prototypeBean2 = " + prototypeBean2);
		
		assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
		
		ac.close();
	}
	
	@Scope("prototype")
	static class PrototypeBean{
		@PostConstruct
		public void init() {
			System.out.println("init");
		}
		
		@PreDestroy
		public void destroy() {
			System.out.println("destroy");
		}
	}
}
