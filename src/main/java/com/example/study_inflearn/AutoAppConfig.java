package com.example.study_inflearn;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
// excluderFilters를 통해 AppConfig.class 제외. @Configuration에는 @Component 가 있기에 충돌 대상 된다.
public class AutoAppConfig {



}
