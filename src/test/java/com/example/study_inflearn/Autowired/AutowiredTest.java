package com.example.study_inflearn.Autowired;

import com.example.study_inflearn.hello_core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOptionTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestBean.class);
        //Member bean = context.getBean(Member.class);

    }


    @Configuration
    static class TestBean {

        @Autowired(required = false)
        // required=true 로 해놓을 시에는, 의존관계가 없을 경우, 즉 Bean으로 등록되지 않았으면 'nsatisfiedDependencyException' Error 발생.
        // 따라서 유기적으로 사용되어야 할 경우에는, requrired=false로 하여, 메소드 호출 자체를 못하게 해야 한다.
        // 또는 Optional 또는 @NullAble 사용.
        public void setNoBean1(Member member1) {
            System.out.println("noBean1 : " + member1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("noBean2 : " + member);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("noBean3 : " + member);
        }

    }

}
