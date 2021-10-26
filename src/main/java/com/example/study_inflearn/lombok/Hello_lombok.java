package com.example.study_inflearn.lombok;


import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor // default Consturctor 및 final 관련 field만을 모은 생성자 만든다.
public class Hello_lombok {

    private final String name;
    private final int age;

    public static void main(String[] args) {

        Hello_lombok lombok = new Hello_lombok("dd",1);

    }
}
