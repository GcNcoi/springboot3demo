package com.example.springboot3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年05月12日 9:01
 */
@RestController
public class HelloController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/incy")
    public String incy(){
        Long incy = redisTemplate.opsForValue().increment("incy");
        return "增加后的值为："+incy;
    }

}
