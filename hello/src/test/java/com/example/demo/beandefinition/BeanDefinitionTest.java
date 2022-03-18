package com.example.demo.beandefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.AppConfig;

public class BeanDefinitionTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("�� ���� ��Ÿ���� Ȯ��")
	void findApplicationAllBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		
		for(String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
			
			// Role ROLE_APPLICATION : ���� ����� ���ø����̼� ��
			// Role ROLE_INFRASTRUCTURE : �������� ���ο��� ����ϴ� ��
			
			if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {					
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("name = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
			}
		}
	}
}
