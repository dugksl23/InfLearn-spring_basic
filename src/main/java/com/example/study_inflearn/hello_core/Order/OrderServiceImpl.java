package com.example.study_inflearn.hello_core.Order;

import com.example.study_inflearn.hello_core.discount.DiscountPolicy;
import com.example.study_inflearn.hello_core.discount.FixDiscountPolicy;
import com.example.study_inflearn.hello_core.member.Member;
import com.example.study_inflearn.hello_core.member.MemberRepository;
import com.example.study_inflearn.hello_core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository(); // 멤조 조회 및 멤버별 Grade 확인
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 고정 할인 정책

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member byId = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(byId, itemPrice);// 내부 로직에 대해선 모르지만, 멤버별 등급에 따른 가격의 할인 금액을
                                                                     // discount() 함수를 통해서 처리해달라고 하는 단일 책임 원칙을 준수하였다.
                                                                     // OCP의 확장성을 고려하여 itemPrice도 함께 넘긴다.
        return new Order(memberId, itemName, itemPrice, discountPrice);

    }


}
