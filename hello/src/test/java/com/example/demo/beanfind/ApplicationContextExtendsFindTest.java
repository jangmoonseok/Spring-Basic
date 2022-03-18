package com.example.demo.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.beanfind.ApplicationContextSameBeanFindTest.SameBeanConfig;
import com.example.demo.discount.DiscountPolicy;
import com.example.demo.discount.FixDiscountPolicy;
import com.example.demo.discount.RateDiscountPolicy;

public class ApplicationContextExtendsFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

	@Test
	@DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생")
	void findBeanByParentTypeDuplicate() {
		assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
	}
	
	@Test
	@DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면 빈 이름을 지정한다.")
	void findBeanByParentTypeBeanName() {
		DiscountPolicy bean = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
		assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
	}
	
	@Test
	@DisplayName("특정 하위 타입으로 조회")
	void findBeanBySubType() {
		RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
		assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
	}
	
	@Test
	@DisplayName("부모 타입으로 모두 조회하기")
	void findAllBeanByParentType() {
		Map<String,DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
		assertThat(beansOfType.size()).isEqualTo(2);
		
		for(String key : beansOfType.keySet()) {
			System.out.println("key = " + key + " value = " + beansOfType.get(key));
		}
	}
	
	@Test
	@DisplayName("부모 타입으로 모두 조회하기 - Object")
	void findAllBeanByObjectType() {
		Map<String,Object> beansOfType = ac.getBeansOfType(Object.class);
		
		for(String key : beansOfType.keySet()) {
			System.out.println("key = " + key + " value = " + beansOfType.get(key));
		}
		
	}
	@Configuration
	static class TestConfig{
		@Bean
		public DiscountPolicy rateDiscountPolicy() {
			return new RateDiscountPolicy();
		}
		
		@Bean
		public DiscountPolicy fixDiscountPolicy() {
			return new FixDiscountPolicy();
		}
	}
}
