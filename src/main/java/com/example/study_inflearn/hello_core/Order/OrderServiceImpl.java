package com.example.study_inflearn.hello_core.Order;

import com.example.study_inflearn.hello_core.discount.DiscountPolicy;
import com.example.study_inflearn.hello_core.member.Member;
import com.example.study_inflearn.hello_core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceImpl implements OrderService {




    @Autowired
    private final MemberRepository memberRepository; // 멤조 조회 및 멤버별 Grade 확인
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 고정 할인 정책

    // ==== 정율 할인 정책 적용 21.08.18 (수)
    @Autowired
    private final DiscountPolicy discountPolicy;


    // 즉 service의 구현체는 interface와의 의존관계만을 갖는다.
    //@Autowired
    // 21.10.20 생성자가 하나일 때에는 생략 가능.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("1. OrderServiceImpl 생성자 주입~");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("2. OrderServiceImpl MemberRepository 수정자 주입~");
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("2. OrderServiceImpl DiscountPolicy 수정자 주입~");
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member byId = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(byId, itemPrice);
        // 내부 로직에 대해선 모르지만, 멤버별 등급에 따른 가격의 할인 금액을
        // discount() 함수를 통해서 처리해달라고 하는 단일 책임 원칙을 준수하였다.
        // OCP의 확장성을 고려하여 itemPrice도 함께 넘긴다.
        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    ;

    // Singleton test를 위한 memoberRepository 함수
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


}
