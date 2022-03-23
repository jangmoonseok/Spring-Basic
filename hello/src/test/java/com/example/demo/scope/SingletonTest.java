package com.example.demo.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import com.example.demo.scope.SingletonTest.SingletonBean;

public class SingletonTest {
	@Test
	void singletonBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
		
		SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
		SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
		System.out.println("singletonBean1 = " + singletonBean1);
		System.out.println("singletonBean2 = " + singletonBean2);
		
		assertThat(singletonBean1).isSameAs(singletonBean2);
		
		ac.close();
	}
	
	@Scope("singleton")
	static class SingletonBean{
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
