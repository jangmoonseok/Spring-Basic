package com.example.demo.order;

import com.example.demo.discount.DiscountPolicy;
import com.example.demo.discount.FixDiscountPolicy;
import com.example.demo.member.Member;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		// ȸ��Id, ��ǰ�̸�, ��ǰ������ �Ѱܹ޾� �ֹ��� �����
		// => ȸ��Id�� ȸ���� ��ȸ�ؼ� ȸ���� ��޿� ���� ���ΰ����� ���Ѵ�.
		// => ȸ��Id, ��ǰ�̸�, ��ǰ����, ���ΰ����� �Ѱܼ� ���� �ֹ������� ��ȯ�Ѵ�.
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
