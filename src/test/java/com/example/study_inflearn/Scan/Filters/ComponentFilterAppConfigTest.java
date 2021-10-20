package com.example.study_inflearn.Scan.Filters;


import com.example.study_inflearn.hello_core.Filters.BeanExclude;
import com.example.study_inflearn.hello_core.Filters.BeanInclude;
import com.example.study_inflearn.hello_core.Filters.MyExcludeComponent;
import com.example.study_inflearn.hello_core.Filters.MyIncludeComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.context.annotation.ComponentScan.Filter;

@SpringBootTest
public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanInclude beanInclude = ac.getBean("beanInclude", BeanInclude.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("bean : " + beanDefinitionName);
        }
        assertThat(beanInclude).isNotNull();
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("beanExclude", BeanExclude.class));

    }


    // custom componentScan 만들기
    @Configuration
    @ComponentScan(
            basePackages = "com.example.study_inflearn.hello_core",
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = {
                    @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class),
                    @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MyIncludeComponent.class)
            }
    )
    static class ComponentFilterAppConfig {

    }
}
