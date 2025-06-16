package com.example.boot3.rpc.controller;

import com.example.boot3.rpc.service.WeatherInterface;
import com.example.boot3.rpc.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月03日 10:14
 */
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public Mono<String> weather(@RequestParam("city") String city){
        Mono<String> weather = weatherService.weather(city);
        return weather;
    }

}
