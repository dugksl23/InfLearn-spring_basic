package com.example.study_inflearn;

import com.example.study_inflearn.hello_core.Order.Order;
import com.example.study_inflearn.hello_core.Order.OrderService;
import com.example.study_inflearn.hello_core.Order.OrderServiceImpl;
import com.example.study_inflearn.hello_core.member.Grade;
import com.example.study_inflearn.hello_core.member.Member;
import com.example.study_inflearn.hello_core.member.MemberService;
import com.example.study_inflearn.hello_core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        // 1. 스프링 컨테이너 호출 및 환경설정 정보를 가진 AppConfig를 인자로 전달 for 빈등록
        //    *impl을 해도 무관하지만, class는 DIP에 따라 interface와의 의존관계를 위해서 인터페이스 인자로 전달.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        // 1. 멤버 생성 및 조회
        Long memberId = 1L;
        memberService.join(new Member(memberId, "memberA", Grade.VIP));
        Member byId = memberService.findById(memberId);

        // 2. 해당 멤버의 주문 및 조회
        String itemName = "itemA";
        int itemPrice = 20000;
        Order order = orderService.createOrder(memberId, itemName, itemPrice);
        System.out.println(order.toString());
        System.out.println("itemPrice : " + order.calculatePrice());


    }//psvm
}
