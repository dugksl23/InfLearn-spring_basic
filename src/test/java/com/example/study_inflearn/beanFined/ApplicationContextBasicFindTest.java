package com.example.study_inflearn.beanFined;

import com.example.study_inflearn.AppConfig;
import com.example.study_inflearn.hello_core.member.MemberService;

import com.example.study_inflearn.hello_core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationContextBasicFindTest {

    private ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName() {

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("구현체 타입으로만 조회 = value 값으로만 type 조회")
    public void findBeanByType() {


        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        // 두번째 방법도 구현 클래스를 직접 확인하고 return 하기에 가능하다. 다형성에 의해서
        // 하지만, DIP와 OCP에 의해서 확장에는 열려있고, 변화에는 닫혀있고, 또한 역할과 구현을 분리하고
        // 역할에만 의존해야 한다. 구현이 누구인지 알 볼필요도 없기에 되도록이면 인터페이스를 사용하자!
        // 구체 타입을 통한 조회는 유연성을 결여된다.

    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    public void findBeanByNameNotRegistered() {


        //MemberService memberService = ac.getBean("XXXX", MemberService.class);
        //assertThat(memberService).isInstanceOf(MemberService.class);
        // error code : NoSuchBeanDefinitionException
        // A : Exception, B : 실행 코드
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxx", MemberService.class));
    }

}
