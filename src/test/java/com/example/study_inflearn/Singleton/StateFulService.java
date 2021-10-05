package com.example.study_inflearn.Singleton;

import java.sql.SQLOutput;

public class StateFulService {


    private int price; // 상태를 유지하는 필드
    // 멤버필드는 class 내에서는 공유변수로 전역변수의 역할을 한다.
    // 싱글턴에서 필드가 공유되면, 요청이 올 때마다 값이 초기화가 이루어진다는 단점이 생긴다.
    // 사용자는 멀티쓰레드 환경에서 각각 요청을 하게 된다. 그러나 요청을 받고 처리하는 객체는 싱글턴으로 하나만 생성이 되고 공유된다.
    // 이때 공유필드를 통해서 요청 시마다 초기화가 이루어진다면, 마지막 요청의 값을 반환하기에 사용자에게 혼란을 초래한다.
    // ==> 지역 변수, 즉 함수 내에서마 사용되고 메모리에서 사라지는 지역변수를 사용하여 해결 가능하다.

    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        //this.price = price;

        return price;
    }

    public void getPrice(int price) {
//        return price;
    }
}
