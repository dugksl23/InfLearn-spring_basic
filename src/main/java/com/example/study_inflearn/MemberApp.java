package com.example.study_inflearn;

import com.example.study_inflearn.hello_core.member.Grade;
import com.example.study_inflearn.hello_core.member.Member;
import com.example.study_inflearn.hello_core.member.MemberService;
import com.example.study_inflearn.hello_core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // 1. 스프링 컨테이너 호출 및 bean 등록
        // 스프링 컨테이너의 인자로, AppConfig 에서 설정한 환경설정 정보들을 넘겨준다.
        // AppConfig 라는 환경설정 class를 넘겨주면, 이를 가지고 @Bean 으로 등록된 것들을
        // 스프링 컨테이너에서 관리한다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 2. 스프링 컨테이너에서 싱글턴 빈을 가져오기.
        //    getBean()의 인자는 메소드 이름과 해당 type class를 전달 to be new
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        // command+option+V;
        memberService.join(member);

        memberService.findById(member.getId());
        Member findMember = new Member(2L, "memberB", Grade.BASIC);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getId());
    }

}
