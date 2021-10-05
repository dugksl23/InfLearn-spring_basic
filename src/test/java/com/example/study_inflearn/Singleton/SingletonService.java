package com.example.study_inflearn.Singleton;

public class SingletonService {

    private static SingletonService instance;

    private SingletonService() {
    }

    public static synchronized SingletonService getInstance() {

        if (instance == null) {//지연 로딩
            instance = new SingletonService();
        }
        // 즉시로딩은 바로 private static에 new 한다.
용        //
        return instance;
    }

    public void logic(){
        System.out.println("인스턴스 유지");
    }


}
