package com.example.study_inflearn.Scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;


public class SingletonWithPrototype {


    @Test
    public void singletonWithPrototypeTest() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(config.class, PrototypeBean.class);

        System.out.println("=== bean 1 created ===");
        config bean1 = ac.getBean(config.class);
//        bean1.getPrototypeBean().addCount();
        Assertions.assertThat(bean1.getPrototypeBean()).isEqualTo(1);
        System.out.println("=== bean 1  count : " + bean1.getPrototypeBean());

        System.out.println("=== bean 2 created ===");
        config bean2 = ac.getBean(config.class);
//        bean2.getPrototypeBean().addCount();
        Assertions.assertThat(bean2.getPrototypeBean()).isEqualTo(1);
        System.out.println("=== bean 2  count : " + bean2.getPrototypeBean());
        ac.close();


    }


    @Scope("singleton")
    public static class config {

        //private PrototypeBean prototypeBean; // config 자체는 싱글턴이기에 생성 시점에 의존관계에 대해서 빈으로 등록된 해당 빈을 등록하고,
        // 이후엔 생성 시점에 주입된 prototypeBean의 스프링 빈을 사용하게 된다.

        //private final ObjectProvider<PrototypeBean> prototypeBeanObjectProvider;
        private Provider<PrototypeBean> provider;

        public config(Provider<PrototypeBean> provider) {
            this.provider = provider;
        }

        public int getPrototypeBean() {
            PrototypeBean object = provider.get();
            object.addCount();
            return object.getCount();
        }

        @PostConstruct
        public void init() {
            System.out.println("singleton init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("singleton destroy");
        }


    }

    @Scope("prototype")
    public static class PrototypeBean {

        private int count;

        public int getCount() {
            return count;
        }


        public void addCount() {
            count++;
        }

        @PreDestroy
        public void close() {
            System.out.println("종료");
        }

    }


}
