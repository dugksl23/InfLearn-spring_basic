package com.example.study_inflearn.XML;

import com.example.study_inflearn.hello_core.member.Member;
import com.example.study_inflearn.hello_core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlApplicationContext {

    @Test
    void xmlAppContext() {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
        // xml에서 등록된 bean들의 참조 class는 모두 구현체여야 한다.

    }



}
