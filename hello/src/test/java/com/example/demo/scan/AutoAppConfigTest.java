package com.example.demo.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.AutoAppConfig;
import com.example.demo.member.MemberService;

public class AutoAppConfigTest {

	@Test
	void basicScan() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		
		MemberService bean = ac.getBean(MemberService.class);
		
		Assertions.assertThat(bean).isInstanceOf(MemberService.class);
	}
}
