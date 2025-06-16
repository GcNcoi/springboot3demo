package com.example.webflux.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月11日 11:38
 */
@Component
public class MyWebFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        System.out.println("请求处理放行到目标方法之前...");
        Mono<Void> filter = chain
                .filter(exchange)
                .doOnError(err -> {
                    System.out.println("请求处理异常...");
                })
                .doFinally(signalType -> {
                    System.out.println("请求处理放行到目标方法之后...");
                });
        return null;
    }
}
