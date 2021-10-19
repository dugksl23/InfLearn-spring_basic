package com.example.study_inflearn;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.example.study_inflearn",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)
// 1. excluderFilters를 통해 AppConfig.class 제외. @Configuration에는 @Component 가 있기에 충돌 대상 된다.
// 2. componentScan의 범위를 basePackages를 통해 설정 가능.
//    default는 현재 ComponentScan의 AppConfig.class의 경로부터 시작된다.
//    지금은, com.example.study_inflearn 부터 default로 시작된다.
//    그렇기에 패키지 경로를 지정하지 않고, 제일 최상단 root에 등록해야 한다.
public class AutoAppConfig {



}
