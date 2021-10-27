package com.example.study_inflearn.hello_core.Order;

import com.example.study_inflearn.hello_core.discount.DiscountPolicy;
import com.example.study_inflearn.hello_core.member.Member;
import com.example.study_inflearn.hello_core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; // 멤조 조회 및 멤버별 Grade 확인
    private final DiscountPolicy discountPolicy;

    // 즉 service의 구현체는 interface와의 의존관계만을 갖는다.
    //@Autowired
    // 21.10.20 생성자가 하나일 때에는 생략 가능.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy DiscountPolicy) {
        System.out.println("1. OrderServiceImpl 생성자 주입~");
        this.memberRepository = memberRepository;
        this.discountPolicy = DiscountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member byId = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(byId, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    // Singleton test를 위한 memoberRepository 함수
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


}
