package com.example.study_inflearn.hello_core.member;


public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);


}
