package com.example.boot3.rpc.controller;

import com.example.boot3.rpc.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月03日 15:19
 */
@RestController
public class LogisticsController {

    @Autowired
    LogisticsService logisticsService;

    @GetMapping("/logistics")
    public Mono<String> logistics(@RequestParam("expressNo") String expressNo){
        return logisticsService.getLogistics(expressNo);
    }

}
