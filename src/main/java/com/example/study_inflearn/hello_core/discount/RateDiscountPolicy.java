package com.example.study_inflearn.hello_core.discount;

import com.example.study_inflearn.hello_core.member.Grade;
import com.example.study_inflearn.hello_core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    // 등급에 따른 할인 정책율을 다르게 가져간다.
    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }

        return 0;

    }

    //test case 작성 - command +shift + t
}
