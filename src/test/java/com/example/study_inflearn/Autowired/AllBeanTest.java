package com.example.study_inflearn.Autowired;

import com.example.study_inflearn.AppConfig;
import com.example.study_inflearn.AutoAppConfig;
import com.example.study_inflearn.hello_core.discount.DiscountPolicy;
import com.example.study_inflearn.hello_core.member.Grade;
import com.example.study_inflearn.hello_core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

public class AllBeanTest {


    @Test
    void findAllBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiscountService.class, AppConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("bean name : " + beanDefinitionName);
        }

        DiscountService disCountService = context.getBean(DiscountService.class);
        Member member = new Member(1L, "DD", Grade.VIP);
        int discount = disCountService.discount(member, 10000, "fixDiscountPolicy");


        Assertions.assertThat(disCountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(discount).isEqualTo(1000);
    }


    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;


        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;

            System.out.println("policyMap = " + policyMap);
            System.out.println("policyList = " + policyList);
            DiscountPolicy discountPolicy = policyMap.get("fixDiscountPolicy");


        }

        public int discount(Member member, int price, String discountKey) {
            DiscountPolicy discountPolicy = policyMap.get(discountKey);
            return discountPolicy.discount(member, price);
        }


    }

}
