package com.example.springboot3;

import com.example.springboot3.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot3Application {

    public static void main(String[] args) {
        var ioc = SpringApplication.run(Springboot3Application.class, args);
        String[] beanNamesForType = ioc.getBeanNamesForType(User.class);
        for (String beanName : beanNamesForType) {
            System.out.println(beanName);
        }
        User user1 = ioc.getBean(User.class);
        User user2 = ioc.getBean(User.class);
        System.out.println(user1 == user2);
    }

}
