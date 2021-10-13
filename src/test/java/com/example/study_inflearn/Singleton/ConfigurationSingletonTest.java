package com.example.study_inflearn.Singleton;

import com.example.study_inflearn.AppConfig;
import com.example.study_inflearn.hello_core.Order.OrderServiceImpl;
import com.example.study_inflearn.hello_core.member.MemberRepository;
import com.example.study_inflearn.hello_core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("getMemberRepository", MemberRepository.class);

        System.out.println("memberService.getMemberRepository : "+memberService.getMemberRepository());
        System.out.println("orderService.getMemberRepository : "+orderService.getMemberRepository());
        System.out.println("memberRepository : "+memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isEqualTo(orderService.getMemberRepository());
        Assertions.assertThat(memberRepository).isSameAs(orderService.getMemberRepository());
    }


}
