package com.example.study_inflearn.duplicateBeanTest;


import com.example.study_inflearn.AppConfig;
import com.example.study_inflearn.hello_core.member.MemberRepository;
import com.example.study_inflearn.hello_core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.context.annotation.ComponentScan.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DuplicateBeanNameTest {


    @Test
    void duplicateBeanNameTest() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(duplicateBeanConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("bean name : " + beanDefinitionName);
        }

        MemoryMemberRepository memoryMemberRepository = ac.getBean("memoryMemberRepository", MemoryMemberRepository.class);
        //Assertions.assertThat(memoryMemberRepository).isNotSameAs(duplicateA.class);

    }


    @Configuration
    @ComponentScan(
            basePackages = "com.example.study_inflearn.hello_core",
            excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = AppConfig.class)
    )
    static class duplicateBeanConfig {


        @Bean(name = "memoryMemberRepository")
        public MemberRepository getMemberRepository(){
            return new MemoryMemberRepository();
        }

    }








}
