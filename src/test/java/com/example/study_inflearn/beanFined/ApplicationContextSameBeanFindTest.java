package com.example.study_inflearn.beanFined;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import com.example.study_inflearn.AppConfig;
import com.example.study_inflearn.hello_core.discount.DiscountPolicy;
import com.example.study_inflearn.hello_core.discount.FixDiscountPolicy;
import com.example.study_inflearn.hello_core.discount.RateDiscountPolicy;
import com.example.study_inflearn.hello_core.member.MemberService;
import com.example.study_inflearn.hello_core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextSameBeanFindTest {

    private ApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("동일 타입이 2개 이상일 시, 중복 오류 발생 테스")
    public void findBeanByTypeDuplicate() {

//        DiscountPolicy xxx = ac.getBean(DiscountPolicy.class);
//        assertThat(xxx).isInstanceOf(DiscountPolicy.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class
                , () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("동일 타입이 2개 이상일 시, key값과 value 값으로 조회 = bean 이름(메소드 이름)으로 조회")
    public void findBeanByBeanName() {

        DiscountPolicy xxx = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(xxx).isInstanceOf(DiscountPolicy.class);

    }

    @Test
    @DisplayName("동일 타입이 2개 이상일 시, 해당 타입의 bean을 모두 호출하기")
    void findBeanByAllBean() {

        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("key : " + s + ", " + "value : " + beansOfType.get(s));
        }
        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);


    }


    @Configuration
    static class SameBeanConfig {
        // public 일 경우에는 static이더라도 생성자 필요.

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }

    }

}


