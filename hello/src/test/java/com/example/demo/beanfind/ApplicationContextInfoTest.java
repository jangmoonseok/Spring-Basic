package com.example.demo.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.AppConfig;

public class ApplicationContextInfoTest {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		@Test
		@DisplayName("��� �� ����ϱ�")
		void findAllBean() {
			String[] beanDefinitionNames = ac.getBeanDefinitionNames();
			
			for(String beanDefinitionName : beanDefinitionNames) {
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("name = " + beanDefinitionName + " object = " + bean);
			}
		}
		
		
		@Test
		@DisplayName("���ø����̼� �� ����ϱ�")
		void findApplicationAllBean() {
			String[] beanDefinitionNames = ac.getBeanDefinitionNames();
			
			for(String beanDefinitionName : beanDefinitionNames) {
				BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
				
				// Role ROLE_APPLICATION : ���� ����� ���ø����̼� ��
				// Role ROLE_INFRASTRUCTURE : �������� ���ο��� ����ϴ� ��
				
				if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {					
					Object bean = ac.getBean(beanDefinitionName);
					System.out.println("name = " + beanDefinitionName + " object = " + bean);
				}
			}
		}
}