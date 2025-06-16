package com.example.boot3.security.demos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月04日 10:29
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
