package com.example.boot3.rpc.service;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

public interface SmsInterface {

    @PostExchange(url = "https://gyytz.market.alicloudapi.com/sms/smsSend", accept = "application/json")
    Mono<String> getSms(@RequestParam("mobile") String content,
                        @RequestParam("templateId") String template_id,
                        @RequestParam("smsSignId") String phone_number,
                        @RequestParam("param") String param);
}
