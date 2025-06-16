package com.example.springboot3.config;

import com.example.springboot3.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年05月12日 10:41
 */
@SpringBootConfiguration
public class AppConfig {

    @Bean
    @Scope("prototype")
    public User user() {
        var user = new User();
        user.setId(1);
        user.setName("张三");
        user.setAge(18);
        return user;
    }

}
