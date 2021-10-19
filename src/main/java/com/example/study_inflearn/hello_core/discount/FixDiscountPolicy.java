package com.example.study_inflearn.hello_core.discount;

import com.example.study_inflearn.hello_core.member.Grade;
import com.example.study_inflearn.hello_core.member.Member;
import org.springframework.stereotype.Component;


@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmount = 1000; // 1000원 만 할인.

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) { // enum은 == 를 쓰는 것이 옳다.
            return discountFixAmount;
        }

        return 0;
    }
}
