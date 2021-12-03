package com.example.study_inflearn;

import com.example.study_inflearn.hello_core.Order.OrderServiceImpl;
import com.example.study_inflearn.hello_core.discount.DiscountPolicy;
import com.example.study_inflearn.hello_core.discount.FixDiscountPolicy;
import com.example.study_inflearn.hello_core.discount.RateDiscountPolicy;
import com.example.study_inflearn.hello_core.member.MemberService;
import com.example.study_inflearn.hello_core.member.MemberServiceImpl;
import com.example.study_inflearn.hello_core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class AppConfig {

    //* 역할과 구현을 분리했으며, config에서는 각각의 각각의 역할에 따른 구현 캘르가 모두 드러나야 한다.
    //  -> 나중에 jpa를 통해 db를 교체할 때는 함수별 역할만 코드를 수정하면 된다.


    // 멤버 서비스 역할
    @Bean
    public MemberService memberService() {

        return new MemberServiceImpl(getMemberRepository());

    }

    // 멤버 repositorty 역할
    @Bean // 스프링 컨테이너에 등록
    public MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    // order service 역할
    @Bean
    public OrderServiceImpl orderService() {

        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
        // 20.08.23 (월(
        // new OrderServiceImpl()의 인터페이스는 부모 클래스로서, 구현체인 자식 클래스를 담을 수 있기에
        // 다형성을 통해서 return type이 OrderService 또는 OrderServiceImpl 모두 가능하다.
        // 그러나 구현체에 의존하지 않고, 역할인 interface와 의존관계를 갖기에 DIP를 지키고 있다.
        // 그리고 OCP의 원칙에 따라서 interface를 권장한다.
        // 또한, OrderServiceImpl의 의존관계인 interface들은 구현체 class중 어떤 것들이 들어올지 모른다.
        // 그렇기에 OCP에도 지키고 있다.
    }

    @Bean
    public DiscountPolicy getDiscountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
        // 2021.09.06 적용하고 싶은 discountPolicy에 따라서
        // config에서 policy를 변경해주면, 사용역에 있는 코드들은 변경하지 않아도 된다.
        // ex) ord erServiceImpl 의 interface에 직접 관여하지 않아도 된다.
        // 구성영역의 코드만 수정해주면 된다.
        // dip를 통해 역할과 구현을 분리하고, interface (추상화)와 의존관계를 가져가고 있다.
        // ocp를 통해서 확장으는 open, 변경에는 close

    }


    @Bean
    public DiscountPolicy rateDiscountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
        // 2021.09.06 적용하고 싶은 discountPolicy에 따라서
        // config에서 policy를 변경해주면, 사용역에 있는 코드들은 변경하지 않아도 된다.
        // ex) ord erServiceImpl 의 interface에 직접 관여하지 않아도 된다.
        // 구성영역의 코드만 수정해주면 된다.
        // dip를 통해 역할과 구현을 분리하고, interface (추상화)와 의존관계를 가져가고 있다.
        // ocp를 통해서 확장으는 open, 변경에는 close

    }

    @Bean
    public DiscountPolicy fixDiscountPolicy() {
        //return new FixDiscountPolicy();
        return new FixDiscountPolicy();
        // 2021.09.06 적용하고 싶은 discountPolicy에 따라서
        // config에서 policy를 변경해주면, 사용역에 있는 코드들은 변경하지 않아도 된다.
        // ex) ord erServiceImpl 의 interface에 직접 관여하지 않아도 된다.
        // 구성영역의 코드만 수정해주면 된다.
        // dip를 통해 역할과 구현을 분리하고, interface (추상화)와 의존관계를 가져가고 있다.
        // ocp를 통해서 확장으는 open, 변경에는 close

    }




}
