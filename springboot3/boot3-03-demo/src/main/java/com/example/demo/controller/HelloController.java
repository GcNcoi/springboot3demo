package com.example.demo.controller;

import com.example.demo.bean.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年05月12日 16:13
 */
@Slf4j
@RestController
@Tag(name = "hello测试接口", description = "infoTest")
public class HelloController {

    @Autowired
    private MessageSource messageSource;

    @Operation(description = "测试info打印", summary = "测试info打印")
    @GetMapping("/h")
    public String hello(String a, String b){

        log.trace("trace 日志...");
        log.debug("debug 日志...");
        log.info("info 日志...,a={},b={}",a,b);
        log.warn("warn 日志...");
        log.error("error 日志...");
        return "Hello World";
    }

    @GetMapping("/person")
    public Person person(){
        Person person = new Person();
        person.setId(1L);
        person.setName("张三");
        person.setAge(18);
        person.setEmail("2284467180@qq.com");
        return person;
    }

    @GetMapping("/getMsgResource")
    public String getMsgResource(HttpServletRequest request) {
        Locale locale = request.getLocale();
        String login = messageSource.getMessage("login", null, locale);
        return login;
    }

}
