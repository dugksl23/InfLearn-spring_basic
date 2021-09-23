package com.example.study_inflearn.beanFined;

import com.example.study_inflearn.hello_core.discount.DiscountPolicy;
import com.example.study_inflearn.hello_core.discount.FixDiscountPolicy;
import com.example.study_inflearn.hello_core.discount.RateDiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {

    private ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);


    @Test
    @DisplayName("부모 타입으로 조회시, 자시이 둘 이상 있으면 중복 오류가 발생")
    void findBeanByParentDuplicate() {

        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));

    }

    @Test
    @DisplayName("부모 타입으로 조회시, 자시이 둘 이상 있으면 key와 value 값으로 함수 이름과 타입을 지정")
    void findBeanByParentTypeAndBeanName() {

        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        Assertions.assertThat(rateDiscountPolicy).isInstanceOf(DiscountPolicy.class);

    }

    @Test
    @DisplayName("하위 타입인 구체 클래스 타입으로 조회")
    void findByBeanSubType() {
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        Assertions.assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
        // return 타입을 역할인 interface로 지정한다고 해서 반드시 역할 class가 return 되는 것은 아니다.
        // 실제 리턴은 구체 class이며, 사용하는 객체 타입으로 interface를 통한 다형성을 사용하는 것이다.
        // 따라서 실제 value 값을 통해서 return 타입을 지정할 떄에는 value의 return 타입을 기준으로 한다.
        // --> 그러나 역할과 구현을 분리해야 하기에 interface로 타입을 받는다.
    }

    @Configuration
    public static class TestConfig {
        // static일 경우, private 일 때에는 생성자 필요.

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }

    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findByParentType() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("역할 : " + s + ", " + "구현 : " + ac.getBean(s));
        }
    }


    @Test
    @DisplayName("최고 조상인 object 타입으로 조회")
    void findAllBeanByObjectType(){
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("역할 : " + s + ", " + "구현 : " + ac.getBean(s));
        }
    }
}
