package com.example.study_inflearn.BeanLifeCycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class LifeCycleTest {

    @Test
    void connectTest() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleApp.class);
        NetworkClient netWorkClient = context.getBean("networkClient", NetworkClient.class);
        System.out.println(netWorkClient.getUrl());
        netWorkClient.connect();

    }


    @Configuration
    static class LifeCycleApp {

        @Bean
        public NetworkClient networkClient() {
            NetworkClient client = new NetworkClient();
            client.setUrl("hi");
            return client;
        }

    }
}
