package com.example.demo.controller;

import com.example.demo.bean.Person;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年05月23日 16:02
 */
@Controller
public class WelcomeController {

    @GetMapping("/well")
    public String well(@RequestParam("name") String name,
                       Model model){
        model.addAttribute("name",name);
        return "welcome";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Person> list = Arrays.asList(
                new Person(1L, "zhangsan1", 15, "zs1@qq.com", "pm"),
                new Person(2L, "zhangsan2", 16, "zs2@qq.com", "pm"),
                new Person(3L, "zhangsan3", 17, "zs3@qq.com", "pm"),
                new Person(4L, "zhangsan4", 18, "zs4@qq.com", "admin"),
                new Person(5L, "zhangsan5", 19, "zs5@qq.com", "hr")
        );
        int i = 1/0;
        model.addAttribute("persons",list);
        return "list";
    }

}
