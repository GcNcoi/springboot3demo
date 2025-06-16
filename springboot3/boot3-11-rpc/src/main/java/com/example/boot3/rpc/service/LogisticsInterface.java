package com.example.boot3.rpc.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface LogisticsInterface {

    @GetExchange(url = "https://kzexpress.market.alicloudapi.com/api-mall/api/express/query", accept = "application/json")
    Mono<String> getLogistics(@RequestParam("expressNo") String expressNo);

}
