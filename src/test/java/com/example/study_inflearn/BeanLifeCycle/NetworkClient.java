package com.example.study_inflearn.BeanLifeCycle;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println(" 서비스 연결 시도");
        connect();
        call("초기화 연결 시도");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    // 서비스 시작 호출시
    public void connect() {
        System.out.println("=== connect : " + url);
    }

    // 서비스 종료시
    public void disConnect() {
        System.out.println("=== disConnect : " + url + " =====");
    }

    // 서비스 연결 후 해당 네트워크 연결에 대한 서비스 로그
    public void call(String msg) {
        System.out.println("connect : " + url + ", call : " + msg);
    }

//    @Override //의존관계 주입 이후,빈이 생성된 시점에 호출되는 콜백함수 == @PostConstructor = InitializingBean,
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("www.hi.com");
//    }
//
//    @Override // 의존관계 주입 이후, 빈이 종료될 떄 호출
//    public void destroy() throws Exception {
//        System.out.println("close");
//        disConnect();
//    }


    @PostConstruct
    public void init(){
        connect();
        call("연결 성공");
    }

    @PreDestroy
    public void close(){
        disConnect();
    }
}
