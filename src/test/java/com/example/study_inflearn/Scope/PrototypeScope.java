package com.example.study_inflearn.Scope;

import com.example.study_inflearn.hello_core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class PrototypeScope {

    @Test
    public void findSingletonBean() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeScopeConfig.class);
        System.out.println("===== find member1 =======");
        Member getMember1 = ac.getBean("getMember", Member.class);
        System.out.println("===== find member1 : " + getMember1 + "=======");

        System.out.println("===== find member2 =======");
        Member getMember2 = ac.getBean("getMember", Member.class);
        System.out.println("===== find member2 : " + getMember2 + "=======");

        Assertions.assertThat(getMember1).isNotSameAs(getMember2);

        ac.close(); // 스프링 컨테이너와 종료와 함께 싱글톤 스코프를 가진 getMember bean은 스프링 컨테이너에거 종료되고 사라진다.


    }


    @Configuration
    public static class PrototypeScopeConfig { // * 12.03 static으로 메모리 적재도 되지 않았기에 build와 함께 스프링 빈을 찾으려고 해도 없을 수밖에...

        public PrototypeScopeConfig() {
        }

        @PostConstruct
        public void init() {
            System.out.println("singleton init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("singleton destroy");
        }

        @Bean // 12.03 직접 수동 등록이기에 @Bean으로 등록
        @Scope("prototype")
        public Member getMember() {
            return new Member();
        }


    }


}
