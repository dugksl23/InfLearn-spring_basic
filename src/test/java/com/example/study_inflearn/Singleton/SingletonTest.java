package com.example.study_inflearn.Singleton;

import com.example.study_inflearn.AppConfig;
import com.example.study_inflearn.hello_core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {


    @Test
    @DisplayName("스프링이 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig config = new AppConfig();

        // 1. 조회 : 호출할 때마다 객체 생성
        MemoryMemberRepository memberRepository = config.getMemberRepository();

        //2. 조회 : 호출할 대마다 객체 생성
        MemoryMemberRepository memberRepository1 = config.getMemberRepository();

        // 3. 참조값이 다른지 확인
        System.out.println("memberRepository = "+memberRepository);
        System.out.println("memberRepository1 = "+memberRepository1);

        //Assertions.assertThat(memberRepository).isEqualTo(memberRepository1);
        // 4. memberRepository  != memberRepository
        Assertions.assertThat(memberRepository).isNotSameAs(memberRepository1);
    }

}
