package com.example.study_inflearn.Singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StateFulServiceTest {

    @Test
    @DisplayName("statefulService")
    void stateFulService() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService stateFulService = ac.getBean("stateFulService", StateFulService.class);


        int 과자1 = stateFulService.order("과자", 1000);

        // ThreadA A사용자가 1000원 주문
        StateFulService stateFulService1 = ac.getBean("stateFulService", StateFulService.class);
        System.out.println("price : " + 과자1);

        // ThreadB B사용자 2000원 주문
        int 과자2 = stateFulService1.order("과자", 2000);
        System.out.println("price : " + 과자2);

        Assertions.assertThat(과자1).isEqualTo(과자2);
    }


    static class TestConfig {
        @Bean
        public static StateFulService stateFulService() {
            return new StateFulService();
        }

    }


}