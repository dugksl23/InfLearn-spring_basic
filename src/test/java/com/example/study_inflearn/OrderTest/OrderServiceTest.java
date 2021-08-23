package com.example.study_inflearn.OrderTest;

import com.example.study_inflearn.AppConfig;
import com.example.study_inflearn.hello_core.Order.Order;
import com.example.study_inflearn.hello_core.Order.OrderService;
import com.example.study_inflearn.hello_core.Order.OrderServiceImpl;
import com.example.study_inflearn.hello_core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    public void OrderServiceTest() {

        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();

    }

    @Test
    public void orderCreateTest() {

        // given...
        // 1. 멤버 생성 및 조회
        Long memberId = 1L;
        memberService.join(new Member(memberId, "memberA", Grade.VIP));
        Member byId = memberService.findById(memberId);

        // 2. 해당 멤버의 주문 생성
        String itemName = "itemA";
        int itemPrice = 10000;

        // when...
        Order order = orderService.createOrder(memberId, itemName, itemPrice);

        // driven...
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }

}
