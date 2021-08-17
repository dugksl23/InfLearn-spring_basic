package com.example.study_inflearn;

import com.example.study_inflearn.hello_core.Order.Order;
import com.example.study_inflearn.hello_core.Order.OrderService;
import com.example.study_inflearn.hello_core.Order.OrderServiceImpl;
import com.example.study_inflearn.hello_core.member.Grade;
import com.example.study_inflearn.hello_core.member.Member;
import com.example.study_inflearn.hello_core.member.MemberService;
import com.example.study_inflearn.hello_core.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        // 1. 멤버 생성 및 조회
        Long memberId = 1L;
        memberService.join(new Member(memberId, "memberA", Grade.VIP));
        Member byId = memberService.findById(memberId);

        // 2. 해당 멤버의 주문 및 조회
        String itemName = "itemA";
        int itemPrice = 10000;
        Order order = orderService.createOrder(memberId, itemName, itemPrice);
        System.out.println(order.toString());
        System.out.println("itemPrice : " + order.calculatePrice());


    }//psvm
}
