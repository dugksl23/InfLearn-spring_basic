package com.example.study_inflearn.memberTest;

import com.example.study_inflearn.hello_core.member.Grade;
import com.example.study_inflearn.hello_core.member.Member;
import com.example.study_inflearn.hello_core.member.MemberService;
import com.example.study_inflearn.hello_core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class memberServiceTest {

    MemberService memberService = new MemberServiceImpl();
    // 현재 MemberService 는 memberService는  memberService 인터페이스와 의좐 관계를 가지며
    // memerService는 memberRepository의 구현체인 MemoryMemberRepository와 의존관계를 가진다.
    // 추상화에도 의존하며, 구현체에도 의존한다. 또한 변경에 닫혀있어야 하지만, 변경이 쉽지 않다.
    // ==> DIP 원칙에 어긋나며, 유지보수 (변경) 측면에서도 OCP 원칙에도 어긋난다.

    @Test
    @DisplayName("join member test")
    void join() {

        //given...
        Member memberA = new Member(1L, "memberA", Grade.VIP);

        //when...
        memberService.join(memberA);
        Member byId = memberService.findById(2L);

        //given...
        Assertions.assertThat(byId.equals(memberA));

    }

}