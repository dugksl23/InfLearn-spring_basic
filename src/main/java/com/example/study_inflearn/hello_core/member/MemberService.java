package com.example.study_inflearn.hello_core.member;

public interface MemberService {

    void join(Member member); // 회원가입

    Member findById(Long memberId); // 회원 조회

}
