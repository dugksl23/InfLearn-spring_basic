package com.example.study_inflearn.Autowired;

import com.example.study_inflearn.hello_core.Order.OrderService;
import com.example.study_inflearn.hello_core.Order.OrderServiceImpl;
import com.example.study_inflearn.hello_core.discount.FixDiscountPolicy;
import com.example.study_inflearn.hello_core.member.Grade;
import com.example.study_inflearn.hello_core.member.Member;
import com.example.study_inflearn.hello_core.member.MemberServiceImpl;
import com.example.study_inflearn.hello_core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

public class 수정자주입Test {

    @Test
    void createOrder(){

        MemberServiceImpl memberService = new MemberServiceImpl(new MemoryMemberRepository());
        Member member = new Member(1L, "MEMBER1", Grade.VIP);
        memberService.join(member);

        OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        orderService.createOrder(1L, "ANY", 100);
    }
}
