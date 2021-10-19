package com.example.study_inflearn.hello_core.Filters;


import java.lang.annotation.*;

@Target(ElementType.TYPE) // 적용할 class 혹은 Field 로 주로 사용,
@Retention(RetentionPolicy.RUNTIME) // 지속 범위 > runtime 혹은 class 혹은 runtime
@Documented
public @interface MyExcludeComponent {
}
