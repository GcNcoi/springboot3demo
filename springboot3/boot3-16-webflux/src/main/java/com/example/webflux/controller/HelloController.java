package com.example.webflux.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.result.view.Rendering;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月11日 10:41
 */
@RestController
//@Controller
public class HelloController {

    @GetMapping("/hello")
    public Mono<String> hello(@RequestParam(value = "key", required = false, defaultValue = "哈哈") String key,
                              ServerWebExchange exchange,
                              WebSession webSession,
                              HttpMethod httpMethod) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        Object aaa = webSession.getAttribute("aaa");
        webSession.getAttributes().put("aaa", "bbb");

        String name = httpMethod.name();

        return Mono.just("Hello WebFlux!" + key);
    }

    @GetMapping("/bai")
    public Rendering render() {
        return Rendering.redirectTo("http://www.baidu.com").build();
    }

    @GetMapping("/haha")
    public Mono<String> hello() {
        return Mono.just(0)
                .map(i -> 10 / i)
                .map(i -> "Hello WebFlux!");
    }

}
