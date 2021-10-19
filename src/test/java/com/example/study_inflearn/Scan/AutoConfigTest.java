package com.example.study_inflearn.Scan;

import com.example.study_inflearn.AutoAppConfig;
import com.example.study_inflearn.hello_core.member.MemberService;
import com.example.study_inflearn.hello_core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoConfigTest {


    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService bean = ac.getBean(MemberService.class);

        Assertions.assertThat(bean).isInstanceOf(MemberService.class);
        // instance의 주소값 비교는 .isInstanceOf() 사용!


    }
}
