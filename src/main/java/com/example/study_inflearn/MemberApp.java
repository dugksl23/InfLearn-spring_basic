package com.example.study_inflearn;

import com.example.study_inflearn.hello_core.member.Grade;
import com.example.study_inflearn.hello_core.member.Member;
import com.example.study_inflearn.hello_core.member.MemberService;
import com.example.study_inflearn.hello_core.member.MemberServiceImpl;


public class MemberApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        // command+option+V;
        memberService.join(member);

        memberService.findById(member.getId());
        Member findMember = new Member(2L, "memberB", Grade.BASIC);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getId());
    }

}
