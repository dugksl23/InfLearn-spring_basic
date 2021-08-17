package com.example.study_inflearn.hello_core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // nullPointException 관계로 구현 객체를 지정해줘야 한다.
    // serviceImpl은 MemoryMemberRepository에 의존 관계를 갖는다.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
