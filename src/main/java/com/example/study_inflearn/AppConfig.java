package com.example.study_inflearn;

import com.example.study_inflearn.hello_core.Order.OrderServiceImpl;
import com.example.study_inflearn.hello_core.discount.FixDiscountPolicy;
import com.example.study_inflearn.hello_core.member.MemberService;
import com.example.study_inflearn.hello_core.member.MemberServiceImpl;
import com.example.study_inflearn.hello_core.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService(){

        return new MemberServiceImpl(new MemoryMemberRepository());

    }

    public OrderServiceImpl orderService(){

        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        // 20.08.23 (월(
        // new OrderServiceImpl()의 인터페이스는 부모 클래스로서, 구현체인 자식 클래스를 담을 수 있기에
        // 다형성을 통해서 return type이 OrderService 또는 OrderServiceImpl 모두 가능하다.
        // 그러나 구현체에 의존하지 않고, 역할인 interface와 의존관계를 갖기에 DIP를 지키고 있다.
        // 되는 OCP의 원칙에 따라서 interface를 권장한다.
        // 또한, OrderServiceImpl의 의존관계인 interface들은 구현체 class중 어떤 것들이 들어올지 모른다.
        // 그렇기에 OCP에도 지키고 있다.
    }

}
