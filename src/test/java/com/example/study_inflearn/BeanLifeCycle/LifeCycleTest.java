package com.example.study_inflearn.BeanLifeCycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LifeCycleTest {

    @Test
    void connectTest() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleApp.class);
        NetworkClient netWorkClient = context.getBean("networkClient", NetworkClient.class);
        context.close();

    }

    @Configuration
    static class LifeCycleApp {

        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClient networkClient() {
            NetworkClient client = new NetworkClient();
            client.setUrl("hi");
            return client;
        }

    }



    @Test
    void rolloverTest(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);


        cal.add(Calendar.HOUR, 1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String str = sdf.format(cal.getTimeInMillis());

        System.out.println(" time : " + str);


    }
}
