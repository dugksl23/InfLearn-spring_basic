package com.example.study_inflearn.beanFined;

import com.example.study_inflearn.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Optional;

public class ApplicationContextInfoTest {


    private ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    public void findAllBean() {

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        Arrays.stream(beanDefinitionNames).map(beanName -> {
                    Object bean = ac.getBean(beanName);
                    System.out.println("bean : " + beanName + ", object : " + bean);
                    return bean;
                }
        ).findAny();

    }


    @Test
    @DisplayName("빈 문자열 테스트")
    public void findBlankTest() {

        try {


            String ss = "";
            Optional<String> msg = Optional.ofNullable(ss);

            if (msg.isPresent()) {
                System.out.println(" 빈 문자열 허락한다.");
                throw new NullPointerException("null");
            }

        } catch (NullPointerException e) {

            System.out.println("catch 빈 문자열 허락한다");
            throw new NullPointerException("null");

        } finally {
            System.out.println("final?");
        }

    }

//    @Test
//    @DisplayName("등록된 빈만 출력하기")
//    public void findApplicationAllBean() {
//
//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//
//        for (String beanDefinitionName : beanDefinitionNames) {
//            BeanDefinition beanDefinition = ac.getBeanDefinition();
//
//
//            // ROLE_APPLICATION - 직접 등록한 애플리케이션 빈(스프링 빈)
//            // ROLE_INFRASTRUCTURE - 스프링이 내부에서 사용하는 빈
//            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
//                Object bean = ac.getBean(beanDefinitionName);
//                System.out.println("bean : " + beanDefinitionName + ", object : " + bean);
//            }
//        }
//
//    }

}
