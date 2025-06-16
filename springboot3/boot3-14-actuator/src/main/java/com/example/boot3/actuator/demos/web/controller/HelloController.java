package com.example.boot3.actuator.demos.web.controller;

import com.example.boot3.actuator.demos.web.component.MyHahaComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月04日 14:41
 */
@RestController
public class HelloController {

    @Autowired
    MyHahaComponent myHahaComponent;

    @GetMapping("/hello")
    public String hello() {
        myHahaComponent.hello();
        return "HaHaHa!";
    }

}
