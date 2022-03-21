package com.example.demo.beanfind;



import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.AppConfig;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("�� �̸����� ��ȸ")
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class); 
	}
	
	@Test
	@DisplayName("�̸� ���� Ÿ�����θ� ��ȸ")
	void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);
		
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	
	@Test
	@DisplayName("��ü Ÿ������ ��ȸ")
	void findBeanByName2() {
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
		
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("�� �̸����� ��ȸX")
	void findBeanByNameX() {
		//assertThrows(Exception.class , runnable) : runnable �ڵ带 ������ �� ���ܰ� ������ ����
		assertThrows(NoSuchBeanDefinitionException.class, () -> {
			ac.getBean("xxxx", MemberService.class);
		});
	}
	
}















