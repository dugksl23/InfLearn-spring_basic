package com.example.study_inflearn.hello_core.discount;

import com.example.study_inflearn.hello_core.member.Member;

public interface DiscountPolicy {

    /**
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
    // f2는 에러 지점으로 이동.



}
