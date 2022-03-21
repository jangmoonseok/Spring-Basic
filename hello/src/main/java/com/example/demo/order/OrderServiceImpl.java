package com.example.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.discount.DiscountPolicy;
import com.example.demo.discount.FixDiscountPolicy;
import com.example.demo.discount.RateDiscountPolicy;
import com.example.demo.member.Member;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService{

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	
	
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		super();
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}



	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		// 회원Id, 상품이름, 상품가격을 넘겨받아 주문을 만들기
		// => 회원Id로 회원을 조회해서 회원의 등급에 따른 할인가격을 정한다.
		// => 회원Id, 상품이름, 상품가격, 할인가격을 넘겨서 최종 주문정보를 반환한다.
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}


	//테스트용 코드
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
