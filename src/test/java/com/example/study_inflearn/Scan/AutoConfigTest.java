package com.example.study_inflearn.Scan;

import com.example.study_inflearn.AutoAppConfig;
import com.example.study_inflearn.hello_core.Order.OrderService;
import com.example.study_inflearn.hello_core.Order.OrderServiceImpl;
import com.example.study_inflearn.hello_core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoConfigTest {


    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("bean : " + beanDefinitionName);
        }

        MemberService bean = ac.getBean(MemberService.class);
        OrderService orderServiceImpl = ac.getBean("orderServiceImpl", OrderService.class);

        assertThat(orderServiceImpl).isInstanceOf(OrderServiceImpl.class);
        assertThat(bean).isInstanceOf(MemberService.class);
        // instance의 주소값 비교는 .isInstanceOf() 사용!


    }
}
