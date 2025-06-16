package com.example.boot3.security.demos.web.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月04日 10:15
 */
@EnableMethodSecurity
@Configuration
public class AppSecurityConfiguration {

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(registry -> {
            registry.requestMatchers("/").permitAll()
                    .anyRequest().authenticated();
        });
        http.formLogin(login -> {
            login.loginPage("/login").permitAll();
        });
        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails zhangsan = User.withUsername("zhangsan")
                .password(passwordEncoder.encode("123456"))
                .roles("admin", "hr")
                .authorities("file_read", "file_write")
                .build();

        UserDetails lisi = User.withUsername("lisi")
                .password(passwordEncoder.encode("123456"))
                .roles("hr")
                .authorities("file_write")
                .build();

        UserDetails wangwu = User.withUsername("wangwu")
                .password(passwordEncoder.encode("123456"))
                .roles("admin")
                .authorities("file_read", "world_exec")
                .build();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(zhangsan, lisi, wangwu);
        return manager;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
