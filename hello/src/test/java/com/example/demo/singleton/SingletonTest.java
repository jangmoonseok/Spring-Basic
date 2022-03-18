package com.example.demo.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.AppConfig;
import com.example.demo.member.MemberService;

public class SingletonTest {
	@Test
	@DisplayName("�������� ���� ������ DI�����̳�")
	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		// ��ȸ : ȣ���� �� ���� ��ü�� ����
		MemberService memberService1 = appConfig.memberService();
		MemberService memberService2 = appConfig.memberService();
		
		// �������� �ٸ� ���� Ȯ��
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);
		
		// memberService1�� memberService2�� �ٸ��� �׽�Ʈ ���
		assertThat(memberService1).isNotSameAs(memberService2);
	}
	
	@Test
	@DisplayName("�̱��� ������ ������ ��ü ���")
	void singletonServiceTest() {
//		new SingtonService(); // �����ڸ� private���� ���Ƴ��� ������ �����Ͽ��� �߻�
		SingletonService singletonService1 = SingletonService.getInstance();
		SingletonService singletonService2 = SingletonService.getInstance();
		
		// �������� �ٸ� ���� Ȯ��
		System.out.println("singletonService1 = " + singletonService1);
		System.out.println("singletonService2 = " + singletonService2);
				
		// singletonService1�� singletonService2�� ������ �׽�Ʈ ���
		assertThat(singletonService1).isSameAs(singletonService2);
	}
	
	@Test
	@DisplayName("������ �����̳ʿ� �̱���")
	void springContainer() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		// ��ȸ : ȣ���� �� ���� ��ü�� ����
		MemberService memberService1 = ac.getBean("memberService", MemberService.class);
		MemberService memberService2 = ac.getBean("memberService", MemberService.class);
		
		// �������� �ٸ� ���� Ȯ��
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);
		
		// memberService1�� memberService2�� �ٸ��� �׽�Ʈ ���
		assertThat(memberService1).isSameAs(memberService2);
	}
}