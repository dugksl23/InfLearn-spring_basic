package com.example.study_inflearn.Singleton;

public class SingletonService {

    private static SingletonService instance;

    private SingletonService() {
    }

    public static synchronized SingletonService getInstance() {

        if (instance == null) {
            instance = new SingletonService();
        }
        return instance;
    }

    public void logic(){
        System.out.println("인스턴스 유지");
    }


}
