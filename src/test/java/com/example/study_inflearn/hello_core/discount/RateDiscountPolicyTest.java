package com.example.study_inflearn.hello_core.discount;

import com.example.study_inflearn.hello_core.member.Grade;
import com.example.study_inflearn.hello_core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% 할인 적용 테스트")
    void joinAsVip() {

        // given...
        Member member = new Member();
        member.setGrade(Grade.VIP);
        member.setId(3L);
        member.setName("VIP Member");

        // when...
        int price = 10000;
        int discount = rateDiscountPolicy.discount(member, price);

        // then...
        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("VIP가 아닌 경우")
    void joinAsBasic() {

        // given...
        Member member = new Member();
        member.setGrade(Grade.BASIC);
        member.setId(3L);
        member.setName("Basic Member");

        // when...
        int price = 10000;
        int discount = rateDiscountPolicy.discount(member, price);

        // then...
        assertThat(discount).isEqualTo( 0);


        //* Assertion을 static import로 두고 assertThat을 사용하면 된다.
    }

}