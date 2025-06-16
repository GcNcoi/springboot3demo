package com.example.boot3.security.demos.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月04日 10:22
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Security!";
    }

    @PreAuthorize("hasAuthority('world_exec')")
    @GetMapping("/world")
    public String world() {
        return "Hello World Security!";
    }
}
