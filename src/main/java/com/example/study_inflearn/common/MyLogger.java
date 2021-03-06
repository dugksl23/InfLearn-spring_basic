package com.example.study_inflearn.common;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // 12.04 interface일 경우에는 Target_INTERFACE
@Getter
@Setter
@Slf4j
@ToString
public class MyLogger {

    private String uuId;
    private String requestURL;

    public MyLogger() {
    }

    public void log(String message) {
        System.out.println(message);
        System.out.println("log : "+ this.toString());
    }

    @PostConstruct
    public void init() {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String dateString = format.format(new Date());
        //System.out.println("dateString :"+ dateString); // 20211204134603050
        String uuid = UUID.randomUUID().toString();
        //System.out.println("uuid :"+ uuid); // 2d4f58c9-771f-449b-a400-017e3114f49d
        uuid = String.format("%040d", new BigInteger(uuid.replace("-", ""), 16)); // - 없애기
        //System.out.println("uuid :"+ uuid); // 2d4f58c9-771f-449b-a400-017e3114f49d
        this.uuId = dateString + uuid.substring(uuid.length() - 8); // ex) 2021120413434350212094877

    }

    @PreDestroy
    public  void close(){
        System.out.println("close = " + this);
    }

}
