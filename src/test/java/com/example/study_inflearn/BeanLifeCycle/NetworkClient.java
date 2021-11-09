package com.example.study_inflearn.BeanLifeCycle;


import jdk.jfr.SettingDefinition;


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


}
