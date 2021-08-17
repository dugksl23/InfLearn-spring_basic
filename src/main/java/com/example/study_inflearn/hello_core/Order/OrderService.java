package com.example.study_inflearn.hello_core.Order;

public interface OrderService { // 이름 수정 option + enter

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
