package com.example.demo.discount;

import org.springframework.stereotype.Component;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

	private int discountFixAmount = 1000;
	
	
	@Override
	public int discount(Member member, int price) {
		if(member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		}else {
			return 0;
		}
	}
	
}
